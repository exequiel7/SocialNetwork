
package InicioSesion.Controller;

import SocialNetwork.Entities.Usuario;
import InicioSesion.View.InicioSesionView;
//import SocialNetworl.Services.UsuarioService;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static InicioSesion.Config.Variables.inicioSesionView;
import SocialNetwork.Model.UsuarioModel;

public class InicioSesionProcesarController {
//    UsuarioService usuarioService;
    UsuarioModel usuarioModel;
    InicioSesionProcesarController(String accion) {
        inicioSesionView = new InicioSesionView();
        
        if(accion.equals("INICIO DE SESIÓN")){
            Usuario usuario = new Usuario();
            usuarioModel = new UsuarioModel();
        }
    }
    
    public void generarInstancias(){
        
    }
    
    
    
    
}
