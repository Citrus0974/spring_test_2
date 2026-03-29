package edu.springtest2;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");
        ApplicationContext app = new AnnotationConfigApplicationContext("edu.springtest2.beans.configs");
        System.out.println(app.getBean("sun"));
        System.out.println(app.getBean("sun"));
        System.out.println(app.getBean("sun"));
        System.out.println(app.getBean("earth"));
        System.out.println(app.getBean("solarsystem"));
    }
}