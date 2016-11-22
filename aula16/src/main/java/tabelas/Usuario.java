package tabelas;

import java.util.Date;

public class Usuario {

	private String nome;
	private Boolean ativo;
	private Date nascimento;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", ativo=" + ativo + ", nascimento=" + nascimento + "]";
	}
	public Usuario(String nome, Boolean ativo, Date nascimento) {
		super();
		this.nome = nome;
		this.ativo = ativo;
		this.nascimento = nascimento;
	}
	
	
	
}
