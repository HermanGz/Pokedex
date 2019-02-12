package controlador;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.BDD;
import vista.VentanaRegistro;

public class ControladorRegistro extends controlador implements MouseListener {

    VentanaRegistro vRegistro;
    ControladorPrincipal cPrincipal;
    BDD data;

    public ControladorRegistro() {
        data = new BDD();
        vRegistro = new VentanaRegistro();

        vRegistro.getPanelRegistro().addMouseListener(this);
    }

    public void setCPrincipal(ControladorPrincipal cPrincipal) {
        this.cPrincipal = cPrincipal;
    }

    @Override
    public void notificar(String origen) {
        if (origen.equals("VolverLogin")) {
            cPrincipal.volverLogin();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        double posX = e.getPoint().getX();
        double posY = e.getPoint().getY();

        if (posX > 14 && posX < 58 && posY > 21 && posY < 50) {
            notificar("VolverLogin");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
