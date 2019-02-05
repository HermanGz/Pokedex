package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaPokedex;

public final class ControladorPokedex extends controlador implements ActionListener {

	VentanaPokedex vPokedex;
	ControladorPrincipal cPrincipal;
	private String pokemon;

	public ControladorPokedex() {
		vPokedex = new VentanaPokedex();
		setListener();

	}

	void setListener() {
		for (int i = 0; i < vPokedex.listaBotones.size(); i++) {
			vPokedex.listaBotones.get(i).addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pokemon = e.getActionCommand();
		Notificar();
	}

	@Override
	public void Notificar() {
		cPrincipal.MostrarPokemon();
	}

	public void SetcPrincipal(ControladorPrincipal cPrincipal) {
		this.cPrincipal = cPrincipal;
	}

	public String getPokemon() {
		return pokemon;
	}

}
