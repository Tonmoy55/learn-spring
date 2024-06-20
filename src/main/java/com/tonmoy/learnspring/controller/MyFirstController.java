package com.tonmoy.learnspring.controller;

import com.tonmoy.learnspring.utility.ApplicationContextProvider;
import com.tonmoy.learnspring.service.MyFirstClass;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/myFirstController/")
public class MyFirstController {
    
    @GetMapping
    public void myFirstGetMethod() {
        ApplicationContext context = ApplicationContextProvider.getContext();
        var myFirstClass = context.getBean(MyFirstClass.class);
        myFirstClass.myFirstClass();
    }
}
