package lk.ijse.Bo;

import lk.ijse.DAO.BranchDao;
import lk.ijse.DAO.BranchDaoImpl;
import lk.ijse.Entity.Branch;
import lk.ijse.dto.BranchDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchBoImpl implements BranchBo{

    BranchDao branchdao = new BranchDaoImpl();

    @Override
    public boolean saveBranch(BranchDto dto) {
       return branchdao.save(new Branch(dto.getBranchId(),dto.getBranchName(),dto.getContact(),dto.getAddress()));
    }

    @Override
    public boolean UpdateBranch(BranchDto dto) throws SQLException {

       return  branchdao.update(new Branch(dto.getBranchId(), dto.getBranchName(), dto.getContact(), dto.getAddress()));

    }

    @Override
    public boolean DeleteBranch(String name) throws SQLException {
        System.out.println("boImplbranchName"+name);
        return  branchdao.delete(name);

    }

    @Override
    public List<BranchDto> getAllBranches() throws SQLException {
        List<Branch> branches = branchdao.loadAll();
        List<BranchDto> dtos = new ArrayList<>();
        for (Branch branch : branches){
            dtos.add(new BranchDto(branch.getBranchId(), branch.getBranchName(), branch.getContact(), branch.getAddress()));
        }
        return dtos;
    }

    @Override
    public BranchDto getBranch(String text) throws SQLException {
        return null;
    }
}
