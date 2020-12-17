package services;

import entities.Student;
import exceptions.CustomSQLException;

import java.util.List;

public interface IStudentService {
    void create(Student student) throws CustomSQLException;
    Student readById(int id) throws CustomSQLException;
    List<Student> readAll() throws CustomSQLException;
    void update(Student student) throws CustomSQLException;
    void delete (Student student) throws CustomSQLException;
}
