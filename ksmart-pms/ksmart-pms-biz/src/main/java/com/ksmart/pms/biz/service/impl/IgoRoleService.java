package com.ksmart.pms.biz.service.impl;

import cn.hutool.core.date.DateUtil;
import com.ksmart.common.dto.Condition;
import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.util.KUtil;
import com.ksmart.pms.api.dto.IgoRoleDTO;
import com.ksmart.pms.biz.dao.IgoRoleDao;
import com.ksmart.pms.biz.domain.IgoRole;
import com.ksmart.pms.biz.service.IIgoRoleService;
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
public class IgoRoleService implements IIgoRoleService {

    @Autowired
    private IgoRoleDao igoRoleDao;


    @Override
    public int insert(IgoRoleDTO igoRoleDTO) {
        IgoRole igoRole = new IgoRole();
        BeanUtils.copyProperties(igoRoleDTO, igoRole);
        igoRoleDao.save(igoRole);
        return 1;
    }

    @Override
    public int update(IgoRoleDTO igoRoleDTO) {
        IgoRole igoRole = new IgoRole();
        BeanUtils.copyProperties(igoRoleDTO, igoRole);
        igoRoleDao.save(igoRole);
        return 1;
    }

    @Override
    public int delete(String id) {
        igoRoleDao.delete(new IgoRole().setId(id));
        return 1;
    }

    @Override
    public IgoRoleDTO get(String id) {
        Optional<IgoRole> optional = igoRoleDao.findOne(Example.of(new IgoRole().setId(id)));
        IgoRoleDTO igoRoleDTO = new IgoRoleDTO();
        optional.ifPresent(igoRole -> BeanUtils.copyProperties(igoRole, igoRoleDTO));
        log.debug("θΏεη»ζ {}", igoRoleDTO);
        return igoRoleDTO;
    }

    @Override
    public List<IgoRoleDTO> query(String input) {
        List<IgoRole> igoRoleList = igoRoleDao.findIgoRoleByRoleNameLike(input);
        List<IgoRoleDTO> igoRoleDTOList = new ArrayList<>();
        IgoRoleDTO igoRoleDTO;
        for (int i = 0; i < igoRoleList.size(); i++) {
            igoRoleDTO = new IgoRoleDTO();
            BeanUtils.copyProperties(igoRoleList.get(i), igoRoleDTO);
            igoRoleDTOList.add(igoRoleDTO);
        }
        return igoRoleDTOList;
    }

    @Override
    public PageData<IgoRole> queryPage(PageDTO pageDTO) {

        int currentPage = pageDTO.getCurrentPage();
        int pageSize = pageDTO.getPageSize();
        List<Condition> conditionList = pageDTO.getConditions();
        Map<String, Condition> conditionMap = KUtil.pageConditionList2Map(conditionList);
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize, sort);
        //δΈε?ζΎε¨pageRequestδΉε
        currentPage = currentPage + 1;
        Specification<IgoRole> specification = (Specification<IgoRole>) (root, criteriaQuery, criteriaBuilder) -> {
            // ζ₯θ―’ζ‘δ»Άηιε
            List<Predicate> list = new ArrayList<>();
            //εη§°ζ¨‘η³εΉι
            if (KUtil.pageConditionIsNotBlank("name", conditionMap)) {
                Path<String> namePath = root.get("name");
                list.add(criteriaBuilder.like(namePath, "%" + conditionMap.get("name").getValue() + "%"));
            }
            // ε€ζ­ε€§δΊζ°ε­
            if (KUtil.pageConditionIsNotBlank("sex", conditionMap)) {
                Path<Integer> sexPath = root.get("sex");
                list.add(criteriaBuilder.greaterThanOrEqualTo(sexPath, Integer.parseInt(String.valueOf(conditionMap.get("sex").getValue()))));
            }
            // ζΆι΄ε€ζ­
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
            // θ½¬ζ°η»
            Predicate[] predicates = new Predicate[list.size()];
            list.toArray(predicates);
            return criteriaBuilder.and(predicates);
        };

        // ζε?ζεΊεει‘΅
        Page<IgoRole> page = igoRoleDao.findAll(specification, pageRequest);
        log.debug(page.getNumber());
        log.debug(page.getNumberOfElements());
        log.debug(page.getSize());
        log.debug(page.getTotalElements());
        log.debug(page.getTotalPages());
        return PageData.<IgoRole>getInstance(currentPage, pageSize, page.getTotalElements(), page.getContent());
    }

}
/**
 * //εε»ΊεΉιε¨οΌε³ε¦δ½δ½Ώη¨ζ₯θ―’ζ‘δ»Ά
 * ExampleMatcher matcher = ExampleMatcher.matching() //ζε»Ίε―Ήθ±‘
 * .withMatcher("materialName", GenericPropertyMatchers.contains()) //ε§ειη¨βεΌε§εΉιβηζΉεΌζ₯θ―’
 * .withMatcher("registerTime", GenericPropertyMatchers.contains()) //ε§ειη¨βεΌε§εΉιβηζΉεΌζ₯θ―’
 * .withMatcher("status", GenericPropertyMatchers.contains()) //ε§ειη¨βεΌε§εΉιβηζΉεΌζ₯θ―’
 * .withIgnorePaths("id");  //εΏ½η₯ε±ζ§οΌζ―ε¦ε³ζ³¨γε δΈΊζ―εΊζ¬η±»εοΌιθ¦εΏ½η₯ζ
 */