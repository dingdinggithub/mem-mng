package com.kevin.mem.mng.service.impl;


import com.kevin.mem.mng.domain.mapper.UserMapper;
import com.kevin.mem.mng.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
}
