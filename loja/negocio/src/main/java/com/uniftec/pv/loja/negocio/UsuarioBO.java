package com.uniftec.pv.loja.negocio;

import java.security.NoSuchAlgorithmException;

import com.uniftec.pv.loja.modelo.Usuario;
import com.uniftec.pv.loja.persistencia.DAOFactory;
import com.uniftec.pv.loja.persistencia.PersistenceException;

public class UsuarioBO {

	/**
	 * Faz as seguintes validações:
	 * <ul>
	 * <li>Usuário existe
	 * <li>Se a senha está correta
	 * <li>Se o usuário está ativo
	 * </ul>
	 * 
	 * @param login
	 *          Login do usuário que quer entrar no sistema.
	 * @param senha
	 *          Senha do usuário.
	 * @throws BusinessException
	 */
	public void login(String login, String senha)
			throws BusinessException {

		Validacoes.obrigatorio(login, "Login");
		Validacoes.obrigatorio(senha, "Senha");

		// Busca usuário por login
		try {
			Usuario usuario = DAOFactory.getDAOFactory()
					.getUsuarioDAO().buscarPorLogin(login);

			// Achou o usuário?
			if (usuario == null) {
				throw new BusinessException("Usuário com login " + login
						+ " não foi encontrado.");
			}

			// Está ativo
			if (!usuario.getAtivo()) {
				throw new BusinessException("Seu usuário está inativo");
			}

			// Criptografa a senha
			String senhaCriptografada = Criptografia.sha1(senha);

			// Testa se a senha está certa
			if (!senhaCriptografada.equals(usuario.getSenha())) {
				throw new BusinessException(
						"A senha informada está incorreta.");
			}

		} catch (PersistenceException e) {
			throw new BusinessException("Erro ao buscar o usuário", e);
		} catch (NoSuchAlgorithmException e) {
			throw new BusinessException("Erro ao criptografar a senha",
					e);
		}
	}

}
