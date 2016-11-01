package com.uniftec.pv.loja.negocio;

import java.util.Date;

public class Validacoes {

	public static void obrigatorio(String campo, String nomeCampo)
			throws BusinessException {
		if (campo == null || campo.trim().isEmpty()) {
			throw new BusinessException(nomeCampo + " é obrigatório.");
		}
	}

	public static void obrigatorio(Date campo, String nomeCampo)
			throws BusinessException {
		if (campo == null) {
			throw new BusinessException(nomeCampo + " é obrigatório.");
		}
	}

	public static void obrigatorio(Boolean campo, String nomeCampo)
			throws BusinessException {
		if (campo == null) {
			throw new BusinessException(nomeCampo + " é obrigatório.");
		}
	}

	public static void obrigatorio(Integer campo, String nomeCampo)
			throws BusinessException {
		if (campo == null) {
			throw new BusinessException(nomeCampo + " é obrigatório.");
		}
	}

	public static void maiorQue(Integer campo, Integer maior,
			String nomeCampo) throws BusinessException {
		if (campo < maior) {
			throw new BusinessException(
					nomeCampo + " deve ser maior que " + maior);
		}
	}

}
