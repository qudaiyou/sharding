package com.example.controller;

import com.example.entity.UserInfo;
import com.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: qudy
 * @date: 2019/6/20
 **/
@RestController
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/add")
    public void add() {
        for (int i = 0; i < 100; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(i);
            userInfo.setAccount("account" + i);
            userInfo.setPassword("password" + i);
            userInfo.setUserName("username" + i);

            userInfoService.insert(userInfo);
        }
    }

}
