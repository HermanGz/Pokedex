package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPokemon extends JFrame
{
	String pokemonID;
	ImagePanel panelPokemon;
	JLabel pokemonImg;
	private final String imagePath = "resources/ventanaPokemon.png";

	
	public VentanaPokemon()
	{
		super("VentanaPokemon");
		setSize(500,700);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		panelPokemon = new ImagePanel(imagePath, 500, 700);
		
		
		add(PokemonImg());
		add(panelPokemon);
		
		
	}


	public ImagePanel getPanelPokemon() {
		return panelPokemon;
	}
	
	public JLabel PokemonImg()
	{
                
		pokemonImg = new JLabel();
		pokemonImg.setBounds(130, 20, 230, 230);
		return pokemonImg;	
	}
	
	
	public JLabel getPokemonImg() {
		return pokemonImg;
	}



	public void setPokemonID(String pokemonID) 
	{
		this.pokemonID = pokemonID;
	}
	
	
	
}
