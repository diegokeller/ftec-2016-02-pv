package aula06.email;

import javax.mail.MessagingException;

public class MainTesteEmail {

	public static void main(String[] args) {
		try {
			EnvioEmail.enviarEmail("keller.diego@gmail.com", "TESTE",
					"MENSAGEM");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
