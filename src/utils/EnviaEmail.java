package utils;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class EnviaEmail {
	
	Email email;
	
	public EnviaEmail(){
		this.email = new SimpleEmail();
		this.email.setHostName("smtp.googlemail.com");
		this.email.setSmtpPort(465);
		this.email.setAuthentication("mackpresenca@gmail.com", "mack1234");
		this.email.setSSLOnConnect(true);		
	}

	public void enviarEmail(String assunto, String msg, String destinatario) throws Exception{		 
		this.email.setFrom("mackpresenca@gmail.com");
		this.email.setSubject(assunto);
		this.email.setMsg(msg);
		this.email.addTo(destinatario);
		this.email.send();
	}

}
