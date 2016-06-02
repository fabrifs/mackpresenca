<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entity.PessoaFisica"%>
<html>
<head>
	<script type="text/javascript" src="jquery-2.2.4.js"></script>
	<script type="text/javascript" src="bootstrap.js"></script>	
	<link rel="stylesheet" type="text/css" href="bootstrap.css"/>
	<link href="style.css" rel="stylesheet"/>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	
	<title>Monitoria - MackPresença</title>
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
		<!-- Lista de monitores, sem crud -->
		<c:if test="${monitorGeral  != null}">
		
		<h1>Lista de Monitores</h1>
		<table style="width:100%">
				<tr>	
					<th>Disciplina</th>
					<th>Período</th>
					<th>Dia da Semana</th>
					<th>Horário</th>										
					
				</tr>
					<c:forEach items="${monitorGeral}" var="mo">
					<tr>
						<td>${mo.disciplina.nomeDisciplina}</td>
						<td>${mo.nomeAluno}</td>
						<td>${mo.dia_semana}</td>
						<td>${mo.horario }</td>
					</tr>
					</c:forEach>
			</table>

		</c:if>
		
		<!-- Se for professor, exibe para inserção --> 
		<c:if test="${professorValido != null }">
		<h1>Opções para manter monitor</h1>
		
		<button class="btn btn-success" data-toggle="modal" data-target="#janela">
				Cadastrar Monitor
		</button>
		<br/>
		<br/>
		
		<!-- janela modal -->
		<div class="modal fade" id="janela">
			<div class="modal-dialog">
				<div class="modal-content">				
					<div class="modal-header">
						<h3>Cadastro de Usuário</h3>		
					</div>
							
						<div class="modal-body">
							<form method="post" action="MackPresenca?control=Monitor">

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
								<input type="submit" value="Cadastrar Monitor" class="btn btn-success"/> 
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

		</c:if> 
		
		<!-- Se for professor, exibe para editar/deletar --> 
		<c:if test="${monitorCoord != null }">
		
			<table style="width:100%">
				<tr>	
					<th>Disciplina</th>
					<th>Período</th>
					<th>Dia da Semana</th>
					<th>Horário</th>
					<th>Editar</th>
					<th>Excluir</th>					
					
				</tr>
				<c:forEach items="${monitorCoord}" var="mo">
					<tr>
						<td>${mo.disciplina.nomeDisciplina}</td>
						<td>${mo.nomeAluno}</td>
						<td>${mo.dia_semana}</td>
						<td>${mo.horario }</td>
						<td>
							<form action="MackPresenca?control=Monitor" method="post">
								<input type="hidden" value="<%=pf.getTipo_acesso()%>" name="tipoAcesso" /> 
								<input type="hidden" value="editarCarrega" name="operacao" /> 
								<input type="hidden" value="<%=pf.getId()%>" name="idPf" /> 
								<input type="hidden" value="${mo.id }" name="idMonitor" /> 
								<button class="btn btn-info" type="submit">Editar</button>
							</form>
						</td>
						<td>
							<form action="MackPresenca?control=Monitor" method="post">
								<input type="hidden" value="<%=pf.getTipo_acesso()%>" name="tipoAcesso" /> 
								<input type="hidden" value="excluir" name="operacao" /> 
								<input type="hidden" value="<%=pf.getId()%>" name="idPf" /> 
								<input type="hidden" value="${mo.id }" name="idMonitor" /> 
								<button class="btn btn-warning" type="submit">Excluir</button>
							</form>	
						</td>
					</tr>
				</c:forEach>
		
			</table>
		</c:if> 
		<br /> 

	<br>
</div>
</body>
</html>