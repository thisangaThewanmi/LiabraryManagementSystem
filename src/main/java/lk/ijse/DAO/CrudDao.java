package lk.ijse.DAO;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T> {

    boolean save(T entity);

    boolean update(T entity) throws SQLException;
    boolean delete(String name) throws  SQLException;

    void delete(int id) throws  SQLException;
    List<T> loadAll() throws SQLException;
    T get(String data) throws SQLException;

}
