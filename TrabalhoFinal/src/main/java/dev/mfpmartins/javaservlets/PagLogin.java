package dev.mfpmartins.javaservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class PagLogin extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Vai buscar a sessão incluida no pedido ou cria uma nova
        HttpSession session = request.getSession();
        // Invalida a sessão
        session.invalidate();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"pt\">");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>PagLogin</title>");
        out.println("</head>");
        out.println("<body>");

        String txtError1 = request.getParameter("erro");
        if (txtError1 != null) {
            out.println(txtError1);
            out.println("<HR>");
        }

        out.println("<h2>PagLogin - Iniciar aplicação</h2>");
        out.println("<form action=\"PagLoginAction\" METHOD=\"get\">");
        out.println("<input type=\"submit\" Value=\"Iniciar\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}