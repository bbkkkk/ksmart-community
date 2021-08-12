package com.ksmart.demo.biz.dao;

import com.ksmart.demo.biz.domain.Demo;
import com.ksmart.framework.base.dao.KBaseDao;

import java.util.List;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:12
 * @description:
 */
public interface DemoDao extends KBaseDao<Demo, String> {

    List<Demo> findDemoByNameLike(String input);
}
