<%--
    Document   : P12_Session_03Pagina1.jsp
    Author     : TurtleLearning.com: Jose Aser
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.net.URLEncoder"%>
<%--  <%@page import="java.io.PrintWriter"%> --%>
<%@page import="jakarta.servlet.jsp.JspWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="P11_PaginaErro.jsp" %>

<%!
    private void listaCookies(HttpServletRequest request, JspWriter out) throws ServletException, IOException {
        out.println("<h3>Lista de cookies</h3>");
        Cookie[] aCookies = request.getCookies();
        if (aCookies != null) {
            for (int i = 0; i < aCookies.length; i++) {
                out.println("<b>Nome =</b> " + aCookies[i].getName() + " ");
                out.println("<b>Valor =</b> " + aCookies[i].getValue() + "<br>");
            }
        } else {
            out.println("Não foram passados cookies!<br>");
        }
    }

    private void listaSessionAttributes(HttpSession session, JspWriter out) throws IOException {
        out.println("<hr>");
        out.println("<h3>Lista de Atributos de sessão</h3>");
        // variável session é criada/instânciada pela JSP
        if (session != null) {
            Enumeration<String> aAttrib = session.getAttributeNames();
            if (aAttrib != null) {
                while (aAttrib.hasMoreElements()) {
                    String s = aAttrib.nextElement().toString();
                    out.println("<b>Nome =</b> " + s + "  ");
                    out.println("<b>Valor =</b> " + session.getAttribute(s) + "<br>");
                }
            } else {
                out.println("Não foram criados atributos de sessão!<br>");
            }
        } else {
            out.println("Não foi criada sessão!<br>");
        }
    }
%>

<%-- Fim das definições e inicio do código do método service() --%>
<%-- Repare que a Scriptlet anterior tem "!" enquanto a próxima não tem, e isto diferencia o código que vai 
     colocado no método service com o que faz parte das definições  --%>
<%
    //este código é executado antes de começar a escrever o HTML
    if (!request.isRequestedSessionIdValid()) {
        // A sessão não está válida...
        // Não podemos redirecionar com forward porque não muda o Rererer e isso é necessário para LoginAction
        response.sendRedirect(response.encodeRedirectURL(
                "P12_Session_01Login.jsp?erro=" + URLEncoder.encode("Erro: Sessão inválida em P12_Session_03Pagina1.jsp", "UTF-8")));
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>P12_Session_03Pagina1</title>
</head>
<body>
    <h1>Página 1 da Aplicação</h1>
    <%
        listaCookies(request, out);
        // a variável session é inicializada pela JSP
        listaSessionAttributes(session, out);
    %>
    <br>
    <br>
    <a href="<%= response.encodeURL("P12_Session_03Pagina2.jsp") %>">P12_Session_03Pagina2.jsp</a><br>
    <a href="<%= response.encodeURL("P12_Session_01Login.jsp") %>">Sair da aplicação</a><br>
</body>
</html>