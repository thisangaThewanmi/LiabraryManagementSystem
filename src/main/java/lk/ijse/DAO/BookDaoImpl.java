package lk.ijse.DAO;

import jakarta.persistence.CacheRetrieveMode;
import jakarta.persistence.CacheStoreMode;
import jakarta.persistence.FlushModeType;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.Branch;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.*;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public boolean save(Book entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Book entity) throws SQLException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String name) throws SQLException {


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Book> query = session.createQuery("FROM Book WHERE title = :name", Book.class);
        query.setParameter("branchName", name);

       Book book = query.uniqueResult();
        if (book != null) {
            session.delete(book);
            transaction.commit(); // Committing transaction after deleting
            return true;
        } else {
            transaction.rollback(); // Rolling back transaction if branch is not found
            return false;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {

            session.createQuery("delete from Book where BookId = :id").setParameter("id", id).executeUpdate();
            session.delete(id);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Book> loadAll() throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        Query query = session.createQuery("FROM Book ", Book.class);
        transaction.commit();
        return query.getResultList();
    }

    @Override
    public Book get(String data) throws SQLException {
        return null;
    }

    @Override
    public void updateAvailability(Session session, int bookId, String notAvailable) {

    }
}