package edu.shevchenko.exam;

public class TrafficLight {
    private ColorChain colors;

    public TrafficLight(ColorChain colors) {
        this.colors = colors.first();
    }

    public void next() {
        System.out.println(colors.get());
        colors.next();
    }

    public void set(ColorChain colors) {
        this.colors = colors;
    }
}
