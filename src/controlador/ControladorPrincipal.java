package controlador;

import vista.VentanaLogin;
import vista.VentanaPokedex;
import vista.VentanaPokemon;
import vista.VentanaRegistro;

public final class ControladorPrincipal {

    ControladorLogin cLogin;
    ControladorPokedex cPokedex;
    ControladorPokemon cPokemon;
    ControladorRegistro cRegistro;
    VentanaLogin vLogin;
    VentanaPokedex vPokedex;
    VentanaPokemon vPokemon;
    VentanaRegistro vRegistro;

    public void iniciarComponentes() {
        cLogin = new ControladorLogin();
        cPokedex = new ControladorPokedex();
        cPokemon = new ControladorPokemon();
        cRegistro = new ControladorRegistro();

        cPokemon.setCPrincipal(this);
        cLogin.setCPrincipal(this);
        cPokedex.setCPrincipal(this);
        cRegistro.setCPrincipal(this);

        vLogin = cLogin.vLogin;
        vPokedex = cPokedex.vPokedex;
        vPokemon = cPokemon.vPokemon;
        vRegistro = cRegistro.vRegistro;

    }

    public void validarLogin() {
        if (cLogin.isLogSuccessfull()) {
            vPokedex.setVisible(true);
            vLogin.dispose();
        }
    }

    public void mostrarPokemon() {

        String pokemonID = cPokedex.getPokemon();

        cPokemon.setPokemon(pokemonID);

        vPokedex.setVisible(false);
        vPokemon.setVisible(true);
        System.out.println(pokemonID);
    }

    public void volverPokedex() {

        vPokedex.setVisible(true);
        vPokemon.setVisible(false);
        vPokemon.dispose();
    }

    public void ventanaRegistro() {
        vRegistro.setVisible(true);
        vLogin.setVisible(false);
    }

    public void volverLogin() {
        vRegistro.setVisible(false);
        vLogin.setVisible(true);
    }
}
