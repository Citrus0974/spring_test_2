package edu.springtest2.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start9_2 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext("edu.springtest2.beans");
        System.out.println("9.2.1");
        System.out.println(ac.getBean("random"));
        System.out.println(ac.getBean("random"));
        System.out.println(ac.getBean("random"));
        System.out.println(ac.getBean("random"));
        System.out.println(ac.getBean("random"));
        System.out.println(ac.getBean("random"));
        System.out.println("9.2.2");
    }
}
