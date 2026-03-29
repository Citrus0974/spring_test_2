package edu.springtest2.main;

import edu.springtest2.objects.university.Human;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start9_3 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext("edu.springtest2.beans");
        System.out.println("9.3.1");
        System.out.println(ac.getBean(Human.class));
        //9.3.2 нормального reset так и не сделал
    }
}
