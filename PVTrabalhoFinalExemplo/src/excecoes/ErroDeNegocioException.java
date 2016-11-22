package excecoes;

public class ErroDeNegocioException extends Exception {

	private static final long serialVersionUID = 1L;

	public ErroDeNegocioException(String message) {
		super(message);
	}

	public ErroDeNegocioException(String message, Throwable cause) {
		super(message, cause);
	}

}
