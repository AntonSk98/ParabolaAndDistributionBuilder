package sample.firstProgram;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Window;
import sample.ZoomManager;


public class Controller {
    @FXML
    private NumberAxis X;
    @FXML
    private NumberAxis Y;
    @FXML
    private LineChart LineChart;
    @FXML
    private TextField A;
    @FXML
    private TextField B;
    @FXML
    private TextField C;
    @FXML
    private TextField Xmax;
    @FXML
    private TextField Xmin;
    @FXML
    private TextField Ymax;
    @FXML
    private TextField Ymin;
    @FXML
    private Button Press;
    @FXML
    private Button Delete;
    @FXML
    private Pane pane = new Pane();
    private int counter=0;
    private Alert alert;
    private ObservableList<XYChart.Series<Double, Double>> series = FXCollections.observableArrayList();
    @FXML
    void initialize(){
        ///LineChart.getStylesheets().add(Main.class.getResource(".chart-line-symbol.css").toExternalForm());
        Press.setOnAction(event -> {
            if(A.getText().isEmpty() || B.getText().isEmpty() || C.getText().isEmpty() || Xmax.getText().isEmpty() ||Xmin.getText().isEmpty() ||
                    Ymax.getText().isEmpty() ||Ymin.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR!");
                alert.setHeaderText(null);
                alert.setContentText("Enter all the fields!");
                alert.showAndWait();
            }else{
                double a = Double.parseDouble(A.getText());
                double b = Double.parseDouble(B.getText());
                double c = Double.parseDouble(C.getText());
                double xMin = Double.parseDouble(Xmin.getText());
                double xMax = Double.parseDouble(Xmax.getText());
                double yMin = Double.parseDouble(Ymin.getText());
                double yMax = Double.parseDouble(Ymax.getText());
                //Y.setAutoRanging(false);
                //Y.setTickUnit(0.5);
                //Y.setLowerBound(yMin-1.0);
                //Y.setUpperBound(yMax+1.0);
                X.setForceZeroInRange(false);
                Y.setForceZeroInRange(false);
                //X.setAutoRanging(false);
                //X.setTickUnit(0.5);
                //X.setLowerBound(xMin-1.0);
                //X.setUpperBound(xMax+1.0);
                series.add(new XYChart.Series<>());
                if(b==0 && c==0)
                    series.get(counter).setName("Line: "+(int)a+"x^2");
                else if(b==0)
                    series.get(counter).setName("Line: "+(int)a+"x^2+"+(int)c);
                else if(c==0)
                    series.get(counter).setName("Line: "+(int)a+"x^2+"+(int)b+"x");
                    for (double i=xMin; i<=xMax+0.01; i=i+0.1){
                    double y = a*i*i+b*i+c;
                    if(y<=yMin-0.1 || y>=yMax+0.1)
                        continue;
                    else
                        series.get(counter).getData().add(new XYChart.Data<>(i, y));
                    }

                new ZoomManager(pane, LineChart, series);
                counter++;
                A.clear();
                B.clear();
                C.clear();
                Xmax.clear();
                Xmin.clear();
                Ymax.clear();
                Ymin.clear();
        }});
        Delete.setOnAction(event -> {
            LineChart.setData(series);
            series.clear();
            counter=0;
            A.clear();
            B.clear();
            C.clear();
            Xmax.clear();
            Xmin.clear();
            Ymax.clear();
            Ymin.clear();
        });


    }



}
