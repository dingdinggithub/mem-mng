package com.kevin.mem.mng.service.impl;


import com.kevin.mem.mng.domain.mapper.UserInfoMapper;
import com.kevin.mem.mng.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
}
