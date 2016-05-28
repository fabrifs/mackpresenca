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
			Professor:
			<%=pf.getNome()%>
			<br />

			<form action="MackPresenca?control=AulaFim" method="post">

				<input type="hidden" name="idAula" value="${idAula}" />
				<input type="hidden" name="idDh" value="${idDh}" />

				<c:if test="${alunos != null }">

					<c:forEach items="${alunos}" var="aluno">

				        Nome: ${aluno.nome}, 
				        Tia: ${aluno.ra}
				        <input type="checkbox" name="alunos_faltantes"
							value="${aluno.id}" />
						<br />

					</c:forEach>
				</c:if>
				Conteúdo da aula:<br /> <input type="textfield" name="comentario" required /> <br /><br />
				<input type="submit" value="Finalizar" />
			</form>
			<br /> <a href="homeProfessor.jsp"> Home </a></b>
	<br>

</body>
</html>