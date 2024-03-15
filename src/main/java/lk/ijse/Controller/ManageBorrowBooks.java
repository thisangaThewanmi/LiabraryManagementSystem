package lk.ijse.Controller;

import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class ManageBorrowBooks {
    public TableColumn clBookId;
    public TableColumn clmTitle;
    public TableColumn clAuthor;
    public TableColumn clmGenre;
    public TableColumn clmAvailableNo;
    public Label lblManageBooks1;
    public TextField txtBookId;
    public TextField txtTitle;
    public TextField txtGenre;
    public JFXDatePicker txtBorrowDate;
    public JFXDatePicker txtReturnDate;

    public void btnBorrowOnAction(ActionEvent actionEvent) {
    }
}
