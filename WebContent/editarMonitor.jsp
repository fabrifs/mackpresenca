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
	<script type="text/javascript" src="bootstrap.js"></script>
	<link rel="stylesheet" type="text/css" href="bootstrap.css" />
	<link href="style.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Editar Monitor - MackPresença</title>
</head>
<body>
	<header> <img src="img/logo.png" alt="logo" style="margin-bottom: 10px;"> </header>


<div class="well" style="width: 20%; height: 20%; float: left; margin-right: 10px; border: 1px solid black;">

		<%PessoaFisica pf = (PessoaFisica) session.getAttribute("pf");%>
		<b> Bem vindo, <%=pf.getNome()%> </b>
		<br/> 
		<br/> 
		RA: <%=pf.getRa()%>
		<br/> 
		<br/> 
		Data de nascimento: <%=pf.getNasc()%> 
		<br/> 
		<br/>
		E-mail: <%=pf.getEmail()%> 
		<br/> 
		<br/>
		<br/>

		<% if(pf.getTipo_acesso().equals("professor")){ %>
			<a href="homeProfessor.jsp"><button class="btn btn-danger" type="submit">Home</button></a>
			<br/>
		<%}else if(pf.getTipo_acesso().equals("aluno")){ %>
			<a href="homeAluno.jsp"><button class="btn btn-danger" type="submit">Home</button></a>
			
			<br/>
			<br/>
			<form action="MackPresenca?control=VerificaFalta" method="post">
				<input type="hidden" name="idAluno" value="<%=pf.getId()%>" />
				<button class="btn btn-danger" type="submit">Listar Faltas</button>
			</form> 
		
		<%} %>
		<br/>
			
		<form action="MackPresenca?control=ListarAula" method="post">
			<input type="hidden" value="listarDisciplina" name="operacao"/>
			<input type="hidden" value="<%=pf.getTipo_acesso()%>" name="tipoAcesso"/> 
			<input type="hidden" value="<%=pf.getId()%>" name="idPf"/>

			<button class="btn btn-danger" type="submit">Listar Aulas</button>
		</form>  
		<br/>	
		
		<form action="MackPresenca?control=Monitor" method="post">
			<input type="hidden" value="listar" name="operacao"/> 
			<input type="hidden" value="<%=pf.getTipo_acesso()%>" name="tipoAcesso"/> 
			<input type="hidden" value="<%=pf.getId()%>" name="idPf"/>

			<button class="btn btn-danger" type="submit">Listar Monitor</button>
		</form> 
		<br/>		
		
		<a href="MackPresenca?action=Logout"><button class="btn btn-danger" type="submit">Sair do Sistema</button></a>
	</div>

 <div class="well" style="width: 30%; height: 20%; margin-left: 15px; float: left; text-align: center; border: 1px solid black;">
 <%
		Monitor monitor = (Monitor) session.getAttribute("monitor");
	%>
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
				<button class="btn btn-success" type="submit">Editar Monitor</button>
			</form>

	<br>
	<br>
		<a href="monitoria.jsp"><button class="btn btn-danger" type="submit">Voltar</button></a>

</div>
	

</body>
</html>