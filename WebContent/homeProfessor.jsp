<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entity.PessoaFisica"%>
<%@page import="entity.DisciplinaHorario"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		PessoaFisica pf = (PessoaFisica) session.getAttribute("pf");
		DisciplinaHorario dhteste = null;
		if (session.getAttribute("DHTESTE") != null) {
			dhteste = (DisciplinaHorario) session.getAttribute("DHTESTE");
		}
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
			<p style="color:red;">${msg}</p>
			Bem vindo professor
			<%=pf.getNome()%>
			<br /> <br /> Seu RA �:
			<%=pf.getRa()%>
			<br /> <br /> Sua data de nascimento:
			<%=pf.getNasc()%>
			<br /> <br />
			<c:if test="<%=dhteste != null%>">
        		DH:<%=dhteste.getTurma()%>
        		<form action="AulaServlet?control=AulaComeco" method="post"> 
        		<input type="hidden" value="<%=pf.getId()%>" name="pflogada"/> 
        			<input type="hidden" value="<%= dhteste.getId() %>" name="dhagoraid"/>   		
        			Sala Padr�o: <input type="text" name="sala" value="<%=dhteste.getSalaPadrao()%>"/>
        			Pr�dio Padr�o: <input type="text" name="predio" value="<%=dhteste.getPredioPadrao()%>"/>
        			<input type="submit" value="Come�ar"/>
        		</form>
			</c:if>

			<br />
			<br />
			<c:if test="${lista != null }">
			<c:forEach items="${lista}" var="dh">
				</br>
				</br>
		        Disciplina: ${dh.disciplina.nomeDisciplina }</br>
		        Turma: ${dh.turma }</br>
		        Per�odo: ${dh.periodo}</br>
		        Dia da Semana: ${dh.diaSemana }</br>
		        Predio Padr�o: ${dh.predioPadrao }</br>
		        Sala Padr�o: ${dh.salaPadrao}
        
        </br>
				</br>
			</c:forEach>
			</c:if>
			<br /> <a href="LogoutServlet"> Sair do Sistema </a></b>
			
	<br>
	
	<form action="LoginServlet?control=Monitor" method="post">
			<input type="hidden" value="listar" name="operacao"/>
			<input type="hidden" value="professor" name="tipoAcesso"/>
			<input type="hidden" value="<%= pf.getId() %>" name="idPf"/>
			
			
 			<input type="submit" value="Listar Monitor"/>
		</form>

</body>
</html>