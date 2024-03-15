package lk.ijse.Tm;

import javafx.scene.control.Button;

public class BranchTM {

    private  int branchId;
    private String branchName;
    private String contact;

    private String Address;

    private Button button;
    private Button button2;



    public BranchTM(int branchId, String branchName, String contact, String address) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.contact = contact;
        this.Address = address;

    }

    public BranchTM(String branchName, String contact, String address) {
        this.branchName = branchName;
        this.contact = contact;
        Address = address;

    }

    public BranchTM() {
    }

    public BranchTM(int branchId, String branchName, String contact, String address, Button button, Button button2) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.contact = contact;
        this.Address = address;
        this.button = button;
        this.button2 = button2;
    }

    public static void setOption(Button button) {
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }




    @Override
    public String toString() {
        return "BranchDto{" +
                "branchId='" + branchId + '\'' +
                ", branchName='" + branchName + '\'' +
                ", contact='" + contact + '\'' +
                ", Address='" + Address + '\'' +
                                '}';
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button button2) {
        this.button2 = button2;
    }
}
