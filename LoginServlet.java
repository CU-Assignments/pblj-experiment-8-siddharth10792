import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple credential validation (replace with DB check in production)
        if ("admin".equals(username) && "admin123".equals(password)) {
            // Store username in session for personalization
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to welcome page
            response.sendRedirect("WelcomeServlet");
        } else {
            // Invalid credentials, show error and reload login
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<p style='color:red;'>Invalid username or password.</p>");
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.include(request, response);
        }
    }
}
