package edu.springtest2.entities.example;

import edu.springtest2.annotations.Cache;
import edu.springtest2.annotations.ToString;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Cache
@Component
@ToString
class A implements Able {
    A() {

    }

    @PostConstruct
    void init() {
        System.out.println("init method");
    }

    @PreDestroy
    void theEnd() {
        System.out.println("bye-bye");
    }
}
