package lk.ijse.Bo;

import lk.ijse.DAO.BookDao;
import lk.ijse.DAO.BookDaoImpl;
import lk.ijse.DAO.TransactionDao;
import lk.ijse.DAO.TransactionDaoImpl;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.Transaction;
import lk.ijse.Entity.User;
import lk.ijse.Tm.NotReturnedTM;
import lk.ijse.config.FactoryConfiguration;

import lk.ijse.dto.TransactionDto;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowBookRecordBoImpl implements BorrowBookRecordBo {
    FactoryConfiguration factory = FactoryConfiguration.getInstance();
    TransactionDao transactionDao = new TransactionDaoImpl();
    BookDao bookDao = new BookDaoImpl();
    public void borrowBook(TransactionDto transactionDto) {
        Session session = factory.getSession();
        org.hibernate.Transaction transaction1 = session.beginTransaction();

        try{
            Book book = new Book();
            book.setBookId(transactionDto.getBookId());
            User user = new User();
            user.setUserId(transactionDto.getUserId());
            session.detach(book);
            session.detach(user);

            Transaction transaction = new Transaction();
            transaction.setBook(book);
            transaction.setUser(user);
            transaction.setBorrowedDate(transactionDto.getBorrowedDate());
            transaction.setReturnedDate(transactionDto.getReturnedDate());
            transaction.setReturned(false);
            transactionDao.save(transaction,session);
            bookDao.updateAvailability(session,transactionDto.getBookId(),"Not Available");

            transaction1.commit();

        }catch (Exception e){
            transaction1.rollback();
        }finally {
            session.close();
        }


    }

    public List<NotReturnedTM> getNotReturnedListByUserId(int userId) {
        Session session = factory.getSession();
        List<NotReturnedTM> list = new ArrayList<>();
        try{
            List<Object[]> notReturnedListByUserId = transactionDao.getNotReturnedListByUserId(userId, session);
            for (Object[] objects : notReturnedListByUserId) {
                NotReturnedTM notReturnedTM = new NotReturnedTM();
                notReturnedTM.setTransactionId((Integer) objects[0]);
                notReturnedTM.setBookId((Integer) objects[1]);
                notReturnedTM.setTitle((String) objects[2]);
                notReturnedTM.setCategory((String) objects[3]);
                notReturnedTM.setBorrowedDate((LocalDate) objects[4]);
                notReturnedTM.setReturnedDate((LocalDate) objects[5]);
                list.add(notReturnedTM);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    public void returnBook(NotReturnedTM obj){
        Session session = factory.getSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        try{
            transactionDao.returnBook(obj.getTransactionId(),session);
            bookDao.updateAvailability(session,obj.getBookId(),"Available");
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }

    }


}
