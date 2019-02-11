package vista;

import javax.swing.JFrame;

public class ventanaRegistro extends JFrame {

	ImagePanel panelRegistro;
	private final String imgPath = "resources/ventanaRegistro.png";

	public ventanaRegistro() {
		super("Registro");
		setSize(500, 700);
		setLocationRelativeTo(null);
		setUndecorated(true);

		panelRegistro = new ImagePanel(imgPath, 500, 700);

		add(panelRegistro);

	}

}
