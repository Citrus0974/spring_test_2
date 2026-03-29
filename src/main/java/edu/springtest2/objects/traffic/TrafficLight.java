package edu.springtest2.objects.traffic;

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
