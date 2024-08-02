package dev.mfpmartins.javaservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;

public class PagLoginAction extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Validar que a servlet chamadora é PagLogin
        String s = request.getHeader("REFERER");
        if (s == null || !s.contains("/PagLogin")) {
            // A servlet chamadora não foi a que estamos à espera.
            // Vamos direccionar para o formulário de entrada.
            // Não podemos usar forward porque este não muda o Referer e cria ciclo em caso de erro
            // Por causa dos caracteres portugueses temos que usar URLEncoder
            response.sendRedirect(
                    "PagLogin?erro=" + 
                    URLEncoder.encode("Erro: invocação direta de PagLoginAction", "UTF-8"));
        } else {
            // A servlet chamadora foi a que estamos à espera
            // Para entrar na aplicação temos que criar nova sessão
            @SuppressWarnings("unused")
            HttpSession hs = request.getSession();
            // Usamos sendRedirect para dar ao cliente o cookie de sessao
            response.sendRedirect("PagApp1");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}