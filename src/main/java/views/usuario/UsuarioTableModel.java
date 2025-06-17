package views.usuario;

import models.Usuario;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UsuarioTableModel
        extends AbstractTableModel {
    private List<Usuario> users;
    private final String[] colunas =
            {"ID", "Nome", "Email", "Senha",
                    "Editar", "Excluir"};

    public UsuarioTableModel(List<Usuario> usuarios) {
        this.users = usuarios;
    }

    @Override
    public int getRowCount() {
        return this.users.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = this.users.get(rowIndex);
        switch (columnIndex){
            case 0: return usuario.getId();
            case 1: return usuario.getNome();
            case 2: return usuario.getEmail();
            case 3: return usuario.getSenha();
            case 4: return "Editar";
            case 5: return "Excluir";
            default: return null;
        }
    }

    public void setUsers(List<Usuario> users) {
        this.users = users;
        fireTableDataChanged();
    }

    public Usuario getUserAt(int row) {
        return this.users.get(row);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 4 || columnIndex == 5;
    }


}
