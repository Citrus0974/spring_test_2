package edu.springtest2.beans.configs;

import edu.springtest2.objects.space.Planet;
import edu.springtest2.objects.space.SolarSystem;
import edu.springtest2.objects.space.Star;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SolarConfig {

    @Bean("solarsystem")
    public SolarSystem getSSys(Star star, Planet... planets){
        return new SolarSystem(star, Arrays.asList(planets));

    }
}
