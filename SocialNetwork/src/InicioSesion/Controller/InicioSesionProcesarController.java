
package InicioSesion.Controller;

import static InicioSesion.Config.Variables.conexion;
import SocialNetwork.Entities.Usuario;
import InicioSesion.View.InicioSesionView;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static InicioSesion.Config.Variables.inicioSesionView;
import static InicioSesion.Config.Variables.mysql;
import static InicioSesion.Config.Variables.seLogueo;
import SocialNetwork.Controller.SocialNetworkController;
import SocialNetwork.Entities.Persona;
import SocialNetwork.Model.PersonaModel;
import java.awt.Color;
//import SocialNetwork.Model.UsuarioModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class InicioSesionProcesarController implements ActionListener, KeyListener, FocusListener, WindowListener{
//    UsuarioService usuarioService;
//    UsuarioModel usuarioModel;
    PersonaModel personaModel;
    InicioSesionProcesarController(String accion) {
        inicioSesionView = new InicioSesionView();
        
        if(accion.equals("INICIO DE SESIÓN")){
            Usuario usuario = new Usuario();
            personaModel = new PersonaModel();
//            usuarioModel = new UsuarioModel();
        }
        cargarListeners();
        generarInstancias();
    }
    
    public void generarInstancias(){
        conexion = mysql.conectar();
    }
    
    private void cargarListeners() {
        inicioSesionView.windowListener(this);
        inicioSesionView.actionListener(this);
        inicioSesionView.keyListener(this);
        inicioSesionView.focusListener(this);
    }
    
    
    public void procesarLogin() {
//        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apellido", "Nacimiento", "E-Mail", "Amigos", "Login", "Clave", "Estado"};
        String[] registro = new String[6];
        String login, password;

        int totalregistros = 0;
        login = inicioSesionView.getTxtUsuario().getText();
        password = inicioSesionView.getTxtPassword().getText();
//        modelo = new DefaultTableModel(null, titulos);

        String sSQL = "SELECT u.idusuario, u.nombre, u.apellido, u.cantidadamigos, u.email, u.nacimiento "
                + "FROM usuario u INNER JOIN persona p ON u.idusuario = p.idpersona "
                + "WHERE p.login='" + login + "' and p.password='" + password + "' and p.estado='A'";

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            Persona persona = new Persona();
            
            while (rs.next()) {
                persona.setIdusuario(rs.getString("idusuario"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setEmail(rs.getString("email"));
                persona.setCantidadAmigos(rs.getInt("cantidadamigos"));
                persona.setNacimiento(rs.getDate("nacimiento"));
                
//                registro[7] = rs.getString("estado");
                totalregistros++;
//                modelo.addRow(registro);
            }
            if(totalregistros == 0){
                inicioSesionView.getLblMensaje().setText("Error! Usuario y contraseña incorrectos.");
            } else {
                seLogueo = true;
                inicioSesionView.dispose();
                new SocialNetworkController(persona);
            }
//            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
//            return null;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "Ingresar":
                procesarLogin();
                break;
            default:
                System.out.println("Comando no definido");
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == inicioSesionView.getTxtUsuario().getText()) {
                inicioSesionView.getLblpassword().requestFocus();
            }
            if (e.getSource() == inicioSesionView.getTxtPassword().getText()) {
                inicioSesionView.getBtnIniciarSesion().requestFocus();
            }
            if (e.getSource() == inicioSesionView.getBtnIniciarSesion()) {
                procesarLogin();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        String nombreUsuario, password;

        nombreUsuario = inicioSesionView.getTxtUsuario().getText();

        if (e.getSource() == inicioSesionView.getTxtUsuario()
                && nombreUsuario.equals("Usuario")) {
            inicioSesionView.getTxtUsuario().setText("");
            inicioSesionView.getTxtUsuario().setForeground(Color.BLACK);
        }

        password = new String(inicioSesionView.getLblpassword().getText());

        if (e.getSource() == inicioSesionView.getLblpassword()
                && password.equals("Password")) {
            inicioSesionView.getTxtPassword().setText("");
            inicioSesionView.getTxtPassword().setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        String nombreUsuario, password;

        nombreUsuario = inicioSesionView.getTxtUsuario().getText();

        if (e.getSource() == inicioSesionView.getTxtUsuario()) {
            if (nombreUsuario.isEmpty()) {
                inicioSesionView.getTxtUsuario().setText("Usuario");
                inicioSesionView.getTxtUsuario().setForeground(Color.GRAY);
            }
            
        }

        password = new String(inicioSesionView.getTxtPassword().getText());

        if (e.getSource() == inicioSesionView.getTxtPassword()) {
            if (password.isEmpty()) {
                inicioSesionView.getTxtPassword().setText("Password");
                inicioSesionView.getTxtPassword().setForeground(Color.GRAY);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
       
    }

    @Override
    public void windowClosing(WindowEvent e) {
        inicioSesionView.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
    
    
}
