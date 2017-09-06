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
            sum += shape.Area();
        }
        return sum;
    }
}
