package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.BDD;
import vista.VentanaPokedex;

public final class ControladorPokedex extends controlador implements ActionListener {

    VentanaPokedex vPokedex;
    ControladorPrincipal cPrincipal;
    private String pokemon;
    BDD data;

    public ControladorPokedex() {
        data = new BDD();
        vPokedex = new VentanaPokedex(cantidadFilas(), cantidadPokemones());
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

    public int cantidadFilas()
    {
      int cantidadTmp = data.cantidadPokemones();
      int cantidadFilas;
        if (cantidadTmp%5 == 0) {
            cantidadFilas = (cantidadTmp/5);
        }
        else{
            cantidadFilas = (cantidadTmp/5) + 1 ;
        }
        return cantidadFilas;
    }
    
    public int cantidadPokemones()
    {
        int cantidadPokemones = data.cantidadPokemones();
        return cantidadPokemones;
    }
}
