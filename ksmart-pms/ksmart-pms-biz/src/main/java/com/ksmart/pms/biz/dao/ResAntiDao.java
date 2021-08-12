package com.ksmart.pms.biz.dao;


import com.ksmart.pms.biz.domain.ResAnti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:12
 * @description:
 */
public interface ResAntiDao extends JpaRepository<ResAnti, String>, JpaSpecificationExecutor<ResAnti> {

    List<ResAnti> findResAntiByResLnameLike(String input);
}
