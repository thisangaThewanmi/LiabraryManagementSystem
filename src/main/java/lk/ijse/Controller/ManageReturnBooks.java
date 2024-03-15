package lk.ijse.Controller;

import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import lk.ijse.Bo.BorrowBookRecordBo;
import lk.ijse.Bo.BorrowBookRecordBoImpl;
import lk.ijse.Tm.NotReturnedTM;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ManageReturnBooks {

    public TextField txtBookId;
    public TextField txtTitle;
    public TextField txtGenre;
    public JFXDatePicker txtReturnDate;
    public JFXDatePicker txtBorrowDate;
    public TableColumn <NotReturnedTM, Integer> clBookId;
    public TableColumn <NotReturnedTM, String>clmTitle;
    public TableColumn <NotReturnedTM, String>clmGenere;
    public TableColumn<NotReturnedTM, LocalDate> clmBorrowDate;
    public TableColumn <NotReturnedTM, LocalDate>clmReturnDate;

    public Label lblManageBooks1;
    public Pane tblReturnBooks;

    private BorrowBookRecordBo borrowBookRecordBo = new BorrowBookRecordBoImpl();
    private int userId;

    public void returnOnAction(ActionEvent actionEvent) {
     /*   NotReturnedTM selectedItem = tblReturnBooks.getSelectionModel().getSelectedItem();
        if (selectedItem==null)return;
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO).showAndWait();
        if (buttonType.isPresent() && buttonType.get() == ButtonType.YES){
            borrowBookRecordBo.returnBook(selectedItem);
            loadTableData();
        }*/
    }

    public void setUserId(int userId) {
        this.userId = userId;
        setCellValueFactories();
        /*loadTableData();*/
    }

    public void setCellValueFactories(){
        clBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        clmTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        clmGenere.setCellValueFactory(new PropertyValueFactory<>("category"));

        clmBorrowDate.setCellValueFactory(new PropertyValueFactory<>("borrowedDate"));
        clmReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnedDate"));
    }

   /* public void loadTableData(){
        List<NotReturnedTM> notReturnedListByUserId = borrowBookRecordBo.getNotReturnedListByUserId(userId);
        tblReturnBooks.setItems(FXCollections.observableArrayList(notReturnedListByUserId));
    }*/


}
