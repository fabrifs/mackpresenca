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
		<c:if test="${monitorGeral  != null}">
		
		<h1>Lista de Monitores</h1>
			<c:forEach items="${monitorGeral}" var="mo">
		        Disciplina: ${mo.disciplina.nomeDisciplina }</br>
		        Turma: ${mo.horario }</br>
		        Período: ${mo.nomeAluno}</br>
		        </br>
			</c:forEach> 
		</c:if>
		
		<!-- Se for professor, exibe para inserção --> 
		<c:if test="${professorValido != null }">
		<h1>Opções para manter monitor</h1>
			<form method="post" action="LoginServlet?control=Monitor">

				<input type="hidden" value="<%=pf.getTipo_acesso()%>" name="tipoAcesso" /> 
				<input type="hidden" value="incluir" name="operacao" /> 
				<input type="hidden" value="<%=pf.getId()%>" name="idPf" /> 
				Disciplina: <select name="idDisciplina">
					<c:forEach items="${disciplinas}" var="di">
						<option value="${di.id }">${di.nomeDisciplina }</option>
					</c:forEach>
				</select>
				</br> 
				Nome Monitor: <input type="text" name="nomeMonitor" /> </br> 
				Horário: <input type="text" name="horario" /> </br> 
				Dia da Semana: 
				<select name="diaSemana">
					<option value="SEGUNDA">SEGUNDA</option>
					<option value="TERÇA">TERÇA</option>
					<option value="QUARTA">QUARTA</option>
					<option value="QUINTA">QUINTA</option>
					<option value="SEXTA">SEXTA</option>
				</select></br> 
				<input type="submit" value="Cadastrar Monitor" />
			</form>

		</c:if> <!-- Se for professor, exibe para editar/deletar --> 
		<c:if test="${monitorCoord != null }">
			<c:forEach items="${monitorCoord}" var="mo">
				</br>
	        Disciplina: ${mo.disciplina.nomeDisciplina }</br>
	        Turma: ${mo.horario }</br>
	        Período: ${mo.nomeAluno}</br>
	        <form action="LoginServlet?control=Monitor" method="post">
	        	<input type="hidden" value="<%=pf.getTipo_acesso()%>" name="tipoAcesso" /> 
				<input type="hidden" value="excluir" name="operacao" /> 
				<input type="hidden" value="<%=pf.getId()%>" name="idPf" /> 
				<input type="hidden" value="${mo.id }" name="idMonitor" /> 
				
				
				<input type="submit" value="Excluir"/>
	        </form>
	        
	         <form action="LoginServlet?control=Monitor" method="post">
	        	<input type="hidden" value="<%=pf.getTipo_acesso()%>" name="tipoAcesso" /> 
				<input type="hidden" value="editarCarrega" name="operacao" /> 
				<input type="hidden" value="<%=pf.getId()%>" name="idPf" /> 
				<input type="hidden" value="${mo.id }" name="idMonitor" /> 
				
				
				<input type="submit" value="Editar"/>
	        </form>

			</c:forEach>
		</c:if> 
		<br /> 
		<a href="LogoutServlet"> Sair do Sistema </a> <br /> <br />


	</b>
	<br>

</body>
</html>