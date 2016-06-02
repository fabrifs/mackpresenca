
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>


    <head>
    
    	<script type="text/javascript" src="bootstrap.js"></script>
		<link rel="stylesheet" type="text/css" href="bootstrap.css" />
        <meta charset="UTF-8">
        <title >Login Mack Presença</title>
    </head>
    <body>

	<div class="well" style="width: 350px; height: 400px;">
		<c:if test="${msg != null }">
			<div class="alert alert-danger" role="alert">${msg}</div>
		</c:if>
        <form action="MackPresenca?control=Login" method="post"> 
			<input type="radio" name="tipoAcesso" value="professor"/> Professor
			<input type="radio" name="tipoAcesso" value="aluno"/> Aluno
			<br><br>
			<div class="form-group">
           	RA:<input type="text" name="ra" required class="form-control" placeholder="RA" style="width: 100px;"/>
            <br>
            Senha: <input type="password" name="senha" required class="form-control" placeholder="Senha" style="width: 100px;"/>
            <br>
              </div>
            <button type="submit" class="btn btn-default">Submit</button>    
          
        </form>
        
        </div>  
     
     
    </body>
</html>
