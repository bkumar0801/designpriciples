package main.problem;

public class Line implements Shape {
    private int length;
    public Line(int length) {
        this.length = length;
    }

    @Override
    public int Area() {
        try {
            throw new IDontActuallyHaveAreaException("I have no area");
        }
        catch (IDontActuallyHaveAreaException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
