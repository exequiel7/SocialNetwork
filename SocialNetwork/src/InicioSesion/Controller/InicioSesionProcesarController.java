
package InicioSesion.Controller;

import InicioSesion.Entities.Usuario;
import SocialNetworl.Services.UsuarioService;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InicioSesionProcesarController {
    UsuarioService usuarioService;
    InicioSesionProcesarController(String accion) {
        if(accion.equals("INICIO DE SESIÓN")){
            Usuario usuario = new Usuario();
            usuarioService = new UsuarioService();
        }
    }
    
    
    
    
    
}
