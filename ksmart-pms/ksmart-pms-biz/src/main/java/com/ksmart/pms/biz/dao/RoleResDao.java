package com.ksmart.pms.biz.dao;


import com.ksmart.pms.biz.domain.RoleRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:12
 * @description:
 */
public interface RoleResDao extends JpaRepository<RoleRes, String>, JpaSpecificationExecutor<RoleRes> {

    List<RoleRes> findRoleResByRoleNameLike(String input);
}
