package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import vista.VentanaPokemon;

public class ControladorPokemon extends controlador implements MouseListener {

	VentanaPokemon vPokemon;
	ControladorPrincipal cPrincipal;

	public ControladorPokemon(String PokemonID) 
	{

		vPokemon = new VentanaPokemon(PokemonID);
		vPokemon.getPanelPokemon().addMouseListener(this);
	}

	public void SetcPrincipal(ControladorPrincipal cPrincipal) {
		this.cPrincipal = cPrincipal;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		double posX = e.getPoint().getX();
		double posY = e.getPoint().getY();

		if (posX > 434 && posX < 458 && posY > 26 && posY < 46) {
			System.exit(0);
		}

		if (posX > 381 && posX < 410 && posY > 32 && posY < 39) {
			vPokemon.setState(JFrame.ICONIFIED);
		}
		if (posX > 25 && posX < 57 && posY > 31 && posY < 52) {
			Notificar();
		}
	}

	@Override
	public void Notificar() 
	{
		cPrincipal.VolverVPokedex();
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
