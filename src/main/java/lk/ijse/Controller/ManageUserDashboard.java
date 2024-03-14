package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class ManageUserDashboard {
    public AnchorPane mainPane;
    public AnchorPane sidePane;
    public JFXButton BtnManageBooks;
    public JFXButton btnManageBranches;
    public JFXButton btnTransaction;

    public JFXButton btnSetting;
    public JFXButton logout;
    public Text txtDate1;
    public AnchorPane DashPane;

    public void btnBorrowBooksOnAction(ActionEvent actionEvent) {
       /* Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("/veiw/User/UserBorrowBOOKS.fxml"));
            DashPane.getChildren().removeAll();

            DashPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("/veiw/User/MainLogin.fxml"));
            DashPane.getChildren().removeAll();

            DashPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void logoutOnAction(ActionEvent actionEvent) {
    }

    public void btnSettingsOnAction(ActionEvent actionEvent) {
    }

    public void btnMyLiabraryOnAction(ActionEvent actionEvent) {

    }

    public void BtnReturnBooksOnAction(ActionEvent actionEvent) {
    }
}
