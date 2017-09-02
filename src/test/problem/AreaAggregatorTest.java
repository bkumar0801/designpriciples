package test.problem;


import main.problem.AreaAggregator;
import main.problem.Circle;
import main.problem.Square;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AreaAggregatorTest {
    @Test
    public void ShouldSumAllShapesArea() {
        AreaAggregator areaAggregator = new AreaAggregator();
        areaAggregator.AddShape(new Circle(5));
        areaAggregator.AddShape(new Square(5));
        assertEquals(103, areaAggregator.Sum());
    }

    @Test
    public void ShouldOutputInString() {
        AreaAggregator areaAggregator = new AreaAggregator();
        areaAggregator.AddShape(new Circle(5));
        areaAggregator.AddShape(new Square(5));
        assertEquals("Sum of areas :103", areaAggregator.Output());
    }

}
