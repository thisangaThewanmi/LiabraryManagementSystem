package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ManageUserCreateAccount {
    public AnchorPane MainPane;
    public TextField txtEmail;
    public TextField txtPassword;
    public TextField txtName;
    public ComboBox cmbBranch;

    public void btnCreateAccount(ActionEvent actionEvent) {
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("/veiw/User/UserLoginPage.fxml"));
            MainPane.getChildren().removeAll();

            MainPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
