package edu.springtest2.beans.configs;

import edu.springtest2.beans.Planet;
import edu.springtest2.beans.Star;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class Config {
    @Bean
    @Scope("prototype")
    public static Star sun(){
        Random r = new Random();
        return new Star(r.nextInt(100), "Sun");
    }

    @Bean("earth")
    public Planet getEarth(){
        return new Planet("Earth");
    }
}
