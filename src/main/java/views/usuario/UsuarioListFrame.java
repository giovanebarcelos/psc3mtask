package views.usuario;

import models.Usuario;
import models.dao.UserDAO;
import utils.ButtonEditor;
import utils.ButtonRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Scanner;

public class UsuarioListFrame extends JPanel {
    private UsuarioTableModel tableModel;
    private JTable table;
    private JButton btnNew;
    private UserDAO userDAO = new UserDAO();

    public UsuarioListFrame(){
        initComponents();
        this.loadUsuarios();
    }

    private void loadUsuarios() {
        List<Usuario> users = userDAO.findAll();
        tableModel.setUsers(users);
    }

    private void initComponents(){
        setLayout(new BorderLayout());

        tableModel = new UsuarioTableModel(List.of());
        table = new JTable(tableModel);

        table.getColumn("Editar").setCellRenderer(new ButtonRenderer());

        table.getColumn("Excluir").setCellRenderer(new ButtonRenderer());
        //table.getColumn("Excluir").setCellEditor(
        //        new ButtonEditor( table, row -> removeUser(row)));

        JScrollPane scrollPane = new JScrollPane(table);

        btnNew = new JButton("Novo Usuário");
        btnNew.addActionListener((ActionEvent e) -> {
                JOptionPane.showMessageDialog(null,
                        "Novo Usuário não implementado");
        });

        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBtn.add(btnNew);

        add(scrollPane, BorderLayout.CENTER);
        add(panelBtn, BorderLayout.SOUTH);
    }

    private void removeUser(int row) {
        Usuario user = tableModel.getUserAt(row);

        int option = JOptionPane.showConfirmDialog(this,
                "Deseja realmente excluir o usuário " + user.getNome()+ "?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION){
            try {
                this.userDAO.delete(user);
                loadUsuarios();
            } catch (Exception e){
                JOptionPane.showMessageDialog(this,
                        "Erro ao excluir: "+ e.getMessage());
            }
        }

    }
}
