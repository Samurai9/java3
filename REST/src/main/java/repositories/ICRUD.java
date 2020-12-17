package repositories;

import exceptions.CustomSQLException;

import java.util.List;

public interface ICRUD<T> {
    void create(T entity) throws CustomSQLException;
    T readById(int id) throws CustomSQLException;
    List<T> readAll() throws CustomSQLException;
    void update(T entity) throws CustomSQLException;
    void delete (T entity) throws CustomSQLException;
}
