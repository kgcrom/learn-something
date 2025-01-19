package com.tistory.dol9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
// create and configure beans
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

// retrieve configured instance
        PetStore service = context.getBean("petStore", PetStore.class);

// use configured instance
        List<String> userList = service.getUserName();

        System.out.println(userList);
    }
}
