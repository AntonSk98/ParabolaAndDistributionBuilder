package sample.mainWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreen {
    @FXML
    private Button firstLaunch;
    @FXML
    private Button secondLaunch;

    @FXML
    private Button thirdLaunch;
    @FXML
    void initialize(){
        firstLaunch.setOnAction(event -> {
            openNewScene("../firstProgram/sample.fxml");
        });
        secondLaunch.setOnAction(event -> {
            openNewScene("../secondProgram/secondLaunch.fxml");
        });
        thirdLaunch.setOnAction(event -> {
            openNewScene("../thirdProgramm/rhirdProgram.fxml");

        });
    }

    private void openNewScene(String window) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.NONE);
        stage.initOwner(firstLaunch.getScene().getWindow());
        stage.setScene(new Scene(root));
        stage.show();



    }
}
