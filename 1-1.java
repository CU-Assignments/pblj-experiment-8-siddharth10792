package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            String name = (String) session.getAttribute("user");
            out.println("<h1>Welcome, " + name + "!</h1>");
            out.println("<form action='LogoutServlet' method='post'>");
            out.println("<input type='submit' value='Logout' />");
            out.println("</form>");
        } else {
            // No user logged in, redirect to login page
            response.sendRedirect("Login.html");
        }
    }
}
