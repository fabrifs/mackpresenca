package utils;

public class main {
	
	public static void main(String[] args) throws Exception{
		
	

	EnviaEmail eve = new EnviaEmail();
	eve.enviarEmail("Teste com quebra de linha", 
			"Boa noite\n\nEsse é o seu namorado fazendo coisas incríveis.\n\nLhe desejo uma excelente noite.\n\nAtt,\n\nEquipe MackPresença" , "bruninhagabs@outlook.com");
	
	}
}
