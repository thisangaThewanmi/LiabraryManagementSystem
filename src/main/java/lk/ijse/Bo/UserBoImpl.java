package lk.ijse.Bo;

import lk.ijse.DAO.UserDao;
import lk.ijse.DAO.UserDaoImpl;
import lk.ijse.Entity.User;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;
import java.util.List;


public class UserBoImpl implements UserBo {

    UserDao userdao = new UserDaoImpl();
    @Override
    public boolean saveUser(UserDto dto) {
      return  userdao.save(new User(dto.getUserId(),dto.getName(),dto.getEmail(),dto.getPassword()));
    }

    @Override
    public boolean UpdateUser(UserDto dto) {
        return false;
    }

    @Override
    public boolean DeleteUser(UserDto dto) {
        return false;
    }

    @Override
    public List<UserDto> getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public UserDto getUser(String text) throws SQLException {
        return null;
    }
}
