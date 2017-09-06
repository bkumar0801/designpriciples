package main.problem;

public class Square implements Shape {
    private int side;
    public Square(int side) {
        this.side = side;
    }

    @Override
    public int Area() {
        return side*side;
    }

    @Override
    public int Volume() {
        return 0;
    }
}
