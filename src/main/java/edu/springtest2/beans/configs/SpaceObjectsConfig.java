package edu.springtest2.beans.configs;

import edu.springtest2.objects.space.Planet;
import edu.springtest2.objects.space.Star;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpaceObjectsConfig {
    @Bean
    @Scope("prototype")
    public static Star sun(@Qualifier("randomInt") int nextInt){
        return new Star(nextInt%100, "Sun");
    }

    @Bean("earth")
    public Planet getEarth(){
        return new Planet("Earth");
    }



}
