package lk.ijse.Bo;

import lk.ijse.Entity.Book;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.BranchDto;

import java.sql.SQLException;
import java.util.List;

public interface BookBo {
    public boolean saveBook(BookDto dto);

    public boolean UpdateBook(BookDto dto) throws SQLException;

    public boolean DeleteBook(String name) throws SQLException;

    public boolean DeleteBook(int  id) throws SQLException;


    List<BookDto> getAllBook() throws SQLException;

    BookDto getBook(String text) throws SQLException;


}
