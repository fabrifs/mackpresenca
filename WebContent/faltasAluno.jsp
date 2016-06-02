<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entity.PessoaFisica"%>
<html>
<head>
	<script type="text/javascript" src="bootstrap.js"></script>
	<link rel="stylesheet" type="text/css" href="bootstrap.css" />
	<link href="style.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Faltas - MackPresença</title>
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
      
      <h3><b>Tabela de Faltas</b></h3>
      
      <br/>
      
      <c:if test="${faltas != null }">
        <table style="width:100%">
				<tr>	
					<th>Disciplina</th>
					<th>Quantidade Aulas</th>	
					<th>Faltas Permitidas</th>	
					<th>Quantidade Faltas</th>
					<th>Faltas Restatnte</th>		
					<th>Porcentagem Faltas Restante</th>						
				</tr>
				
					  <c:forEach items="${faltas}" var="falta">
					<tr>
				        <td>${falta.nomeDisciplina }</td>
				        <td>${falta.quantidadeAulas }</td>
				        <td>${falta.faltasPermitida }</td>
				        <td>${falta.quantidadeFaltas }</td>
				        <td>${falta.faltasRestante }</td>
				        <td>${falta.porcentagemFaltas }</td>
				        </tr>
					</c:forEach>
				
			</table>
			
			</c:if>

      
        <br/>

        <br>
	</div>
</body>
</html>