package dev.mfpmartins.javaservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

public class PagApp1 extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!request.isRequestedSessionIdValid()) {
            // A sessão não está válida...
            // Não podemos usar forward porque este não muda o Referer e cria ciclo em caso de erro
            response.sendRedirect("PagLogin?erro=" + URLEncoder.encode("Erro: sem sessão em PagApp1", "UTF-8"));
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"pt\">");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<title>PagApp1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>PagApp1</h2>");
            listaCookies(request, out);
            out.println("<br>");
            out.println("<a href=\"PagApp2\">PagApp2</a><br>");
            out.println("<a href=\"PagLogin\">Sair</a>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listaCookies(HttpServletRequest request, PrintWriter out) throws ServletException, IOException {
        out.println("<h3>Lista de cookies</h3>");
        Cookie[] aCookies = request.getCookies();
        if (aCookies != null) {
            int length = aCookies.length;
            for (int i = 0; i < length; i++) {
                out.println("<b>Nome =</b> " + aCookies[i].getName() + " ");
                out.println("<b>Valor =</b> " + aCookies[i].getValue() + "<br>");
            }
        } else {
            out.println("Não foram passados cookies!<br>");
        }
    }
}