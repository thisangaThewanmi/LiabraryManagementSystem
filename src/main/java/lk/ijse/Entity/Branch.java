package lk.ijse.Entity;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class Branch{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int branchId;
    @Column(nullable = false)
    private String branchName;

    private String contact;

    private String Address;

    @OneToMany(mappedBy = "branch")
    private List<Book> books;

    public Branch(String branchName, String contact, String address) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.contact = contact;
        this.Address = address;
        this.books=books;


    }

    public Branch() {
    }

    public Branch(int branchId, String branchName, String contact, String address) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.contact = contact;
        this.Address = address;
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
        return "Branch{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", contact='" + contact + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
