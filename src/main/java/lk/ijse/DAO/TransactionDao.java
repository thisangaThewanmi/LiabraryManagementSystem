package lk.ijse.DAO;

import lk.ijse.Entity.Transaction;
import org.hibernate.Session;

import java.util.List;

public interface TransactionDao {
    void save(Transaction transaction, Session session);
    List<Object[]> getNotReturnedListByUserId(int userId, Session session);
    void returnBook(int transactionId,Session session);
}
