package edu.springtest2.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Start9_1 {
    public static void main(String[] args) {
        System.out.println("maven");
        ApplicationContext ac = new AnnotationConfigApplicationContext("edu.springtest2.beans");
        System.out.println("9.1.1");
        System.out.println(ac.getBean("hello"));
        System.out.println("9.1.2");
        System.out.println(ac.getBean("random"));
        System.out.println(ac.getBean("random"));
        System.out.println("9.1.3");
        System.out.println(ac.getBean("firstDate"));
        System.out.println(ac.getBean("firstDate"));
        Predicate<Integer> range = (Predicate<Integer>) ac.getBean("range");
        System.out.println("9.1.4");
        System.out.println(range.test(50));
        System.out.println(range.test(3));
        System.out.println("9.1.5");
        System.out.println(ac.getBean("max"));
        System.out.println(ac.getBean("min"));

    }
}