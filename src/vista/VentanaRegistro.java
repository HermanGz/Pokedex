package vista;

import javax.swing.JFrame;

public class VentanaRegistro extends JFrame {

	ImagePanel panelRegistro;
	private final String imgPath = "resources/ventanaRegistro.png";

	public VentanaRegistro() {
		super("Registro");
		setSize(500, 700);
		setLocationRelativeTo(null);
		setUndecorated(true);

		panelRegistro = new ImagePanel(imgPath, 500, 700);

		add(panelRegistro);

	}

<<<<<<< HEAD
            pseudonimoBox = new JTextField(32);
            pseudonimoBox.setBounds(127, 397, 230, 15);
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
            correoBox.setBounds(125, 455, 230, 15);
            correoBox.setBorder(BorderFactory.createEmptyBorder());
            placeHolder = new TextPrompt("Correo Electronico", correoBox);
            placeHolder.changeAlpha(0.75f);
            placeHolder.changeStyle(Font.ITALIC);
        }
        return correoBox;
    }

    public JPasswordField getClaveBox() {
        if (claveBox == null) {

            claveBox = new JPasswordField();
            claveBox.setBounds(125, 514, 230, 15);
            claveBox.setBorder(BorderFactory.createEmptyBorder());
            placeHolder = new TextPrompt("Ingresar Clave", claveBox);
            placeHolder.changeAlpha(0.75f);
            placeHolder.changeStyle(Font.ITALIC);
        }
        return claveBox;
    }

    public JPasswordField getClaveBox2() {
        if (claveBox2 == null) {

            claveBox2 = new JPasswordField();
            claveBox2.setBounds(125, 573, 230, 15);
            claveBox2.setBorder(BorderFactory.createEmptyBorder());
            placeHolder = new TextPrompt("Ingresar Clave Nuevamente", claveBox2);
            placeHolder.changeAlpha(0.75f);
            placeHolder.changeStyle(Font.ITALIC);
        }
        return claveBox2;
    }

=======
>>>>>>> 43e70796bb54786081eeac0c7ec2a509beea8850
}
