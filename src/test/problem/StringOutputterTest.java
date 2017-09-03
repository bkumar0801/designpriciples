package test.problem;

import main.problem.AreaAggregator;
import main.problem.StringOutputter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringOutputterTest {
    @Test
    public void ShouldOutputInString() {
        FakeAreaAggregator areaAggregator = new FakeAreaAggregator();
        StringOutputter stringOutputter = new StringOutputter(areaAggregator);
        assertEquals("Sum of areas:20", stringOutputter.Output());
    }
}

class FakeAreaAggregator extends AreaAggregator {
    @Override
    public int Sum() {
        // For unit test
        return 20;
    }
}
