package com.uniftec.pv.loja.modelo;

/**
 * Modelo de produto.
 */
public class Produto {

	private Integer id;
	private String nome;
	private String descricao;
	private Double preco;
	private Integer quantidadeEmEstoque;
	private Boolean ativo;

	public Produto(Integer id, String nome, String descricao,
			Double preco, Integer quantidadeEmEstoque, Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.ativo = ativo;
	}
	
	public boolean temEmEstoque(){
		return quantidadeEmEstoque > 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(
			Integer quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((quantidadeEmEstoque == null) ? 0
				: quantidadeEmEstoque.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (quantidadeEmEstoque == null) {
			if (other.quantidadeEmEstoque != null)
				return false;
		} else if (!quantidadeEmEstoque
				.equals(other.quantidadeEmEstoque))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome
				+ ", descricao=" + descricao + ", preco=" + preco
				+ ", quantidadeEmEstoque=" + quantidadeEmEstoque
				+ ", ativo=" + ativo + "]";
	}

}
