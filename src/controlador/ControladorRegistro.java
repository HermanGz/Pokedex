package controlador;

import com.sun.org.apache.xpath.internal.compiler.PsuedoNames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.BDD;
import vista.VentanaRegistro;

public class ControladorRegistro extends controlador implements MouseListener, ActionListener {

    VentanaRegistro vRegistro;
    ControladorPrincipal cPrincipal;
    BDD data;
    String pseudonimo;
    String correo;
    String clave;
    String clave2;
    boolean registroSuccess;

    public ControladorRegistro() {
        data = new BDD();

    }

    public void iniciarVRegistro() {
        vRegistro = new VentanaRegistro();
        vRegistro.getPanelRegistro().addMouseListener(this);
    }

    public void setCPrincipal(ControladorPrincipal cPrincipal) {
        this.cPrincipal = cPrincipal;
    }

    public boolean getRegistroSuccess() {
        return registroSuccess;
    }

    public void registrarUsuario() {

        pseudonimo = vRegistro.getPseudonimoBox().getText();
        correo = vRegistro.getCorreoBox().getText();
        clave = String.valueOf(vRegistro.getClaveBox().getPassword());
        clave2 = String.valueOf(vRegistro.getClaveBox2().getPassword());

        if (pseudonimo == null || pseudonimo.equals("")) {
            JOptionPane.showMessageDialog(null, "Pseudonimo no puede estar vacio", null, 0);
        } else if (correo == null || correo.equals("")) {
            JOptionPane.showMessageDialog(null, "Correo no puede estar vacio", null, 0);
        } else if (clave == null || clave2 == null || clave.equals("") || clave2.equals("")) {
            JOptionPane.showMessageDialog(null, "Clave no puede estar vacia", null, 0);
        } else if (!clave.equals(clave2)) {
            JOptionPane.showMessageDialog(null, "Claves ingresadas no sin iguales", null, 0);
        } else if (clave.equals(clave2) && pseudonimo != null && correo != null) {
            data.registrarUsuario(pseudonimo, correo, clave);
            notificar("ValidarRegistro");
        }

    }

    @Override
    public void notificar(String origen) {
        if (origen.equals("VolverLogin")) {
            cPrincipal.volverLogin();
        }

        if (origen.equals("ValidarRegistro")) {
            registroSuccess = data.getRegistroSuccess();
            cPrincipal.validarRegistro();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        double posX = e.getPoint().getX();
        double posY = e.getPoint().getY();

        if (posX > 14 && posX < 58 && posY > 21 && posY < 50) {
            notificar("VolverLogin");
        }

        if (posX > 221 && posX < 274 && posY > 625 && posY < 677) {
            registrarUsuario();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
