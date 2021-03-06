package com.ksmart.demo.biz.service.impl;

import cn.hutool.core.date.DateUtil;
import com.ksmart.common.dto.Condition;
import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.util.KUtil;
import com.ksmart.demo.api.dto.DemoDTO;
import com.ksmart.demo.biz.dao.DemoDao;
import com.ksmart.demo.biz.domain.Demo;
import com.ksmart.demo.biz.service.IDemoService;
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
public class DemoService implements IDemoService {

    @Autowired
    private DemoDao demoDao;


    @Override
    public int insert(DemoDTO demoDTO) {
        Demo demo = new Demo();
        BeanUtils.copyProperties(demoDTO, demo);
        demo.setCreateUid(demoDTO.getUserId());
        demo.setCreateUname(demoDTO.getUserName());
        demoDao.save(demo);
        return 1;
    }

    @Override
    public int update(DemoDTO demoDTO) {
        Optional<Demo> optional = demoDao.findOne(Example.of(new Demo().setId(demoDTO.getId())));
        if (optional.isPresent()) {
            Demo demo = new Demo();
            BeanUtils.copyProperties(demoDTO, demo);
//            demoDTO = new DemoDTO();
//            BeanUtils.copyProperties(optional.get(), demoDTO);
            demoDao.save(demo);
        }


        return 1;
    }

    @Override
    public int delete(String id) {
        demoDao.delete(new Demo().setId(id));
        return 1;
    }

    @Override
    public DemoDTO get(String id) {
        Optional<Demo> optional = demoDao.findOne(Example.of(new Demo().setId(id)));
        DemoDTO demoDTO = null;
        if (optional.isPresent()) {
            demoDTO = new DemoDTO();
            BeanUtils.copyProperties(optional.get(), demoDTO);
        }
        return demoDTO;
    }

    @Override
    public List<DemoDTO> query(String input) {
        List<Demo> demoList = demoDao.findDemoByNameLike(input);
        List<DemoDTO> demoDTOList = new ArrayList<>();
        DemoDTO demoDTO;
        for (int i = 0; i < demoList.size(); i++) {
            demoDTO = new DemoDTO();
            BeanUtils.copyProperties(demoList.get(i), demoDTO);
            demoDTOList.add(demoDTO);
        }
        return demoDTOList;
    }

    @Override
    public PageData<Demo> queryPage(PageDTO pageDTO) {

        int currentPage = pageDTO.getCurrentPage();
        int pageSize = pageDTO.getPageSize();
        List<Condition> conditionList = pageDTO.getConditions();
        Map<String, Condition> conditionMap = KUtil.pageConditionList2Map(conditionList);
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize, sort);
        //????????????pageRequest??????
        currentPage = currentPage + 1;
        Specification<Demo> specification = (Specification<Demo>) (root, criteriaQuery, criteriaBuilder) -> {
            // ?????????????????????
            List<Predicate> list = new ArrayList<>();
            //??????????????????
            if (KUtil.pageConditionIsNotBlank("name", conditionMap)) {
                Path<String> namePath = root.get("name");
                list.add(criteriaBuilder.like(namePath, "%" + conditionMap.get("name").getValue() + "%"));
            }
            // ??????????????????
            if (KUtil.pageConditionIsNotBlank("sex", conditionMap)) {
                Path<Integer> sexPath = root.get("sex");
                list.add(criteriaBuilder.greaterThanOrEqualTo(sexPath, Integer.parseInt(String.valueOf(conditionMap.get("sex").getValue()))));
            }
            // ????????????
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
            // ?????????
            Predicate[] predicates = new Predicate[list.size()];
            list.toArray(predicates);
            return criteriaBuilder.and(predicates);
        };

        // ?????????????????????
        Page<Demo> page = demoDao.findAll(specification, pageRequest);
        log.debug(page.getNumber());
        log.debug(page.getNumberOfElements());
        log.debug(page.getSize());
        log.debug(page.getTotalElements());
        log.debug(page.getTotalPages());
        return PageData.<Demo>getInstance(currentPage, pageSize, page.getTotalElements(), page.getContent());
    }

}
/**
 * //?????????????????????????????????????????????
 * ExampleMatcher matcher = ExampleMatcher.matching() //????????????
 * .withMatcher("materialName", GenericPropertyMatchers.contains()) //?????????????????????????????????????????????
 * .withMatcher("registerTime", GenericPropertyMatchers.contains()) //?????????????????????????????????????????????
 * .withMatcher("status", GenericPropertyMatchers.contains()) //?????????????????????????????????????????????
 * .withIgnorePaths("id");  //?????????????????????????????????????????????????????????????????????
 */