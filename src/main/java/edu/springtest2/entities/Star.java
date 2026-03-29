package edu.springtest2.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class Star {
    private int brightness;
    private String name;
    @Autowired
    private ApplicationContext ctx;

    public Star(int brightness, String name) {
        this.brightness = brightness;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Star{" +
                "brightness=" + brightness +
                ", name='" + name + '\'' +
                '}';
    }

    public void wind(){
        int x= ctx.getBean("nextInt", int.class)%10;
        for (int i=0; i<x; i++){
            System.out.print(brightness+"-");
        }
        System.out.println("wind");
    }

}
