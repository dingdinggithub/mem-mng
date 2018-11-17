package com.kevin.mem.mng.business.impl;


import com.kevin.mem.mng.business.UserBusiness;
import com.kevin.mem.mng.domain.entity.User;
import com.kevin.mem.mng.service.BaseService;
import com.kevin.mem.mng.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserBusinessImpl implements UserBusiness {

    @Autowired
    private BaseService<User> baseService;

    @Autowired
    private UserService userService;
}
