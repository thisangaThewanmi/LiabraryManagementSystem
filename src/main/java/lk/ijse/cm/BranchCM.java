package lk.ijse.cm;

public class BranchCM {
    private String branchName;
    private int branchId;

    public BranchCM() {
    }

    public BranchCM(String branchName, int branchId) {
        this.branchName = branchName;
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}
