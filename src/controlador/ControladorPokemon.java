package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import modelo.BDD;
import vista.VentanaPokemon;

public class ControladorPokemon extends controlador implements MouseListener {

	VentanaPokemon vPokemon;
	ControladorPrincipal cPrincipal;
	BDD data;

	public ControladorPokemon() {

		vPokemon = new VentanaPokemon();
		vPokemon.getPanelPokemon().addMouseListener(this);
		data = new BDD();
	}

	public void setCPrincipal(ControladorPrincipal cPrincipal) {
		this.cPrincipal = cPrincipal;
	}

	public void setPokemon(String pokemonID) {
		data.getPokemonInfo(pokemonID);

		vPokemon.pokemonImg().setIcon(new ImageIcon(new ImageIcon("resources/" + pokemonID + ".png").getImage()
				.getScaledInstance(230, 230, java.awt.Image.SCALE_SMOOTH)));

		vPokemon.pokemonNombre().setText(data.getpNombre());

		vPokemon.pokemonNumero().setText(pokemonID);

		vPokemon.pokemonPeso().setText(data.getpPeso());

		vPokemon.pokemonAltura().setText(data.getpAltura());

		vPokemon.pokemonTipo().setText(data.getpTipo());

		vPokemon.pokemonAttack().setText(data.getpAttack());

		vPokemon.pokemonDefense().setText(data.getpDefense());

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		double posX = e.getPoint().getX();
		double posY = e.getPoint().getY();

		if (posX > 450 && posX < 478 && posY > 24 && posY < 45) {
			System.exit(0);
		}

		if (posX > 383 && posX < 432 && posY > 29 && posY < 40) {
			vPokemon.setState(JFrame.ICONIFIED);
		}
		if (posX > 32 && posX < 76 && posY > 26 && posY < 45) {
			notificar();
		}
	}

	@Override
	public void notificar() {
		cPrincipal.volverPokedex();
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
