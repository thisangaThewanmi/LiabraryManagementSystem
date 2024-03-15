package lk.ijse.DAO;

import lk.ijse.Entity.Book;
import org.hibernate.Session;

public interface BookDao extends CrudDao<Book> {

    void updateAvailability(Session session, int bookId, String notAvailable);
}
