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
    TextPrompt placeHolder;
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
            boxUsername.setBounds(185, 510, 150, 17);
            boxUsername.setBorder(BorderFactory.createEmptyBorder());
            placeHolder = new TextPrompt("Pseudonimo", boxUsername);
            placeHolder.changeAlpha(0.75f);
            placeHolder.changeStyle(Font.ITALIC);
            
            
        }
        return boxUsername;
    }

    public JPasswordField getBoxPassword() {
        if (boxPassword == null) {
            boxPassword = new JPasswordField();
            boxPassword.setBounds(185, 585, 150, 17);
            boxPassword.setBorder(BorderFactory.createEmptyBorder());
            placeHolder = new TextPrompt("Password", boxPassword);
            placeHolder.changeAlpha(0.75f);
            placeHolder.changeStyle(Font.ITALIC);
            
        }
        return boxPassword;
    }

    public JLabel getLinkRegistro() {
        if (linkRegistro == null) {
            linkRegistro = new JLabel("!Registrate Aqui¡");
            linkRegistro.setName("!Registrate AquiÂ¡");
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
