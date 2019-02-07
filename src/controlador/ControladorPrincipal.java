package controlador;

import vista.VentanaLogin;
import vista.VentanaPokedex;
import vista.VentanaPokemon;

public final class ControladorPrincipal {

    ControladorLogin cLogin;
    ControladorPokedex cPokedex;
    ControladorPokemon cPokemon;
    VentanaLogin vLogin;
    VentanaPokedex vPokedex;
    VentanaPokemon vPokemon;

    public void IniciarComponentes() {
        cLogin = new ControladorLogin();
        cPokedex = new ControladorPokedex();
        cPokemon = new ControladorPokemon();

        cPokemon.SetcPrincipal(this);
        cLogin.SetcPrincipal(this);
        cPokedex.SetcPrincipal(this);

        vLogin = cLogin.vLogin;
        vPokedex = cPokedex.vPokedex;
        vPokemon = cPokemon.vPokemon;
    }

    public void ValidarLogin() {
        if (cLogin.isLogSuccessfull()) {
            vPokedex.setVisible(true);
            vLogin.dispose();
        }
    }

    public void MostrarPokemon() {

        String pokemonID = cPokedex.getPokemon();

        cPokemon.setPokemon(pokemonID);

        vPokedex.setVisible(false);
        vPokemon.setVisible(true);
        System.out.println(pokemonID);
    }

    public void VolverPokedex() {

        vPokedex.setVisible(true);
        vPokemon.setVisible(false);
        vPokemon.dispose();
    }
}
