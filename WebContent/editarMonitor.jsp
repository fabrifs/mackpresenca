<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entity.PessoaFisica"%>
<%@page import="entity.Monitor"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		PessoaFisica pf = (PessoaFisica) session.getAttribute("pf");
		Monitor monitor = (Monitor) session.getAttribute("monitor");
	%>
	<b> Bem vindo aluno <%=pf.getNome()%> 
	<br /> 
	<br /> 
	Seu RA é: <%=pf.getRa()%>
		<br /> 
		<br /> Sua data de nascimento: <%=pf.getNasc()%> <br /> 
		
		<!-- Lista de monitores, sem crud -->
		<form method="post" action="MackPresenca?control=Monitor">		

				<input type="hidden" value="<%=pf.getTipo_acesso()%>" name="tipoAcesso" /> 
				<input type="hidden" value="alterar" name="operacao" /> 
				<input type="hidden" value="<%=pf.getId()%>" name="idPf" /> 
				<input type="hidden" value="<%=monitor.getId()%>" name="idMonitor" /> 
				
				
				Disciplina: <input type="text" value="<%=monitor.getDisciplina().getNomeDisciplina()%>" readonly/>
				</br> 
				Nome Monitor: <input type="text" name="nomeMonitor" value="<%=monitor.getNomeAluno()%>"/> </br> 
				Horário: <input type="text" name="horario" value="<%= monitor.getHorario() %>"/> </br> 
				Dia da Semana: 
				<select name="diaSemana">

						<option value="SEGUNDA" selected>SEGUNDA</option>
						<option value="TERÇA">TERÇA</option>
						<option value="QUARTA">QUARTA</option>
						<option value="QUINTA">QUINTA</option>
						<option value="SEXTA">SEXTA</option>
				</select></br> 
				<input type="submit" value="Editar Monitor" />
			</form>

		<a href="monitoria.jsp"> Voltar</a> <br /> <br />


	</b>
	<br>

</body>
</html>