package tabelas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UsuarioTableModel extends AbstractTableModel {

	private List<Usuario> dados;
	
	private String[] colunas = new String[]{"Nome", "Ativo", "Data de Nascimento"};
	
	public UsuarioTableModel(List<Usuario> dados) {
		super();
		this.dados = dados;
	}

	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario u = dados.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return u.getNome();
			case 1:
				return u.getAtivo();
			case 2:
				return u.getNascimento();

			default:
				return "";
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

}
