<%-- 
    Document   : P12_Session_01Login.jsp
    Author     : TurtleLearning.com: Jose Aser
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="P11_PaginaErro.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>P12_Session_01Login</title>
</head>
<body>
<%
    // Não é necessário declarar Session, porque isso é feito pela JSP
    // A variável já existe e está inicializada
    // Vamos invalidar a sessão
    session.invalidate();
    String txtError1  = request.getParameter("erro");
    if (txtError1 != null) {
        out.println("<div style=\"color: red;\">" + txtError1 + "</div>");
        out.println("<HR>");
    }
%>
<h1>Página de Login</h1>
<form action="P12_Session_02LoginAction" method="get">
    <table>
        <tr>
            <td>Nome do utilizador:</td>
            <td><input name="userName" type="text" value="Miguel Martins"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input name="pwd" type="password" value="Xpto_1234"></td>
        </tr>
        <tr>
            <td colspan="2"> <input type="submit" value="Enviar"></td>
        </tr>
    </table>
</form>
</body>
</html>