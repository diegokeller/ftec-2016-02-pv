package aula09.combo_box;

public class Animal {

	private String nome;
	private String quantidadeDePatas;

	public Animal(String nome, String quantidadeDePatas) {
		super();
		this.nome = nome;
		this.quantidadeDePatas = quantidadeDePatas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQuantidadeDePatas() {
		return quantidadeDePatas;
	}

	public void setQuantidadeDePatas(String quantidadeDePatas) {
		this.quantidadeDePatas = quantidadeDePatas;
	}

	@Override
	public String toString() {
		return nome + " (" + quantidadeDePatas + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nome == null) ? 0 : nome.hashCode());
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
		Animal other = (Animal) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	

}
