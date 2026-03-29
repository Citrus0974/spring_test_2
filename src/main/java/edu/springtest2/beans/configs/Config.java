package edu.springtest2.beans.configs;

import edu.springtest2.entities.Planet;
import edu.springtest2.entities.Star;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class Config {
    @Bean
    @Scope("prototype")
    public static Star sun(@Qualifier("random") int nextInt){
        return new Star(nextInt%100, "Sun");
    }

    @Bean("earth")
    public Planet getEarth(){
        return new Planet("Earth");
    }

    @Bean
    public Random random(){
        return new Random();
    }

    @Bean
    @Scope("prototype")
    @Qualifier("random")
    public int nextInt(Random random){
        return random.nextInt();
    }

    @Bean
    @Qualifier("testRandom")
    public int testRndInt(){
        return 102;
    }
}
