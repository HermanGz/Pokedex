package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaPokemon extends JFrame {

    String pokemonID;
    ImagePanel panelPokemon;
    JLabel pokemonImg;
    JLabel pokemonNombre;
    JLabel pokemonNumero;
    JLabel pokemonPeso;
    JLabel pokemonAltura;
    JLabel pokemonTipo;
    JLabel pokemonAttack;
    JLabel pokemonDefense;

    private final String imagePath = "resources/ventanaPokemon.png";

    public VentanaPokemon() {
        super("VentanaPokemon");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setUndecorated(true);

        panelPokemon = new ImagePanel(imagePath, 500, 700);

        add(PokemonImg());
        add(pokemonNombre());
        add(pokemonNumero());
        add(pokemonPeso());
        add(pokemonAltura());
        add(pokemonTipo());
        add(pokemonAttack());
        add(pokemonDefense());
        add(panelPokemon);

    }

    public JLabel PokemonImg() {
        if (pokemonImg == null) {
            pokemonImg = new JLabel();
        pokemonImg.setBounds(130, 8, 230, 230);
        }
        return pokemonImg;
    }

    public JLabel pokemonNombre() {
        if (pokemonNombre == null) {
            pokemonNombre = new JLabel("", SwingConstants.CENTER);
        pokemonNombre.setBounds(180, 140, 300, 200);
        pokemonNombre.setFont(new Font("Monospaced", 1, 50));
        pokemonNombre.setForeground(Color.BLACK);
        }
        
        return pokemonNombre;
    }

    public JLabel pokemonNumero() {
        if (pokemonNumero == null) {
           pokemonNumero = new JLabel(pokemonID, SwingConstants.CENTER);
        pokemonNumero.setBounds(80, 140, 100, 200);
        pokemonNumero.setFont(new Font("Monospaced", 1, 50));
        pokemonNumero.setForeground(Color.BLACK); 
        }
        
        return pokemonNumero;
    }

    public JLabel pokemonPeso() {
        if (pokemonPeso == null) {
            pokemonPeso = new JLabel("", SwingConstants.CENTER);
        pokemonPeso.setBounds(95, 298, 50, 50);
        pokemonPeso.setFont(new Font("Monospaced", 1, 25));
        pokemonPeso.setForeground(Color.BLACK);
        }
        
        return pokemonPeso;
    }

    public JLabel pokemonAltura() {
        if (pokemonAltura == null) {
            pokemonAltura = new JLabel("", SwingConstants.CENTER);
        pokemonAltura.setBounds(225, 298, 50, 50);
        pokemonAltura.setFont(new Font("Monospaced", 1, 25));
        pokemonAltura.setForeground(Color.BLACK);
        }
        
        return pokemonAltura;
    }

    public JLabel pokemonTipo() {
        if (pokemonTipo == null) {
            pokemonTipo = new JLabel("", SwingConstants.CENTER);
        pokemonTipo.setBounds(335, 298, 150, 50);
        pokemonTipo.setFont(new Font("Monospaced", 1, 16));
        pokemonTipo.setForeground(Color.BLACK);
        }
        
        return pokemonTipo;
    }

    public JLabel pokemonAttack() {

        pokemonAttack = new JLabel("", SwingConstants.CENTER);
        pokemonAttack.setBounds(120, 400, 150, 50);
        pokemonAttack.setFont(new Font("Monospaced", 1, 25));
        pokemonAttack.setForeground(Color.BLACK);
        return pokemonAttack;
    }

    public JLabel pokemonDefense() {
        if (pokemonDefense == null ) {
            pokemonDefense = new JLabel("", SwingConstants.CENTER);
        pokemonDefense.setBounds(290, 400, 150, 50);
        pokemonDefense.setFont(new Font("Monospaced", 1, 25));
        pokemonDefense.setForeground(Color.BLACK); 
        }
       
        return pokemonDefense;
    }

    public void setPokemonID(String pokemonID) {
        this.pokemonID = pokemonID;
    }

    public ImagePanel getPanelPokemon() {
        return panelPokemon;
    }

}
