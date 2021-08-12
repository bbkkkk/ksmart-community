package com.ksmart.pms.biz.service.impl;

import cn.hutool.core.date.DateUtil;
import com.ksmart.common.dto.Condition;
import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.util.KUtil;
import com.ksmart.pms.api.dto.UserDTO;
import com.ksmart.pms.biz.dao.UserDao;
import com.ksmart.pms.biz.domain.User;
import com.ksmart.pms.biz.service.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.sql.Timestamp;
import java.util.*;

@Log4j2
@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;


    @Override
    public int insert(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userDao.save(user);
        return 1;
    }

    @Override
    public int update(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userDao.save(user);
        return 1;
    }

    @Override
    public int delete(String id) {
        userDao.delete(new User().setId(id));
        return 1;
    }

    @Override
    public UserDTO get(String id) {
        Optional<User> optional = userDao.findOne(Example.of(new User().setId(id)));
        UserDTO userDTO = new UserDTO();
        optional.ifPresent(user -> BeanUtils.copyProperties(user, userDTO));
        log.debug("返回结果 {}", userDTO);
        return userDTO;
    }

    @Override
    public List<UserDTO> query(String input) {
        List<User> userList = userDao.findUserByUserNameLike(input);
        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO userDTO;
        for (int i = 0; i < userList.size(); i++) {
            userDTO = new UserDTO();
            BeanUtils.copyProperties(userList.get(i), userDTO);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public PageData<User> queryPage(PageDTO pageDTO) {

        int currentPage = pageDTO.getCurrentPage();
        int pageSize = pageDTO.getPageSize();
        List<Condition> conditionList = pageDTO.getConditions();
        Map<String, Condition> conditionMap = KUtil.pageConditionList2Map(conditionList);
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize, sort);
        //一定放在pageRequest之后
        currentPage = currentPage + 1;
        Specification<User> specification = (Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {
            // 查询条件的集合
            List<Predicate> list = new ArrayList<>();
            //名称模糊匹配
            if (KUtil.pageConditionIsNotBlank("name", conditionMap)) {
                Path<String> namePath = root.get("name");
                list.add(criteriaBuilder.like(namePath, "%" + conditionMap.get("name").getValue() + "%"));
            }
            // 判断大于数字
            if (KUtil.pageConditionIsNotBlank("sex", conditionMap)) {
                Path<Integer> sexPath = root.get("sex");
                list.add(criteriaBuilder.greaterThanOrEqualTo(sexPath, Integer.parseInt(String.valueOf(conditionMap.get("sex").getValue()))));
            }
            // 时间判断
            Path<Timestamp> createTimePath = root.get("createTime");
            if (KUtil.pageConditionIsNotBlank("startTime", conditionMap) && !KUtil.pageConditionIsNotBlank("endTime", conditionMap)) {
                Date startTime = DateUtil.parse(String.valueOf(conditionMap.get("startTime").getValue()), "yyyy-MM-dd");
                list.add(criteriaBuilder.greaterThanOrEqualTo(createTimePath, startTime));
            } else if (KUtil.pageConditionIsNotBlank("endTime", conditionMap) && !KUtil.pageConditionIsNotBlank("startTime", conditionMap)) {
                Date endTime = DateUtil.parse(String.valueOf(conditionMap.get("endTime").getValue()), "yyyy-MM-dd");
                list.add(criteriaBuilder.lessThanOrEqualTo(createTimePath, endTime));
            } else if (KUtil.pageConditionIsNotBlank("startTime", conditionMap) && KUtil.pageConditionIsNotBlank("endTime", conditionMap)) {
                Date startTime = DateUtil.parse(String.valueOf(conditionMap.get("startTime").getValue()), "yyyy-MM-dd");
                Date endTime = DateUtil.parse(String.valueOf(conditionMap.get("endTime").getValue()), "yyyy-MM-dd");
                list.add(criteriaBuilder.between(createTimePath, startTime, endTime));
            }
            // 转数组
            Predicate[] predicates = new Predicate[list.size()];
            list.toArray(predicates);
            return criteriaBuilder.and(predicates);
        };

        // 指定排序和分页
        Page<User> page = userDao.findAll(specification, pageRequest);
        log.debug(page.getNumber());
        log.debug(page.getNumberOfElements());
        log.debug(page.getSize());
        log.debug(page.getTotalElements());
        log.debug(page.getTotalPages());
        return PageData.<User>getInstance(currentPage, pageSize, page.getTotalElements(), page.getContent());
    }

}
/**
 * //创建匹配器，即如何使用查询条件
 * ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
 * .withMatcher("materialName", GenericPropertyMatchers.contains()) //姓名采用“开始匹配”的方式查询
 * .withMatcher("registerTime", GenericPropertyMatchers.contains()) //姓名采用“开始匹配”的方式查询
 * .withMatcher("status", GenericPropertyMatchers.contains()) //姓名采用“开始匹配”的方式查询
 * .withIgnorePaths("id");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
 */