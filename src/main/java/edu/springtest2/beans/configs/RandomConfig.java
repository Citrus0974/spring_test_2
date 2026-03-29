package edu.springtest2.beans.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class RandomConfig {
    List<Integer> used = new ArrayList<>();
    @Autowired
    Random rnd;

    @Bean
    public Random randomObject(){
        return new Random();
    }

    @Bean
    @Scope("prototype")
    @Qualifier("randomInt")
    public int nextInt(Random random){
        return random.nextInt();
    }

    @Bean
    @Qualifier("testInt")
    public int testInt(){
        return 102;
    }

    @Bean
    @Scope("prototype")
    int random(@Qualifier("min") int min, @Qualifier("max") int max){
        if(min>max) throw new IllegalArgumentException("min value is greater than max value");
        int valuesCount=max-min+1;
        while(true){
            int rndInt = rnd.nextInt(min, max+1);
            if(!used.contains(rndInt)){
                used.add(rndInt);
                return rndInt;
            }
            if(used.size()==valuesCount) return rndInt;
        }
    }
}
