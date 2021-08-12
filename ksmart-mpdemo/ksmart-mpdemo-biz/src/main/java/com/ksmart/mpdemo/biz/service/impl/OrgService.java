package com.ksmart.mpdemo.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ksmart.mpdemo.biz.entity.Org;
import com.ksmart.mpdemo.biz.mapper.OrgMapper;
import com.ksmart.mpdemo.biz.service.IOrgService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class OrgService extends ServiceImpl<OrgMapper, Org> implements IOrgService {


}
