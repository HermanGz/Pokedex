package vista;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame {

    ImagePanel panelRegistro;
    JTextField pseudonimoBox;
    JTextField correoBox;
    JTextField claveBox;
    JTextField claveBox2;
    private final String imgPath = "resources/ventanaRegistro.png";
    TextPrompt placeHolder;

    public VentanaRegistro() {
        super("Registro");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setUndecorated(true);

        panelRegistro = new ImagePanel(imgPath, 500, 700);
        panelRegistro.add(getNombreBox());
        panelRegistro.add(getCorreoBox());
        panelRegistro.add(getClaveBox());
        panelRegistro.add(getClaveBox2());
        add(panelRegistro);
    }

    public ImagePanel getPanelRegistro() {
        return panelRegistro;
    }

    public JTextField getNombreBox() {
        if (pseudonimoBox == null) {

            pseudonimoBox = new JTextField(32);
            pseudonimoBox.setBounds(127, 397, 230,15);
            pseudonimoBox.setBorder(BorderFactory.createEmptyBorder());
            placeHolder = new TextPrompt("Pseudonimo", pseudonimoBox);
            placeHolder.changeAlpha(0.75f);
            placeHolder.changeStyle(Font.ITALIC);
        }
        return pseudonimoBox;
    }
    
    public JTextField getCorreoBox() {
        if (correoBox == null) {

            correoBox = new JTextField(32);
            correoBox.setBounds(125, 455, 230,15);
            correoBox.setBorder(BorderFactory.createEmptyBorder());
            placeHolder = new TextPrompt("Correo Electronico", correoBox);
            placeHolder.changeAlpha(0.75f);
            placeHolder.changeStyle(Font.ITALIC);
        }
        return correoBox;
    }
    
    public JTextField getClaveBox() {
        if (claveBox == null) {

            claveBox = new JTextField(32);
            claveBox.setBounds(125, 514, 230,15);
            claveBox.setBorder(BorderFactory.createEmptyBorder());
            placeHolder = new TextPrompt("Ingresar Clave", claveBox);
            placeHolder.changeAlpha(0.75f);
            placeHolder.changeStyle(Font.ITALIC);
        }
        return claveBox;
    }
    
    public JTextField getClaveBox2() {
        if (claveBox2 == null) {

            claveBox2 = new JTextField(32);
            claveBox2.setBounds(125, 573, 230,15);
            claveBox2.setBorder(BorderFactory.createEmptyBorder());
            placeHolder = new TextPrompt("Ingresar Clave Nuevamente", claveBox2);
            placeHolder.changeAlpha(0.75f);
            placeHolder.changeStyle(Font.ITALIC);
        }
        return claveBox2;
    }
    
    
    
    
}
