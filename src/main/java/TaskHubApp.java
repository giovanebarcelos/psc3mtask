import views.usuario.UsuarioListFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TaskHubApp extends JFrame {
    private static final String EMPTY_SCREEN = "EMPTY_SCREEN";
    private static final String USUARIO_SCREEN = "USUARIO_SCREEN";
    private final CardLayout cardLayout;
    private final JPanel mainPanel;

    public TaskHubApp(){
        setTitle("Task Hub Application");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Tela inicial
        JPanel emptyPanel = new JPanel(new BorderLayout());
        emptyPanel.add(new JLabel(
                "Bem-vindo! Use o Menu para navegar",
                SwingUtilities.CENTER),
                BorderLayout.CENTER);

        // Tela Usuários
        UsuarioListFrame usuariosPanel = new UsuarioListFrame();

        // Adicionar Cards no mainPanel
        mainPanel.add(emptyPanel, EMPTY_SCREEN);
        mainPanel.add(usuariosPanel, USUARIO_SCREEN);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem loginItem = new JMenuItem("Login");
        JMenuItem usuarioListItem = new JMenuItem("Listar Usuários");
        JMenuItem exitItem = new JMenuItem("Sair");

        menu.add(loginItem);
        menu.add(usuarioListItem);
        menu.add(exitItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        add(mainPanel);

        // Eventos
        loginItem.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this,
                    "Login - não foi implementado ainda");
        });

        usuarioListItem.addActionListener((ActionEvent e) -> {
            cardLayout.show(mainPanel, USUARIO_SCREEN);
        });

        exitItem.addActionListener((ActionEvent e) -> {
            dispose();
        });
    }

    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiScale", "2.0");
        SwingUtilities.invokeLater(() -> {
            new TaskHubApp().setVisible(true);
        });
    }
}
