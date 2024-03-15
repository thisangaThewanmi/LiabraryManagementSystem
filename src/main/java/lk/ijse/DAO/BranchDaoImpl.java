package lk.ijse.DAO;

import lk.ijse.Entity.Branch;
import lk.ijse.Entity.User;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dto.BranchDto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class BranchDaoImpl implements BranchDao {
    @Override
    public boolean save(Branch entity) {
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
    public boolean update(Branch entity) throws SQLException {
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

            Query<Branch> query = session.createQuery("FROM Branch WHERE branchName = :branchName", Branch.class);
            query.setParameter("branchName", name);

            Branch branch = query.uniqueResult();
            if (branch != null) {
                session.delete(branch);
                transaction.commit(); // Committing transaction after deleting
                return true;
            } else {
                transaction.rollback(); // Rolling back transaction if branch is not found
                return false;
            }
        }

    @Override
    public void delete(int id) throws SQLException {

    }


    @Override
    public List<Branch> loadAll() throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        Query query = session.createQuery("FROM Branch ", Branch.class);
        transaction.commit();
        return query.getResultList();
    }


    @Override
    public Branch get(String data) throws SQLException {
        return null;
    }
}
