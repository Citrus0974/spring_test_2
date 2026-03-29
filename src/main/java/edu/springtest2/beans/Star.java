package edu.springtest2.beans;

public class Star {
    private int brightness;
    private String name;

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
}
