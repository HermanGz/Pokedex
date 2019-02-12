package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public final class VentanaLogin extends JFrame {

    private JTextField boxUsername;
    private JPasswordField boxPassword;
    private JLabel linkRegistro;
    private final ImagePanel pBackground;
    private final String imagePath = "resources/ventanaLogin.png";

    public VentanaLogin() {
        super("Login");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setUndecorated(true);

        pBackground = new ImagePanel(imagePath, 500, 700);
        add(pBackground);

        pBackground.add(getLinkRegistro());
        pBackground.add(getBoxUsername());
        pBackground.add(getBoxPassword());

    }

    public JTextField getBoxUsername() {
        if (boxUsername == null) {
            boxUsername = new JTextField();
            boxUsername.setBounds(175, 541, 150, 18);
            boxUsername.setFont(new Font("Helvetica", Font.BOLD, 13));
            boxUsername.setBorder(BorderFactory.createEmptyBorder());
        }
        return boxUsername;
    }

    public JPasswordField getBoxPassword() {
        if (boxPassword == null) {
            boxPassword = new JPasswordField();
            boxPassword.setBounds(175, 615, 150, 18);
            boxPassword.setBorder(BorderFactory.createEmptyBorder());
        }
        return boxPassword;
    }

    public JLabel getLinkRegistro() {
        if (linkRegistro == null) {
            linkRegistro = new JLabel("!Registrate Aqui¡");
            linkRegistro.setName("!Registrate Aqui¡");
            linkRegistro.setBounds(185, 650, 150, 20);
            linkRegistro.setBorder(BorderFactory.createEmptyBorder());
            linkRegistro.setFont(new Font("Monospaced", 1, 13));
            linkRegistro.setForeground(Color.WHITE);
        }
        return linkRegistro;
    }

    public ImagePanel getpBackground() {
        return pBackground;
    }
}
