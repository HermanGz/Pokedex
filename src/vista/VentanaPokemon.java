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

        add(pokemonImg());
        add(pokemonNombre());
        add(pokemonNumero());
        add(pokemonPeso());
        add(pokemonAltura());
        add(pokemonTipo());
        add(pokemonAttack());
        add(pokemonDefense());
        add(panelPokemon);

    }

    public JLabel pokemonImg() {
        if (pokemonImg == null) {
            pokemonImg = new JLabel();
            pokemonImg.setBounds(130, 8, 230, 230);
        }
        return pokemonImg;
    }

    public JLabel pokemonNombre() {
        if (pokemonNombre == null) {
            pokemonNombre = new JLabel("", SwingConstants.CENTER);
            pokemonNombre.setBounds(190, 165, 300, 200);
            pokemonNombre.setFont(new Font("Monospaced", 1, 50));
            pokemonNombre.setForeground(Color.BLACK);
        }

        return pokemonNombre;
    }

    public JLabel pokemonNumero() {
        if (pokemonNumero == null) {
            pokemonNumero = new JLabel(pokemonID, SwingConstants.CENTER);
            pokemonNumero.setBounds(85, 165, 100, 200);
            pokemonNumero.setFont(new Font("Monospaced", 1, 50));
            pokemonNumero.setForeground(Color.BLACK);
        }

        return pokemonNumero;
    }

    public JLabel pokemonPeso() {
        if (pokemonPeso == null) {
            pokemonPeso = new JLabel("", SwingConstants.CENTER);
            pokemonPeso.setBounds(140, 410, 100, 100);
            pokemonPeso.setFont(new Font("Monospaced", 1, 40));
            pokemonPeso.setForeground(Color.BLACK);
        }

        return pokemonPeso;
    }

    public JLabel pokemonAltura() {
        if (pokemonAltura == null) {
            pokemonAltura = new JLabel("", SwingConstants.CENTER);
            pokemonAltura.setBounds(350, 410, 100, 100);
            pokemonAltura.setFont(new Font("Monospaced", 1, 40));
            pokemonAltura.setForeground(Color.BLACK);
        }

        return pokemonAltura;
    }

    public JLabel pokemonTipo() {
        if (pokemonTipo == null) {
            pokemonTipo = new JLabel("", SwingConstants.CENTER);
            pokemonTipo.setBounds(80, 298, 350, 50);
            pokemonTipo.setFont(new Font("Monospaced", 1, 40));
            pokemonTipo.setForeground(Color.BLACK);
        }

        return pokemonTipo;
    }

    public JLabel pokemonAttack() {
        if (pokemonAttack == null) {
            pokemonAttack = new JLabel("", SwingConstants.CENTER);
            pokemonAttack.setBounds(110, 530, 150, 50);
            pokemonAttack.setFont(new Font("Monospaced", 1, 40));
            pokemonAttack.setForeground(Color.BLACK);
        }
        return pokemonAttack;
    }

    public JLabel pokemonDefense() {
        if (pokemonDefense == null) {
            pokemonDefense = new JLabel("", SwingConstants.CENTER);
            pokemonDefense.setBounds(320, 530, 150, 50);
            pokemonDefense.setFont(new Font("Monospaced", 1, 40));
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
