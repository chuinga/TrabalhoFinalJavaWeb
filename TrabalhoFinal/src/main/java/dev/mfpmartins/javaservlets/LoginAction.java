package dev.mfpmartins.javaservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;


public class P12_Session_02LoginAction extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getHeader("REFERER");
        if (s == null ) {
            s = "null";
        }
        // Validar que a servlet chamadora é PagLogin
        if (!s.contains("P12_Session_01Login.jsp")) {
            //A servlet chamadora não foi a que estamos à espera. Vamos direccionar para o formulário de entrada.
            //Não posso usar forward porque este não altera o Referer e portanto crio ciclo em caso de erro no primeiro login
            response.sendRedirect(response.encodeRedirectURL(
                    "P12_Session_01Login.jsp?erro=" + URLEncoder.encode("Erro: invocação direta de P12_Session_02LoginAction", "UTF-8")));
            return;
        }
        // A servlet chamadora foi a que estamos à espera
        // Vamos validar os dados de Login.
        if (!request.getParameter("userName").equals("Miguel Martins") || !request.getParameter("password").equals("Xpto_1234")) {
            response.sendRedirect(response.encodeRedirectURL(
                    "P12_Session_01Login.jsp?erro=" + URLEncoder.encode("Erro: User ou password inválidos", "UTF-8")));
            return;
        }
        //Para entrar na aplicação temos que criar nova sessão
        HttpSession hs = request.getSession();
        hs.setAttribute("Nome", "Jose Manuel");

        //Usamos sendRedirect para dar ao cliente o id de sessão caso use cookies
        response.sendRedirect(response.encodeRedirectURL("P12_Session_03Pagina1.jsp"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}