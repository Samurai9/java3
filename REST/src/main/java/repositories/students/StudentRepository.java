package repositories.students;

import entities.Student;
import exceptions.CustomSQLException;
import repositories.ICRUD;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements ICRUD<Student> {

    //language=SQL
    private static final String SELECT_ALL = "SELECT * FROM students";
    //language=SQL
    private static final String SELECT_BY_ID = "SELECT * FROM students WHERE id = ?";
    //language=SQL
    private static final String CREATE_USER = "INSERT INTO students(name, age, course) VALUES (?,?,?)";
    //language=SQL
    private static final String UPDATE_BY_STUDENT_ID = "UPDATE students SET name = ?, age = ?, course = ? WHERE id = ?";
    //language=SQL
    private static final String DELETE_BY_USER_ID = "DELETE FROM students WHERE id = ?";


    private DataSource dataSource;

    public StudentRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public void create(Student entity) throws CustomSQLException{
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER);
            int index = 1;
            preparedStatement.setString(index, entity.getName());
            index++;
            preparedStatement.setInt(index, entity.getAge());
            index++;
            preparedStatement.setShort(index, entity.getCourse());
            index++;

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new CustomSQLException(e);
        }
    }

    @Override
    public Student readById(int id) throws CustomSQLException {
        Student student = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);

            int index = 1;
            preparedStatement.setInt(index, id);
            index++;

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getShort("course")
                );
            }
        } catch (SQLException e) {
            throw new CustomSQLException(e);
        }
        return student;
    }

    @Override
    public List<Student> readAll() throws CustomSQLException {
        List<Student> students = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getShort("course")
                ));
            }
        } catch (SQLException e) {
            throw new CustomSQLException(e);
        }
        return students;
    }

    @Override
    public void update(Student entity) throws CustomSQLException {
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_STUDENT_ID);
            int index = 1;
            preparedStatement.setString(index, entity.getName());
            index++;
            preparedStatement.setInt(index, entity.getAge());
            index++;
            preparedStatement.setShort(index, entity.getCourse());
            index++;
            preparedStatement.setInt(index, entity.getId());
            index++;

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new CustomSQLException(e);
        }
    }

    @Override
    public void delete(Student entity) throws CustomSQLException {
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_USER_ID);
            int index = 1;
            preparedStatement.setInt(index, entity.getId());
            index++;

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new CustomSQLException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
