package lk.ijse.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.Bo.BranchBo;
import lk.ijse.Bo.BranchBoImpl;
import lk.ijse.Regex.RegexPattern;
import lk.ijse.Tm.BranchTM;
import lk.ijse.dto.BranchDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ManageBranches {
    public TableColumn clmBranchId;
    public TableColumn clmName;
    public TableColumn clmBranch;
    public TableColumn clmAddress;
    public TableColumn clmContacts;
    public TableColumn clmUpdates;
    public TableColumn clmDel;

    public TextField txtName;
    public TextField txtAddress;
    public Label lblManageBooks1;
    public TextField txtContact;
    public TableView<BranchTM> tblBranch;

    public TableColumn clmDelete;
    public TableColumn clmUpdate;

    private int branchId;

    BranchBo branchBo = new BranchBoImpl();

    public  void  initialize(){
        setCellValueFactory();
        System.out.println("setCELLFACTORYCALLED");
        try {
            setTableValues();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).showAndWait();
        }
        System.out.println("settable values called");
        tableListener();
        System.out.println("table listner called");
    }

    private void setCellValueFactory() {
        clmBranchId.setCellValueFactory(new PropertyValueFactory<>("branchId"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("branchName"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        clmContacts.setCellValueFactory(new PropertyValueFactory<>("contact"));
        clmDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        clmUpdate.setCellValueFactory(new PropertyValueFactory<>("update"));



    }

    private void setData(BranchTM newValue) {
        txtContact.setText(newValue.getContact());
        txtAddress.setText(newValue.getAddress());
        txtName.setText(newValue.getBranchName());
        try {
            BranchDto branchDto = branchBo.getBranch(newValue.getBranchName());
            branchId = branchDto.getBranchId();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).showAndWait();
        }
    }


   /* public void setTableValues() throws SQLException {
        List<BranchTM>list = new ArrayList<>();
        List<BranchDto>allBranchs = branchBo.getAllBranches();

        for (BranchDto allBranches : allBranchs) {
            BranchTM branchTM = new BranchTM();
            branchTM.setBranchId(allBranches.getBranchId());
            branchTM.setBranchName(allBranches.getBranchName());
            branchTM.setAddress(allBranches.getAddress());
            branchTM.setContact(allBranches.getContact());
            Button button = new Button("Delete");
            Button button2 =new Button("Update");

            button.setOnAction(e -> {

                    boolean isDeleted = branchBo.DeleteBranch(branchId);

                    if(isDeleted){
                        new Alert(Alert.AlertType.CONFIRMATION, "Employee deleted!").showAndWait();
                    }
                 else {
                    new Alert(Alert.AlertType.ERROR,"Error Occured in Deleting").showAndWait();
                }
            });
            *//*button.getStyleClass().add("delete-button");*//*
            BranchTM.setOption(button);
            list.add(branchTM);
        }
        ObservableList<BranchTM> branchTMS = FXCollections.observableArrayList(list);
        tblBranch.setItems(branchTMS);
    }*/



    public void setTableValues() throws SQLException {
        List<BranchTM> list = new ArrayList<>();
        List<BranchDto> allBranches = branchBo.getAllBranches();

        for (BranchDto branchDto : allBranches) {
            BranchTM branchTM = new BranchTM();
            branchTM.setBranchId(branchDto.getBranchId());
            branchTM.setBranchName(branchDto.getBranchName());
            branchTM.setAddress(branchDto.getAddress());
            branchTM.setContact(branchDto.getContact());

            Button button = new Button("Delete");
            button.setOnAction(e -> {
                try {
                    boolean isDeleted = branchBo.DeleteBranch(branchDto.getBranchName());
                    if (isDeleted) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Branch deleted!").showAndWait();
                        setTableValues();
                    } else {
                        new Alert(Alert.AlertType.ERROR, "Error occurred in deleting").showAndWait();
                    }
                } catch (SQLException ex) {
                    new Alert(Alert.AlertType.ERROR, ex.getMessage()).showAndWait();
                }
            });

            Button button2 = new Button("Update");
            button2.setOnAction(e -> {
                txtName.setText(branchTM.getBranchName());
                txtAddress.setText(branchTM.getAddress());
                txtContact.setText(branchTM.getContact());
                branchId = (branchTM.getBranchId());
            });

            branchTM.setButton(button);
            branchTM.setButton2(button2);
            list.add(branchTM);
        }

        ObservableList<BranchTM> branchTMS = FXCollections.observableArrayList(list);
        tblBranch.setItems(branchTMS);
    }






    private void tableListener() {
        tblBranch.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData( newValue);
        });
    }



    public void btnClearOnAction(ActionEvent actionEvent) {
    }



    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String branchName = txtName.getText();
        if (!branchName.isEmpty()) {
            try {
                if (branchBo.DeleteBranch(branchName)) {
                    new Alert(Alert.AlertType.INFORMATION, "Branch deleted successfully!").show();
                    txtName.clear();
                    txtAddress.clear();
                    txtContact.clear();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Error deleting branch from the database").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Please enter the branch name to delete").show();
        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String branchName = txtName.getText();
        String address = txtAddress.getText();
        String contactNo = txtContact.getText();

        if (branchName.isEmpty() || address.isEmpty() || contactNo.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Fill All Fields").show();
            txtName.requestFocus();
            return;
        } else {
            BranchDto branchDto = new BranchDto( branchName, address, contactNo);
            try {
                if (branchBo.UpdateBranch(branchDto)) {
                    new Alert(Alert.AlertType.INFORMATION, "Branch updated successfully!").show();
                    txtName.clear();
                    txtAddress.clear();
                    txtContact.clear();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Error updating branch in the database").show();
            }
        }
        }


    public void btnSaveOnAction(ActionEvent actionEvent) {

        try {
            boolean b = branchBo.saveBranch(new BranchDto(txtName.getText(), txtContact.getText(), txtAddress.getText()));
            if (b) {
                new Alert(Alert.AlertType.CONFIRMATION, "Sucessfully added the branch");
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).showAndWait();
        }

    }

    public boolean validation(){
        if (!(Pattern.matches(String.valueOf(RegexPattern.getNamePattern()),txtName.getText()))){
            new Alert(Alert.AlertType.ERROR,"Invalid name").show();
            return  false;
        }
        if (!(Pattern.matches(String.valueOf(RegexPattern.getAddressPattern()),txtAddress.getText()))){
            new Alert(Alert.AlertType.ERROR,"Invalid Address").show();
            return  false;
        }
        if (!(Pattern.matches(String.valueOf(RegexPattern.getMobilePattern()),txtContact.getText()))){
            new Alert(Alert.AlertType.ERROR,"Invalid Contact Information").show();
            return  false;
        }


        return  true;

    }

}
