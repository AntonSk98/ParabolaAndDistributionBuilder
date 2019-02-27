package sample.secondProgram;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.Random;
public class SecondLaunch {
    @FXML
    private Button run;
    @FXML
    private TextField textA;
    @FXML
    private TextField textB;
    @FXML
    private TextField amount;
    @FXML
    private TextField textExp;
    @FXML
    private LineChart<Integer, Float> lineChart;
    private float expArray[];
    private int figArray[];
    private Random random = new Random();
    private int rand;
    private int counter=0;
    private ObservableList<XYChart.Series<Integer, Float>> series = FXCollections.observableArrayList();
    private double one = 1.0;


    @FXML
    void initialize(){
        run.setOnAction(event -> {
            XYChart.Series seriesXY = new XYChart.Series();
            Integer a = Integer.parseInt(textA.getText());
            Integer b = Integer.parseInt(textB.getText());
            Integer c = Integer.parseInt(textExp.getText());
            Integer d = Integer.parseInt(amount.getText());
            for(int i=0; i<d; i++){
                expArray = new float[b+1];
                figArray = new int[b+1];
                for(int x=0; x<figArray.length; x++){
                    figArray[x]=x;
                }
                for (int x=0; x<c; x++) {
                    rand = a + random.nextInt((b + 1) - a);
                    expArray[rand]++;
                }
                series.add(new XYChart.Series<>());
                series.get(counter).setName("Опыт "+i);
                for (int j=0; j<expArray.length; j++){
                    if(expArray[j]==0.0)
                        continue;
                    //here you need to add points to scatter chart java
                    series.get(counter).getData().add(new XYChart.Data<>(figArray[j], expArray[j]/c));
                }
                lineChart.getData().add(series.get(counter));
                series.get(counter).getNode().setStyle("-fx-stroke: transparent;");
                counter++;
            }
            seriesXY.setName("Теоретическое значение: y="+(one/(figArray.length-1)));
            seriesXY.getData().add(new XYChart.Data<>(a-1, one/(b-a+1)));
            seriesXY.getData().add(new XYChart.Data<>(b+1, one/(b-a+1)));
            lineChart.getData().add(seriesXY);

        });
    }
}

