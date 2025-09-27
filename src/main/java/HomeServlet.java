import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final String URL = "jdbc:mysql://127.0.0.1:3307/be08db";
    private final String USER = "user";
    private final String PASS = "password";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String courseParam = request.getParameter("class");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            List<Student> students = new ArrayList<>();
            // Use a single connection
            try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

                // Get default course if none supplied
                if (courseParam == null || courseParam.isEmpty()) {
                    try (Statement stmt = conn.createStatement();
                         ResultSet rs = stmt.executeQuery("SELECT course FROM students ORDER BY id DESC LIMIT 1")) {
                        if (rs.next()) {
                            courseParam = rs.getString("course");
                        } else {
                            courseParam = "BE08"; // fallback
                        }
                    }
                }

                // Fetch students for that course
                String sql = "SELECT id, name, course FROM students WHERE course = ?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, courseParam);
                    try (ResultSet rs = ps.executeQuery()) {
                        while (rs.next()) {
                            students.add(new Student(
                                    rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getString("course")
                            ));
                        }
                    }
                }
            }

            request.setAttribute("course", courseParam);
            request.setAttribute("studentList", students);
            RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}