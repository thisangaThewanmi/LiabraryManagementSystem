package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainLogin {
    public AnchorPane mainPane;
    public JFXButton btnAdmin;
    public JFXButton btnUser;

    public void btnAdminOnAction(ActionEvent actionEvent) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/veiw/Admin/AdminLoginPage.fxml"));
            Scene newScene = new Scene(newRoot);

            // Get the current stage
            Stage currentStage = (Stage) mainPane.getScene().getWindow();

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setScene(newScene);

            // Show the new stage and close the current stage
            currentStage.close();
            newStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void btnUserOnAction(ActionEvent actionEvent) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/veiw/User/UserLoginPage.fxml"));
            Scene newScene = new Scene(newRoot);

            // Get the current stage
            Stage currentStage = (Stage) mainPane.getScene().getWindow();

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setScene(newScene);

            // Show the new stage and close the current stage
            currentStage.close();
            newStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

