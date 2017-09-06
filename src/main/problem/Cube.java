package main.problem;

public class Cube implements Shape {
    private int side;
    public Cube(int side) {
        this.side = side;
    }
    @Override
    public int Volume() {
        return side * side * side;
    }

    @Override
    public int Area() {
        return 6 * side * side;
    }
}
