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
        <b>
        Bem vindo aluno <%=pf.getNome() %>
        <br/>
        <br/>
        Seu RA �: <%=pf.getRa() %>
        <br/>
        <br/>
        Sua data de nascimento: <%= pf.getNasc() %>
        <br/>
        
        <c:forEach items="${lista}" var="dh">
        </br></br>
        Disciplina: ${dh.disciplina.nomeDisciplina }</br>
        Turma: ${dh.turma }</br>
        Per�odo: ${dh.periodo}</br>
        Dia da Semana: ${dh.diaSemana }</br>
        Predio Padr�o: ${dh.predioPadrao }</br>
        Sala Padr�o: ${dh.salaPadrao}
        
        </br></br>
        </c:forEach>
        <br/>
		<a href="MackPresenca?action=Logout">
				Sair do Sistema
		</a>
		<br/><br/>
		<form action="MackPresenca?control=VerificaFalta" method="post">
			<input type="hidden" name="idAluno" value="<%= pf.getId() %>"/>
			<input type="submit" value="Listar Faltas"/>
		</form>

		
		<form action="MackPresenca?control=Monitor" method="post">
			<input type="hidden" value="listar" name="operacao"/>
			<input type="hidden" value="aluno" name="tipoAcesso"/>
			<input type="hidden" value="<%= pf.getId() %>" name="idPf"/>
			
			
 			<input type="submit" value="Listar Monitor"/>
		</form>
		
		<form action="MackPresenca?control=ListarAula" method="post">
			<input type="hidden" value="listarDisciplina" name="operacao"/>
			<input type="hidden" value="professor" name="tipoAcesso"/>
			<input type="hidden" value="<%= pf.getId() %>" name="idPf"/>
			
			
 			<input type="submit" value="Listar Aulas"/>
		</form>
        
        </b>
        
        ${msg }
        <br>

</body>
</html>