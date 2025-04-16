package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8+ driver class
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/loginDB", "root", "root"); // adjust DB URL and credentials

            PreparedStatement pst = conn.prepareStatement(
                "SELECT name FROM login WHERE email=? AND password=?");
            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Successful login, get user's name for personalized message
                String name = rs.getString("name");
                HttpSession session = request.getSession();
                session.setAttribute("user", name);

                // Redirect to welcome servlet
                response.sendRedirect("Welcome");
            } else {
                // Invalid credentials, show error and include login form again
                out.println("<p style='color:red;'>Invalid email or password. Please try again.</p>");
                request.getRequestDispatcher("Login.html").include(request, response);
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("<p>Database connection error.</p>");
        }
    }
}
