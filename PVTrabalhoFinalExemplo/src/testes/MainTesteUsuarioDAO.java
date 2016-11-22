package testes;

import modelo.Usuario;
import persistencia.DAOFactory;
import persistencia.UsuarioDAO;
import excecoes.ErroDeBancoException;

public class MainTesteUsuarioDAO {

	public static void main(String[] args) {

		try {

			// Pega o DAO
			UsuarioDAO dao = DAOFactory.getDAOFactory().getUsuarioDAO();

			// Isere
			System.out.println("Inserindo um usuário");
			Usuario usuario = new Usuario(null, "João", "joao", "joao@email.com", "123", "Administrador", true);
			dao.inserir(usuario);
			System.out.println("OK");
			
			Usuario usuario2 = dao.buscarPorId(1);
			System.out.println(usuario2);

			System.out.println("FIM");

		} catch (ErroDeBancoException erro) {
			erro.printStackTrace();
		}

	}

}
