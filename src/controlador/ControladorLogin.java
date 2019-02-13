package controlador;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        vLogin.getBoxPassword().addKeyListener(this);
        vLogin.getBoxUsername().addKeyListener(this);
        vLogin.getpBackground().addMouseListener(this);
        vLogin.getLinkRegistro().addMouseListener(this);
        data = new BDD();
    }

    public void setCPrincipal(ControladorPrincipal cPrincipal) {
        this.cPrincipal = cPrincipal;
    }

    public boolean isLogSuccessfull() {
        return logSuccessfull;
    }

    @Override
    public void notificar(String origen) {
        if (origen.equals("Login")) {
            
            cPrincipal.validarLogin();
        }
        
        if (origen.equals("Registro")) {
            cPrincipal.ventanaRegistro();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        boolean isEnter = e.getKeyCode() == KeyEvent.VK_ENTER;

        if (isEnter) {
            char[] password = vLogin.getBoxPassword().getPassword();
            String username = vLogin.getBoxUsername().getText();

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
                notificar("Login");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        double posX = e.getPoint().getX();
        double posY = e.getPoint().getY();
        String comando = null;

        if (posX > 455 && posX < 470 && posY > 27 && posY < 42) {
            System.exit(0);
        }

        if (posX > 401 && posX < 431 && posY > 31 && posY < 37) {
            vLogin.setState(JFrame.ICONIFIED);
        }

        try {
            comando = ((JLabel) e.getSource()).getName();
        } catch (RuntimeException error) {
        }

        if (comando != null) {

            if (comando.equals("!Registrate Aqui¡")) {

                notificar("Registro");
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        String comando = null;
        try {
            comando = ((JLabel) e.getSource()).getName();
        } catch (RuntimeException error) {
            //No hace nada
        }

        if (comando != null) {

            if (comando.equals("!Registrate Aqui¡")) {

                vLogin.getLinkRegistro().setForeground(Color.BLUE);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        String comando = null;
        try {
            comando = ((JLabel) e.getSource()).getName();
        } catch (RuntimeException error) {
            //Sin Hacer nada
        }

        if (comando != null) {

            if (comando.equals("!Registrate Aqui¡")) {

                vLogin.getLinkRegistro().setForeground(Color.WHITE);
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
