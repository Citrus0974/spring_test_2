package edu.springtest2;


import edu.springtest2.beans.SolarSystem;
import edu.springtest2.beans.Star;
import edu.springtest2.beans.configs.Config;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");
        ApplicationContext app = new AnnotationConfigApplicationContext("edu.springtest2.beans.configs");
        System.out.println(app.getBean("sun"));
        System.out.println(app.getBean("sun", Star.class));
        System.out.println(app.getBean("sun"));
        System.out.println(app.getBean("earth"));
        SolarSystem sSys = app.getBean("solarsystem", SolarSystem.class);
        System.out.println(sSys);
        System.out.println(Arrays.toString(app.getBeanDefinitionNames()));
        System.out.println(app.getBean("config"));
        System.out.println(app.getBean("nextInt"));
        System.out.println(app.getBean("nextInt"));
        System.out.println(app.getBean("nextInt"));
        sSys.solarWind();
        sSys.solarWind();
    }
}