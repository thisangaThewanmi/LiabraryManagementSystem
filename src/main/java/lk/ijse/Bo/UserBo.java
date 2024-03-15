package lk.ijse.Bo;

import lk.ijse.dto.BookDto;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface UserBo {

    public boolean saveUser(UserDto dto);

    public boolean UpdateUser(UserDto dto);

    public boolean DeleteUser(UserDto dto);


    List<UserDto> getAllUsers() throws SQLException;

    UserDto getUser(String text) throws SQLException;

}