package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author HermanG
 */
public class VentanaPokedex extends JFrame {

	public ArrayList<JButton> listaBotones = new ArrayList<JButton>();
	JButton boton = new JButton();
	ImagePanel jp;
	private final String imagePath = "resources/ventanaPokedex.jpg";

	public VentanaPokedex(int cantidadFilas, int cantidadPokemones) {
		super("Pokedex");
		setSize(550, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);

		Container contenedor = getContentPane();

		ImagePanel jp = new ImagePanel(imagePath, 540, 2000);

		jp.setLayout(new GridLayout(cantidadFilas, 5, 5, 18));
		jp.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, Color.BLACK));
		for (int i = 1; i < (cantidadPokemones + 1); i++) {

			String a = String.valueOf(i);
			JButton button = new JButton(new ImageIcon(((new ImageIcon("resources/" + a + ".PNG")).getImage())
					.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
			button.setBorder(BorderFactory.createEmptyBorder());
			button.setOpaque(false);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			button.setActionCommand(a);
			listaBotones.add(button);
			jp.add(button);
		}

		JScrollPane scroll = new JScrollPane(jp);
		scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		contenedor.add(scroll);
	}

}
