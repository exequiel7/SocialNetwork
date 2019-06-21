
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

public class InicioSesionProcesarController implements ActionListener, KeyListener, FocusListener, MouseListener, WindowListener{
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
        
        generarInstancias();
    }
    
    public void generarInstancias(){
        conexion = mysql.conectar();
    }
    
    
    public void procesarLogin() {
//        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apellido", "Nacimiento", "E-Mail", "Amigos", "Login", "Clave", "Estado"};
        String[] registro = new String[6];
        String login, password;

        int totalregistros = 0;
        login = inicioSesionView.getLblusuario().getText();
        password = inicioSesionView.getLblpassword().getText();
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
            case "Iniciar sesion":
                procesarLogin();
                break;
            default:
                System.out.println("Comando no definido");
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusGained(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
