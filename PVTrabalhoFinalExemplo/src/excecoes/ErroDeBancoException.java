package excecoes;

/**
 * Representa qualquer erro de banco de dados.
 * 
 * @author Diego
 *
 */
public class ErroDeBancoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ErroDeBancoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
