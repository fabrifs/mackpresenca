package utils;

public class main {
	
	public static void main(String[] args) throws Exception{
		
	

	EnviaEmail eve = new EnviaEmail();
	eve.enviarEmail("Teste com quebra de linha", 
			"Boa noite\n\nEsse � o seu namorado fazendo coisas incr�veis.\n\nLhe desejo uma excelente noite.\n\nAtt,\n\nEquipe MackPresen�a" , "bruninhagabs@outlook.com");
	
	}
}
