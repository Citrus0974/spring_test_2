package edu.springtest2.main;

import edu.springtest2.beans.StudentBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Start9_2 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext("edu.springtest2.beans");
        System.out.println("9.2.1");
        System.out.println(ac.getBean("random"));
//        System.out.println(ac.getBean("random"));
//        System.out.println(ac.getBean("random"));
//        System.out.println(ac.getBean("random"));
//        System.out.println(ac.getBean("random"));
//        System.out.println(ac.getBean("random"));
        System.out.println("9.2.2");
        System.out.println(ac.getBean("randomReview"));
        System.out.println(ac.getBean("randomReview"));
        System.out.println("9.2.3");
        System.out.println(ac.getBean("highestReview"));
        System.out.println("9.2.4");
        System.out.println(ac.getBean("student1"));
        System.out.println("9.2.5");
        System.out.println(Arrays.toString(ac.getBeanDefinitionNames()));
        System.out.println(ac.getBean("studentBuilder", StudentBuilder.class).build("dan", 3));
        System.out.println("9.2.6");
        /*
        Одна конфигурация. Бины для IO (бины из классов, имплементирующих интерфейс?) - для файлов
                            в конфиге - строки для файлов, возвращает сканер и что-то для записи, или же объект интерфейса IO должен
                            сам предоставлять методы для построчного (?) чтения-записи
                          Действия - бины - функциональные function? Собираются в бин-список, возможно по @Qualifier
                          каким-то методом в конфиге (или он компонент?) или где-то ещё вызывается передача из IO в каждую функцию и обратно
         */

        //9.2.7 - светофор не тот и я его не помню. надо переделать
        //9.2.8 - акции потеряны, не помню, надо сделатьы
    }
}
