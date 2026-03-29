package edu.springtest2.beans.commandsPostProcessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandsConfig {
    @Bean
    LogCommand logCommand(){
        return new LogCommand();
    }
}
