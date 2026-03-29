package edu.springtest2.beans.configs;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.Random;
import java.util.function.Predicate;

@Configuration
public class FirstConfig {

    @Bean
    String hello(){
        return "Hello world!";
    }



    @Bean
    @Scope("singleton")
    @Lazy
    Date firstDate(){
        return new Date();
    }

    @Bean
    Predicate<Integer> range(){
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 2 && integer < 5;
            }
        };
    }

    @Bean
    @Qualifier("max")
    int max(){
        return 5;
    }

    @Bean
    @Qualifier("min")
    int min(){
        return 1;
    }
}
