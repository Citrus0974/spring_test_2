package edu.springtest2.objects.university;

public class Review {
    private String text;
    private int mark;

    public Review(String text, int mark) {
        this.text = text;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Review{" +
                "text='" + text + '\'' +
                ", mark=" + mark +
                '}';
    }

    public String getText() {
        return text;
    }

    public int getMark() {
        return mark;
    }
}
