package main.problem;

import java.util.ArrayList;

public class AreaAggregator {

    private ArrayList<Shape> Shapes = new ArrayList<>();

    public void AddShape(Shape shape) {
        Shapes.add(shape);
    }

    public int Sum() {
        int sum = 0;
        for (Shape shape: Shapes) {
            if(shape.getClass().equals(Circle.class)) {
                sum += Math.PI * Math.pow(((Circle) shape).getRadius(), 2);
            } else if (shape.getClass().equals(Square.class)) {
                sum += Math.pow(((Square) shape).getSide(), 2);
            }
        }
        return sum;
    }

    public String Output() {
        return "Sum of areas :" + Integer.toString(Sum());
    }
}
