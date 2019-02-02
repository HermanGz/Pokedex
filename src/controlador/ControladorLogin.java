package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.BDD;

import vista.VentanaLogin;

public final class ControladorLogin extends controlador implements KeyListener, MouseListener {

    private boolean logSuccessfull;

    VentanaLogin vLogin;
    ControladorPrincipal cPrincipal;
    BDD data;

    public ControladorLogin() {
        vLogin = new VentanaLogin();
        vLogin.setVisible(true);
        vLogin.GetBoxPassword().addKeyListener(this);
        vLogin.GetBoxUsername().addKeyListener(this);
        vLogin.getpBackground().addMouseListener(this);
        data = new BDD();
    }

    public void SetcPrincipal(ControladorPrincipal cPrincipal) {
        this.cPrincipal = cPrincipal;
    }

    public boolean isLogSuccessfull() {
        return logSuccessfull;
    }

    @Override
    public void Notificar() {
        if (cPrincipal != null) {
            cPrincipal.ValidarLogin();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        boolean isEnter = e.getKeyCode() == KeyEvent.VK_ENTER;

        if (isEnter) {
            char[] password = vLogin.GetBoxPassword().getPassword();
            String username = vLogin.GetBoxUsername().getText();

            data.getCredenciales(username);

            if (username == null || username.trim().isEmpty() || password == null || password.length <= 3
                    || username.trim().length() <= 3) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un usuario y contraseña valido", "Error de Login",
                        JOptionPane.ERROR_MESSAGE);
            } else if (data.getUsername() == null) {
                JOptionPane.showMessageDialog(null, "El usuario ingresado no existe", "Error de Login",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!username.equals(data.getUsername()) || !String.valueOf(password).equals(data.getClave())) {
                JOptionPane.showMessageDialog(null, "Usuario y/o contrasena no coinciden", "Error de Login",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                logSuccessfull = true;
                Notificar();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        double posX = e.getPoint().getX();
        double posY = e.getPoint().getY();

        if (posX > 455 && posX < 470 && posY > 27 && posY < 42) {
            System.exit(0);
        }

        if (posX > 401 && posX < 431 && posY > 31 && posY < 37) {
            vLogin.setState(JFrame.ICONIFIED);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
