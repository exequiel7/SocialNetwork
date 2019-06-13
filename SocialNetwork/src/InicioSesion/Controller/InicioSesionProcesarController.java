
package InicioSesion.Controller;

import InicioSesion.Entities.Usuario;
import InicioSesion.View.InicioSesionView;
import SocialNetworl.Services.UsuarioService;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static InicioSesion.Config.Variables.inicioSesionView;

public class InicioSesionProcesarController {
    UsuarioService usuarioService;
    InicioSesionProcesarController(String accion) {
        inicioSesionView = new InicioSesionView();
        
        if(accion.equals("INICIO DE SESIÓN")){
            Usuario usuario = new Usuario();
            usuarioService = new UsuarioService();
        }
    }
    
    
    
    
    
}
