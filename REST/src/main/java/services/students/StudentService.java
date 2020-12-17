package services.students;

import com.zaxxer.hikari.HikariDataSource;
import entities.Student;
import exceptions.CustomSQLException;
import repositories.students.StudentRepository;
import services.IStudentService;

import javax.sql.DataSource;
import java.util.List;

public class StudentService implements IStudentService {

    private StudentRepository studentRepository;

    public StudentService(HikariDataSource dataSource) {
        studentRepository = new StudentRepository(dataSource);
    }
    @Override
    public void create(Student student) throws CustomSQLException {
        studentRepository.create(student);
    }

    @Override
    public Student readById(int id) throws CustomSQLException {
        return studentRepository.readById(id);
    }

    @Override
    public List<Student> readAll() throws CustomSQLException {
        return studentRepository.readAll();
    }

    @Override
    public void update(Student student) throws CustomSQLException {
        studentRepository.update(student);
    }

    @Override
    public void delete(Student student) throws CustomSQLException {
        studentRepository.delete(student);
    }
}
