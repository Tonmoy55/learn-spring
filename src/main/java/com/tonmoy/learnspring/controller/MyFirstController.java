package com.tonmoy.learnspring.controller;

import com.tonmoy.learnspring.utility.ApplicationContextProvider;
import com.tonmoy.learnspring.service.MyFirstClass;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/myFirstController/")
public class MyFirstController {

    private final MyFirstClass myFirstClass;

    @GetMapping("myFirstGetMethodWithBean")
    public void myFirstGetMethodWithBean() {
        ApplicationContext context = ApplicationContextProvider.getContext();
        var myFirstClass = context.getBean("myFirstClass", MyFirstClass.class);
        myFirstClass.test();
    }

    @GetMapping("myFirstGetMethodWithoutBean")
    public void myFirstGetMethodWithoutBean() {
        myFirstClass.test();
    }
}
