package main.problem;

public class Line implements Shape {
    private int length;
    public Line(int length) {
        this.length = length;
    }

    @Override
    public int Area() {
        return 0;
    }
}
