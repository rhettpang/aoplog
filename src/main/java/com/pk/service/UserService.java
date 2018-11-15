package com.pk.service;

import com.pk.config.MethodLog;
import org.springframework.stereotype.Component;

/**
 * @author Created by pangkunkun on 2018/11/12.
 */
@Component
public class UserService {

    @MethodLog
    public void serviceMethod(){
        System.out.println(" This is serviceMethod");
        serviceMethod2();
    }

    @MethodLog
    public void serviceMethod2(){
        System.out.println("UserService This is serviceMethod");
    }
}
