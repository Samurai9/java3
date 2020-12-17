package servlets;

import com.google.gson.Gson;
import entities.Student;
import exceptions.CustomSQLException;
import services.students.StudentService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class MainServlet extends HttpServlet {

    private StudentService studentService;
    private Gson gson;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        studentService = (StudentService) servletConfig.getServletContext().getAttribute("studentService");
        gson = new Gson();
        super.init(servletConfig);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Student> students = studentService.readAll();
            for (Student student: students){
                resp.getWriter().print(gson.toJson(student));
            }

        } catch (CustomSQLException e) {
            System.err.println(e.getMessage());
        }
        resp.getWriter().flush();
        resp.setContentType("application/json");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = gson.fromJson(req.getReader(), Student.class);
        try {
            studentService.create(student);
        } catch (CustomSQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = gson.fromJson(req.getReader(), Student.class);
        try {
            studentService.update(student);
        } catch (CustomSQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = gson.fromJson(req.getReader(), Student.class);
        try {
            studentService.delete(student);
        } catch (CustomSQLException e) {
            System.err.println(e.getMessage());
        }
    }
}