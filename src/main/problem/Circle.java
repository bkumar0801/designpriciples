package main.problem;

public class Circle implements Shape{
    private int radius;
    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public int Area() {
        return (int)(Math.PI * radius * radius);
    }

    @Override
    public int Volume() { return  0; }
}
