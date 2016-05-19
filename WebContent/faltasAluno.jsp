<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entity.PessoaFisica"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <%
 		PessoaFisica pf = (PessoaFisica) session.getAttribute("pf");
        //allow access only if session exists
           /* String user = (String) session.getAttribute("usuario");
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("usuario")) {
                        userName = cookie.getValue();
                    }
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            }*/
        %>
        <b><h1>
        Bem vindo aluno <%=pf.getNome() %>
        <br/>
        <br/>
        Seu RA é: <%=pf.getRa() %>
        <br/>
        <br/>
        Sua data de nascimento: <%= pf.getNasc() %>
        <br/>
        
        <c:forEach items="${disciplinas}" var="map">
        </br>
        Disciplina: ${map.key }</br>
        Falta: ${map.value }</br>

        </c:forEach>
        <br/>
		<a href="LogoutServlet">
				Sair do Sistema
		</a>
		
		
        
        </b></h1>
        <br>

</body>
</html>