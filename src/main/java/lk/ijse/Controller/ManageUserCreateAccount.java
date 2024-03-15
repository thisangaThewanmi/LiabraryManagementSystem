package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Bo.UserBo;
import lk.ijse.Bo.UserBoImpl;
import lk.ijse.dto.UserDto;

import java.io.IOException;

public class ManageUserCreateAccount {
    public AnchorPane MainPane;
    public TextField txtEmail;
    public TextField txtPassword;
    public TextField txtName;
    public ComboBox cmbBranch;

    UserBo userBo = new UserBoImpl();

    public void btnCreateAccount(ActionEvent actionEvent) {

        String Name = txtName.getText();
        String Email = txtEmail.getText();
        String Password =txtPassword.getText();

        boolean b = userBo.saveUser(new UserDto(Name, Email, Password));

        if(b){
            new Alert(Alert.AlertType.CONFIRMATION,"sucessfully created");
            Parent fxml = null;
            try {
                fxml = FXMLLoader.load(getClass().getResource("/veiw/User/UserLoginPage.fxml"));
                MainPane.getChildren().removeAll();

                MainPane.getChildren().setAll(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        new Alert(Alert.AlertType.ERROR,"Wrong credentials");
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
