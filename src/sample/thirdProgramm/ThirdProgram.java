package sample.thirdProgramm;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ThirdProgram {
    private PermanentService permanentService = new PermanentService();
    @FXML
    private Button buttonRun;

    @FXML
    private TextField inputA;

    @FXML
    private TextField inputB;

    @FXML
    private TextField inputN;

    @FXML
    private LineChart lineChart;
    @FXML
    void initialize(){
        buttonRun.setOnAction(event -> {
            Integer A = Integer.parseInt(inputA.getText());
            Integer B = Integer.parseInt(inputB.getText());
            Integer N = Integer.parseInt(inputN.getText());
            permanentService.setSeriesForGraphic(lineChart,N,A,B);
            permanentService.setBaseLine(lineChart,A,B);
        });
    }
}
