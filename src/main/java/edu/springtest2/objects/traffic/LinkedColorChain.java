package edu.shevchenko.exam;

public class LinkedColorChain implements ColorChain{
    private final Color first;
    private Color current;

    public LinkedColorChain(String color) {
        first = new Color(color, null);
        current = first;
        first.next = first;
    }

    private class Color {
        private final String color;
        private Color next;

        private Color(String color, Color next) {
            this.color = color;
            this.next = next;
        }
    }

    public LinkedColorChain add(String color) {
        current.next = new Color(color, first);
        next();
        return this;
    }

    public LinkedColorChain first() {
        current = first;
        return this;
    }

    @Override
    public String get() {
        return current.color;
    }

    @Override
    public LinkedColorChain next() {
        current = current.next;
        return this;
    }
}
