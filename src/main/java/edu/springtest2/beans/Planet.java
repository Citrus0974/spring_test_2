package edu.springtest2.beans;

public class Planet {
    private String name;

    public Planet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                '}';
    }
}
