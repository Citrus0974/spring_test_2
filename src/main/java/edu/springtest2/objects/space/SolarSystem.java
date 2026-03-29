package edu.springtest2.objects.space;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem {
    private Star sun;
    private List<Planet> planets = new ArrayList<>();

    public SolarSystem(Star sun, List<Planet> planets) {
        this.sun = sun;
        this.planets = planets;
    }

    public void solarWind(){
        sun.wind();
    }

    @Override
    public String toString() {
        return "SolarSystem{" +
                "sun=" + sun +
                ", planets=" + planets +
                '}';
    }
}
