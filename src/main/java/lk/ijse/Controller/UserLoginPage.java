package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserLoginPage {
    public AnchorPane mainPane;
    public TextField txtPassword;
    public TextField txtUserName;

    public void btnLoginOnAction(ActionEvent actionEvent) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/veiw/User/UserDashboard.fxml"));
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


    public void btnRegisterOnAction(ActionEvent actionEvent) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/veiw/User/UserCreateAcc.fxml"));
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


    public void btnBackOnAction(ActionEvent actionEvent) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/veiw/MainLogin.fxml"));
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
