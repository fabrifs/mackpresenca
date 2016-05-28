<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title >Login Mack Presença</title>
    </head>
    <body>

        <form action="MackPresenca?control=Login" method="post">
			
			<input type="radio" name="tipoAcesso" value="professor"/> Professor
			<input type="radio" name="tipoAcesso" value="aluno"/> Aluno
			<br><br>
           	RA:<input type="text" name="ra" required/>
            <br>
            Senha: <input type="password" name="senha" required/>
            <br>
            <input type="submit" value="Login">
            
            
            
            
        </form>
     
     <p style="color:red;"><b>${msg}</b></p>
    </body>
</html>
