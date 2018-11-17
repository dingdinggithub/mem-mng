package com.kevin.mem.mng.business.impl;


import com.kevin.mem.mng.business.UserInfoBusiness;
import com.kevin.mem.mng.domain.entity.UserInfo;
import com.kevin.mem.mng.service.BaseService;
import com.kevin.mem.mng.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserInfoBusinessImpl implements UserInfoBusiness {

    @Autowired
    private BaseService<UserInfo> baseService;

    @Autowired
    private UserInfoService userInfoService;

}
