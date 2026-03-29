package edu.springtest2.main;


import edu.springtest2.objects.space.SolarSystem;
import edu.springtest2.objects.space.Star;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");
        ApplicationContext app = new AnnotationConfigApplicationContext("edu.springtest2.beans");
        System.out.println(app.getBean("sun"));
        System.out.println(app.getBean("sun", Star.class));
        System.out.println(app.getBean("sun"));
        System.out.println(app.getBean("earth"));
        SolarSystem sSys = app.getBean("solarsystem", SolarSystem.class);
        System.out.println(sSys);
        System.out.println(Arrays.toString(app.getBeanDefinitionNames()));
        System.out.println(app.getBean("spaceObjectsConfig"));
        System.out.println(app.getBean("nextInt"));
        System.out.println(app.getBean("nextInt"));
        System.out.println(app.getBean("nextInt"));
        sSys.solarWind();
        sSys.solarWind();
    }
}