package sample.thirdProgramm;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PermanentService {
    private Random random;
    public void setSeriesForGraphic(XYChart graphic, Integer n, Integer A, Integer B){
        Double step = 1.00 / new Double(n);
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < B - A; i++) {
            map.put(i, 0.0);
        }
        random = new Random();
        for (int j = 0; j < n; j++) {
            Integer experiment = random.nextInt(B - A);
            for (int h = 0; h < B - A + 1; h++) {
                if (experiment >= h && experiment < h + 1) {
                    Double value = map.get(h);
                    map.put(h, value + step);
                }
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            XYChart.Series series = new XYChart.Series();
            Double key = new Double(entry.getKey().toString());
            series.setName("number: "+entry.getKey());
            series.getData().add(new XYChart.Data(key + A, 0));
            series.getData().add(new XYChart.Data(key + A, (Double) entry.getValue()));
            series.getData().add(new XYChart.Data(key + 1 + A, (Double) entry.getValue()));
            series.getData().add(new XYChart.Data(key + 1 + A, 0));
            graphic.getData().add(series);
        }
    }
    public void setBaseLine(LineChart graphic, Integer minX, Integer maxX) {
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data(0, 1.00 / (maxX - minX)));
        series.getData().add(new XYChart.Data(maxX+0.5, 1.00 / (maxX - minX)));
        series.setName("Теоретическое значение: y="+1.00 / (maxX - minX)    );
        graphic.getData().add(series);
    }
}
