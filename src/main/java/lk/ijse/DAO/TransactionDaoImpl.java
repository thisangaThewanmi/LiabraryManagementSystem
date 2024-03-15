package lk.ijse.DAO;

import lk.ijse.Entity.Transaction;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
    @Override
    public void save(Transaction transaction, Session session) {

        session.persist(transaction);
    }


    public List<Object[]> getNotReturnedListByUserId(int userId, Session session) {
        Query<Object[]> query = session.createQuery("select t.id, t.book.id , t.book.title , t.book.category , t.borrowedDate , t.returnedDate from Transaction t where t.user.userId=:id and t.returned=false", Object[].class);
        query.setParameter("id",userId);
        return query.getResultList();
    }

    public void returnBook(int transactionId,Session session){
        Query query = session.createQuery("update Transaction  t set t.returned = true where t.id=:id");
        query.setParameter("id",transactionId);
        query.executeUpdate();
    }
}
