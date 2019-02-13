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

}
