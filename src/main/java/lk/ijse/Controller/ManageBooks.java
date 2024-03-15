package lk.ijse.Controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import lk.ijse.Bo.BookBo;
import lk.ijse.Bo.BookBoImpl;
import lk.ijse.Bo.BranchBo;
import lk.ijse.Bo.BranchBoImpl;
import lk.ijse.Tm.BookTM;
import lk.ijse.cm.BranchCM;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.BranchDto;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageBooks {
    public TableColumn clmTitle;
    public TableColumn clmAuthor;
    public TableColumn clmBranch;
    public TableColumn clmGenre;
    public TableColumn clmCopies;
    public TableColumn clmAvailability;
    public TableColumn clmTitle1;
    public TextField txtTitle;
    public TextField txtGenre;
    public TextField txtAuthor;
    public TextField txtNoOfCopies;
    public Label lblManageBooks1;

    public ComboBox <BranchCM>cmbBranch;
    public ComboBox cmbAvailability;
    public TextField txtId;
    public TextField txtAvailability;
    public TableView tblBooks;


    BookBo bookBo = new BookBoImpl();
    BranchBo branchBo = new BranchBoImpl();




    public void initialize(){
        setConverter();
        setComboBoxData();
        setCellValueFactory();
        setTableData();
    }

    public void setCellValueFactory(){
        clmTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        clmAuthor.setCellValueFactory(new PropertyValueFactory<>("bookAuthor"));
        clmAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        clmCopies.setCellValueFactory(new PropertyValueFactory<>("category"));
    }

    public void setTableData(){
        ModelMapper mapper = new ModelMapper();
        ArrayList<BookTM> list = new ArrayList<>();
        try {
            List<BookDto> allBooks = bookBo.getAllBook();
            for (BookDto book : allBooks) {
                BookTM map = mapper.map(book, BookTM.class);
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblBooks.setItems(FXCollections.observableArrayList(list));
    }


    public void setComboBoxData(){
        ModelMapper mapper = new ModelMapper();
        ArrayList<BranchCM> list = new ArrayList<>();
        try {
            List<BranchDto> allBranches = branchBo.getAllBranches();
            for (BranchDto branch : allBranches) {
                BranchCM map = mapper.map(branch, BranchCM.class);
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cmbBranch.setItems(FXCollections.observableArrayList(list));
    }

    public void setConverter(){
        cmbBranch.setConverter(new StringConverter<BranchCM>() {
            @Override
            public String toString(BranchCM branchCM) {
                if (branchCM == null) {
                    return null;
                }
                return String.format("%02d - %s", branchCM.getBranchId(), branchCM.getBranchName());
            }

            @Override
            public BranchCM fromString(String s) {
                return null;
            }
        });
    }



    public void btnClearOnAction(ActionEvent actionEvent) {
        clearFeilds();
    }

    private void clearFeilds() {


    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        BookDto bookDto = collectData();
        bookDto.setBookId(0);
        try {
            bookBo.saveBook(bookDto);
            new Alert(Alert.AlertType.INFORMATION, "Book Added Successfully").show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public BookDto collectData(){
        BookDto bookDto = new BookDto();
        BookTM selectedItem = (BookTM) tblBooks.getSelectionModel().getSelectedItem();
        bookDto.setBookId(selectedItem == null ? 0 : selectedItem.getBookId());
        bookDto.setTitle(txtTitle.getText());
        bookDto.setAuthor(txtAuthor.getText());
        bookDto.setCategory(txtGenre.getText());
        //bookDto.set(Integer.parseInt(txtNoOfCopies.getText()));
        bookDto.setAvailability(txtAvailability.getText());
        bookDto.setBranchId(cmbBranch.getSelectionModel().getSelectedItem().getBranchId());
        return bookDto;
    }


    public void btnDeleteOnAction(ActionEvent actionEvent) {
        BookDto bookDto = collectData();
        try {
            bookBo.DeleteBook(bookDto.getBookId());
            new Alert(Alert.AlertType.INFORMATION, "Book Deleted Successfully").show();
            setTableData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        BookDto bookDto = collectData();
        try {
            bookBo.UpdateBook(bookDto);
            new Alert(Alert.AlertType.INFORMATION, "Book Updated Successfully").show();
            setTableData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void tblBookOnMouseClicked(MouseEvent mouseEvent) {
        BookTM selectedItem = (BookTM) tblBooks.getSelectionModel().getSelectedItem();
        if (selectedItem==null)return;
        txtTitle.setText(selectedItem.getTitle());
        txtAuthor.setText(selectedItem.getBookAuthor());
        txtGenre.setText(selectedItem.getCategory());
        txtAvailability.setText(selectedItem.getAvailability());

        System.out.println(selectedItem.getBookId());
        for (BranchCM item : cmbBranch.getItems()) {
            if (item.getBranchId() == selectedItem.getBranchId()) {
                cmbBranch.getSelectionModel().select(item);
                break;
            }
        }
    }
}
