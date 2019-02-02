package controlador;


import vista.VentanaLogin;
import vista.VentanaPokedex;
import vista.VentanaPokemon;


public final class ControladorPrincipal {

    ControladorLogin cLogin;
    ControladorPokedex cPokedex;
    VentanaLogin vLogin;
    VentanaPokedex vPokedex;
    VentanaPokemon vPokemon;
    ControladorPokemon cPokemon;

    public void IniciarComponentes() {
        cLogin = new ControladorLogin();
        cPokedex = new ControladorPokedex();
        cLogin.SetcPrincipal(this);
        cPokedex.SetcPrincipal(this);
        vLogin = cLogin.vLogin;
        vPokedex = cPokedex.vPokedex;
    }

    public void ValidarLogin() {
        if (cLogin.isLogSuccessfull()) {
            vPokedex.setVisible(true);
            vLogin.dispose();
        }
    }

    public void MostrarPokemon() {
        String pokemon = cPokedex.getPokemon();

        cPokemon = new ControladorPokemon(pokemon);
        cPokemon.SetcPrincipal(this);
        vPokemon = cPokemon.vPokemon;

        vPokedex.setVisible(false);
        vPokemon.setVisible(true);
        System.out.println(pokemon);
    }

    public void VolverPokedex() {

        vPokedex.setVisible(true);
        vPokemon.setVisible(false);
        vPokemon.dispose();
    }
}
