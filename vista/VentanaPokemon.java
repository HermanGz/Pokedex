package vista;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPokemon extends JFrame
{
	String pokemonID;
	ImagePanel panelPokemon;
	JLabel pokemonImg;
	private final String imagePath = "resources/ventanaPokemon.png";

	
	public VentanaPokemon(String PokemonID)
	{
		super("VentanaPokemon");
		setSize(500,700);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		panelPokemon = new ImagePanel(imagePath, 500, 700);
		
		
		add(getPokemonImg(PokemonID));
		add(panelPokemon);
		
		
	}


	public ImagePanel getPanelPokemon() {
		return panelPokemon;
	}
	
	public JLabel getPokemonImg(String pokemonID)
	{
		pokemonImg = new JLabel(new ImageIcon(new ImageIcon("resources/"+ pokemonID + ".png").getImage().getScaledInstance(230, 230, java.awt.Image.SCALE_SMOOTH)));
		pokemonImg.setBounds(130, 20, 230, 230);
		return pokemonImg;	
		
	}


	public void setPokemonID(String pokemonID) 
	{
		this.pokemonID = pokemonID;
	}
	
	
	
}
