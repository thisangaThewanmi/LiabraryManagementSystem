package lk.ijse.Bo;

import lk.ijse.DAO.BookDao;
import lk.ijse.DAO.BookDaoImpl;
import lk.ijse.Entity.Book;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.BranchDto;

import java.sql.SQLException;
import java.util.List;


public class BookBoImpl implements BookBo{

    BookDao bookdao = new BookDaoImpl();

    @Override
    public boolean saveBook(BookDto dto) {
        return bookdao.save(new Book(dto.getBookId(), dto.getTitle(), dto.getAuthor(), dto.getCategory(), dto.getAvailability(), dto.getCopies()));
    }

    @Override
    public boolean UpdateBook(BookDto dto) throws SQLException {
        Book book = new Book(dto.getBookId(),dto.getTitle(),dto.getAuthor(),dto.getCategory(),dto.getAvailability(),dto.getCopies());
        return bookdao.update(book);
    }

    @Override
    public boolean DeleteBook(String name) throws SQLException {
        return false;
    }

    @Override
    public List<BookDto> getAllBook() throws SQLException {
        return null;
    }

    @Override
    public BookDto getBook(String text) throws SQLException {
        return null;
    }
}
