package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageAdminLoginPage {
    public AnchorPane mainPane;
    public TextField txtPassword;
    public TextField txtEmail;

    String email="thisangat2005@gmail.com";
    String password="1234";

    public void btnLoginOnAction(ActionEvent actionEvent) {

        login();


    }

    private void login() {
        System.out.println("login called");


        if(txtEmail.getText().equals(email) && txtPassword.getText().equals(password)){
            try {
                Parent newRoot = FXMLLoader.load(getClass().getResource("/veiw/Admin/AdminDashboard.fxml"));
                Scene newScene = new Scene(newRoot);

                // Get the current stage
                Stage currentStage = (Stage) mainPane.getScene().getWindow();

                // Create a new stage
                Stage newStage = new Stage();
                newStage.setScene(newScene);

                // Show the new stage and close the current stage
                currentStage.close();
                newStage.show();
                new Alert(Alert.AlertType.CONFIRMATION,"Sucessfully logged");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        new Alert(Alert.AlertType.ERROR,"Wrong Credentials");
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
