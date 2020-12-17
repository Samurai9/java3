package listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import services.students.StudentService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Properties;


@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        Properties properties = new Properties();
        try {
            properties.load(servletContext.getResourceAsStream("/WEB-INF/properties/dbConnection.properties"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(properties.getProperty("DB_URL"));
        hikariConfig.setDriverClassName(properties.getProperty("DB_DRIVER_CLASSNAME"));
        hikariConfig.setUsername(properties.getProperty("DB_USERNAME"));
        hikariConfig.setPassword(properties.getProperty("DB_PASSWORD"));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(properties.getProperty("DB_MAX_POOL_SIZE")));

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        StudentService studentService = new StudentService(dataSource);

        servletContext.setAttribute("studentService", studentService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.removeAttribute("studentService");
    }
}
