package com.pk.controller;

import com.pk.config.MethodLog;
import com.pk.entity.User;
import com.pk.service.UserService;
import com.pk.service.UserService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Created by pangkunkun on 2018/11/12.
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @MethodLog
    @GetMapping("/log/test")
    public void logTest(@RequestParam(value = "name")String name, @RequestParam(value = "age") int age){
//        UserService2 userService2 = new UserService2();
        logger.info("This is log test = {}, age = {}",name,age);
//        test2();
        userService.serviceMethod();
//        userService2.userServiceMethod2();
//        userService.serviceMethod2();
    }


    @MethodLog
    @PostMapping("/log/test2")
    public void test2(@RequestBody User user){
        logger.info("This is test2 user = {}",user);
    }
}
