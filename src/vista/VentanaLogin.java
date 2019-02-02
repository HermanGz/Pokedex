package vista;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public final class VentanaLogin extends JFrame {

    private JTextField boxUsername;
    private JPasswordField boxPassword;
    private final ImagePanel pBackground;
    private final String imagePath = "resources/ventanaLogin.png";

    public VentanaLogin() {
        super("Login");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setUndecorated(true);

        pBackground = new ImagePanel(imagePath, 500, 700);
        add(pBackground);

        pBackground.add(GetBoxUsername());
        pBackground.add(GetBoxPassword());
    }

    public JTextField GetBoxUsername() {
        if (boxUsername == null) {
            boxUsername = new JTextField();
            boxUsername.setBounds(175, 541, 150, 18);
            boxUsername.setFont(new Font("Helvetica", Font.BOLD, 13));
            boxUsername.setBorder(BorderFactory.createEmptyBorder());
        }
        return boxUsername;
    }

    public JPasswordField GetBoxPassword() {
        if (boxPassword == null) {
            boxPassword = new JPasswordField();
            boxPassword.setBounds(175, 615, 150, 18);
            boxPassword.setBorder(BorderFactory.createEmptyBorder());
        }
        return boxPassword;
    }

    public ImagePanel getpBackground() {
        return pBackground;
    }
}
