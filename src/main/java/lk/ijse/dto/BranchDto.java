package lk.ijse.dto;

public class BranchDto {

    private  int branchId;
    private String branchName;
    private String contact;

    private String Address;



    public BranchDto(int branchId, String branchName, String contact, String address) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.contact = contact;
        this.Address = address;

    }

    public BranchDto(String branchName, String contact, String address) {
        this.branchName = branchName;
        this.contact = contact;
        Address = address;

    }

    public BranchDto() {
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
}
