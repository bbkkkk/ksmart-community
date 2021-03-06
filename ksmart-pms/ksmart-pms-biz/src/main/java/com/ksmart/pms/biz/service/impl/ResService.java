package com.ksmart.pms.biz.service.impl;

import cn.hutool.core.date.DateUtil;
import com.ksmart.common.dto.Condition;
import com.ksmart.common.dto.PageDTO;
import com.ksmart.common.dto.PageData;
import com.ksmart.common.util.KUtil;
import com.ksmart.pms.api.dto.ResDTO;
import com.ksmart.pms.biz.dao.ResDao;
import com.ksmart.pms.biz.domain.Res;
import com.ksmart.pms.biz.service.IResService;
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
public class ResService implements IResService {

    @Autowired
    private ResDao resDao;


    @Override
    public int insert(ResDTO resDTO) {
        Res res = new Res();
        BeanUtils.copyProperties(resDTO, res);
        resDao.save(res);
        return 1;
    }

    @Override
    public int update(ResDTO resDTO) {
        Res res = new Res();
        BeanUtils.copyProperties(resDTO, res);
        resDao.save(res);
        return 1;
    }

    @Override
    public int delete(String id) {
        resDao.delete(new Res().setId(id));
        return 1;
    }

    @Override
    public ResDTO get(String id) {
        Optional<Res> optional = resDao.findOne(Example.of(new Res().setId(id)));
        ResDTO resDTO = new ResDTO();
        optional.ifPresent(res -> BeanUtils.copyProperties(res, resDTO));
        log.debug("θΏεη»ζ {}", resDTO);
        return resDTO;
    }

    @Override
    public List<ResDTO> query(String input) {
        List<Res> resList = resDao.findResByNameLike(input);
        List<ResDTO> resDTOList = new ArrayList<>();
        ResDTO resDTO;
        for (int i = 0; i < resList.size(); i++) {
            resDTO = new ResDTO();
            BeanUtils.copyProperties(resList.get(i), resDTO);
            resDTOList.add(resDTO);
        }
        return resDTOList;
    }

    @Override
    public PageData<Res> queryPage(PageDTO pageDTO) {

        int currentPage = pageDTO.getCurrentPage();
        int pageSize = pageDTO.getPageSize();
        List<Condition> conditionList = pageDTO.getConditions();
        Map<String, Condition> conditionMap = KUtil.pageConditionList2Map(conditionList);
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize, sort);
        //δΈε?ζΎε¨pageRequestδΉε
        currentPage = currentPage + 1;
        Specification<Res> specification = (Specification<Res>) (root, criteriaQuery, criteriaBuilder) -> {
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
        Page<Res> page = resDao.findAll(specification, pageRequest);
        log.debug(page.getNumber());
        log.debug(page.getNumberOfElements());
        log.debug(page.getSize());
        log.debug(page.getTotalElements());
        log.debug(page.getTotalPages());
        return PageData.<Res>getInstance(currentPage, pageSize, page.getTotalElements(), page.getContent());
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