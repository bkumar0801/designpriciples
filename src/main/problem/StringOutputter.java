package main.problem;

public class StringOutputter {
    private AreaAggregator areaAggregator = new AreaAggregator();
    public StringOutputter(AreaAggregator areaAggregator) {
        this.areaAggregator = areaAggregator;
    }
    public String Output() {
        return "Sum of areas:" + areaAggregator.Sum();
    }
}
