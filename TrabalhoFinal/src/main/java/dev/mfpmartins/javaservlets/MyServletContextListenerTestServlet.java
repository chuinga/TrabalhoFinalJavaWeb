package dev.mfpmartins.javaservlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServletContextListenerTestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext myServletContext = this.getServletContext();
        String myUrl      = (String) myServletContext.getAttribute("myUrl");
        String myUser     = (String) myServletContext.getAttribute("myUser");
        String myPassword = (String) myServletContext.getAttribute("myPassword");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!doctype html>");
        out.println("<html lang=\"pt\">");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>Context Parameters</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Read Context Parameters from web.xml</h1>");
        out.println("<p>myUrl = " + myUrl + "</p>");
        out.println("<p>myUser = " + myUser + "</p>");
        out.println("<p>myPassword = " + myPassword + "</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}