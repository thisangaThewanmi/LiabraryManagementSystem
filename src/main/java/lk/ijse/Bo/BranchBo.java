package lk.ijse.Bo;

import lk.ijse.dto.BranchDto;

import java.sql.SQLException;
import java.util.List;

public interface BranchBo {
    public boolean saveBranch(BranchDto dto);

    public boolean UpdateBranch(BranchDto dto) throws SQLException;

    public boolean DeleteBranch(String name) throws SQLException;


    List<BranchDto> getAllBranches() throws SQLException;

    BranchDto getBranch(String text) throws SQLException;
}
