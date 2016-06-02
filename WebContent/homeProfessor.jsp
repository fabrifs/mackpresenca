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
	<script type="text/javascript" src="jquery-2.2.4.js"></script>
	<script type="text/javascript" src="bootstrap.js"></script>	
	<link rel="stylesheet" type="text/css" href="bootstrap.css"/>
	<link href="style.css" rel="stylesheet"/>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home Professor - MackPresença</title>
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
		DisciplinaHorario dhteste = null;
		if (session.getAttribute("DHTESTE") != null) {
			dhteste = (DisciplinaHorario) session.getAttribute("DHTESTE");
		}

	%>
			<c:if test="${msg != null }">
			<div class="alert alert-danger" role="alert">${msg}</div>
		</c:if>
	<c:if test="<%=dhteste != null%>">		
		<!-- janela modal excluir-->
		<div class="modal fade" id="modal-aula">
			<div class="modal-dialog">
				<div class="modal-content">				
					<div class="modal-header">
						<h3>Iniciar Aula</h3>		
					</div>							
						<div class="modal-body">
						Disciplina:<%=dhteste.getDisciplina().getNomeDisciplina()%><br/>
						<%=dhteste.getTurma()%><br/><br/>
							<form action="MackPresenca?control=AulaComeco" method="post"> 
								<input type="hidden" value="<%=pf.getId()%>" name="pflogada"/>
								<input type="hidden" value="<%= dhteste.getId() %>" name="dhagoraid"/>		
								Sala Padrão: <input type="text" name="sala" value="<%=dhteste.getSalaPadrao()%>"/><br/> 
								Prédio Padrão: <input type="text" name="predio" value="<%=dhteste.getPredioPadrao()%>"/><br/> <br/> 
								<button class="btn btn-success">Começar Aula</button>
							</form>					
						</div>
							
					<div class="modal-footer">
						<button class="btn btn-danger" data-dismiss="modal">
							Fechar Formulário
						</button>
					</div>						
				</div>				
			</div>		
		</div>	

        <button class="btn btn-success" data-toggle="modal" data-target="#modal-aula">
			Iniciar Aula, <%=dhteste.getDisciplina().getNomeDisciplina()%><br/>
		</button>
		<br/>

	</c:if>		

		<c:if test="${lista != null }">
        <table style="width:100%">
				<tr>	
					<th>Disciplina</th>
					<th>Turma</th>	
					<th>Período</th>	
					<th>Dia da Semana</th>
					<th>Predio Padrão</th>		
					<th>Sala Padrão</th>						
				</tr>
				
					  <c:forEach items="${lista}" var="dh">
					<tr>
				        <td>${dh.disciplina.nomeDisciplina }</td>
				        <td>${dh.turma }</td>
				        <td>${dh.periodo}</td>
				        <td>${dh.diaSemana }</td>
				        <td>${dh.predioPadrao }</td>
				        <td>${dh.salaPadrao}</td>
				        </tr>
					</c:forEach>
				
			</table>
			
			</c:if>

		</div>

</body>
</html>