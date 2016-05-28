<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>

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
	%>
	<b> Bem vindo aluno <%=pf.getNome()%> 
	<br /> 
	<br /> 
	Seu RA é: <%=pf.getRa()%>
		<br /> 
		<br /> Sua data de nascimento: <%=pf.getNasc()%> <br /> 
		
		<!-- Lista de monitores, sem crud -->
		<form action="MackPresenca?control=ListarAula" method="post">
		
			<input type="hidden" name="tipoAcesso" value="<%= pf.getTipo_acesso() %>"/>
			<input type="hidden" name="operacao" value="listarAula"/>
			
			<input type="hidden" value="<%= pf.getId() %>" name="idPf"/>
		
			<h1>Listar aulas Passadas</h1>
			<c:if test="${disciplinas  != null}">
				Disciplina: 
				<select name="idDisciplina">
					<option value="DEFAULT">-Disciplina-</option>
					<c:forEach items="${disciplinas}" var="di">
						<option value="${di.id }">${di.nomeDisciplina }</option>
					</c:forEach>
				</select>
			</c:if>
			
			Data Inicio: <input type="date" name="dataInicio" required/>
			
			Data Fim: <input type="date" name="dataFim" required/>
			
			<input type="submit" value="Listar Aulas"/>
			
		</form>
		
		<c:if test="${aulas  != null}">
				Aulas: 

					<c:forEach items="${aulas}" var="aula">
						Comentário: ${aula.comentario }
						Professor: ${aula.professor.nome }
						Disciplina: ${aula.disciplinaHorario.disciplina.nomeDisciplina }
						<br/>
						<br/>
					</c:forEach>
			</c:if>

		
		<% if(pf.getTipo_acesso().equals("professor")){ %>
			<a href="homeProfessor.jsp"> Home </a> <br /> <br />
		<%}else if(pf.getTipo_acesso().equals("aluno")){ %>
			<a href="homeAluno.jsp"> Home </a> <br /> <br />
		<%} %>
		

	</b>
	<br>

</body>
</html>