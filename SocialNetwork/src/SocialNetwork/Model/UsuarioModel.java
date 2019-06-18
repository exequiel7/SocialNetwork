
package SocialNetwork.Model;

import static InicioSesion.Config.Variables.conexion;
import static InicioSesion.Config.Variables.mysql;
import SocialNetwork.Entities.Persona;
import SocialNetwork.Entities.Usuario;
import SocialNetwork.ConexionDB.MySqlConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioModel {

//    private MySqlConexion mysql = new MySqlConexion();
//    private Connection conexion = mysql.conectar();
    private Integer totalRegistros;
    private String sSQL = "";//for user
    private String sSQL2 = "";//for user

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apellido", "Nacimiento", "E-Mail", "Amigos"};
        String[] registro = new String[6];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT u.idusuario, u.nombre, u.apellido, u.cantidadamigos, u.email, u.nacimiento "
                + "FROM usuario u INNER JOIN persona p ON u.idusuario = p.idpersona "
                + "WHERE nombre LIKE '%" + buscar + "%' ORDER BY p.idpersona desc";

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idusuario");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("cantidadamigos");
                registro[4] = rs.getString("email");
                registro[5] = rs.getString("nacimiento");
                totalRegistros++;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return null;
        }

    }

    public boolean insertarPersona(Persona user) {
        sSQL = "insert into Usuario(nombre, apellido, cantidadamigos, email, nacimiento)"
                + " values (?, ?, ?, ?, ?)"; //record data of a person

        sSQL2 = "insert into persona(idpersona, login, password, estado)" //record data of a employee
                + " values ((select idpersona from persona order by idpersona desc limit 1), ?, ?, ?)"; //get the latest registration from personas table

        try {
            PreparedStatement pst = conexion.prepareStatement(sSQL); //preparing the query
            PreparedStatement pst2 = conexion.prepareStatement(sSQL2); //preparing the query2

            //PreparedStatement 1
            pst.setString(1, user.getNombre());//send one to one all values to my PreparedStatement
            pst.setString(2, user.getApellido());
            pst.setInt(3, user.getCantidadAmigos());
            pst.setString(4, user.getEmail());
            pst.setDate(5, user.getNacimiento());

            //PreparedStatement 2
            pst2.setString(1, user.getLogin());
            pst2.setString(2, user.getPassword());
            pst2.setString(3, user.getEstado());
            
            int n = pst.executeUpdate(); //save result of statement execute 
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public boolean editar(Usuario user) {
        sSQL = "update usuario set nombre=?, apellido=?, cantidadamigos=?, email=?, nacimiento=?"
                + " where idusuario=?"; //will set my keys, only if id is correct

//        sSQL2 = "update trabajador set sueldo=?, acceso=?, login=?, password=?, estado=?"
//                + "where idpersona=?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sSQL); //preparing the query
            PreparedStatement pst2 = conexion.prepareStatement(sSQL2); //preparing the query2

            //PreparedStatement 1
            pst.setString(1, user.getNombre());//send one to one all values to my PreparedStatement
            pst.setString(2, user.getApellido());
            pst.setInt(3, user.getCantidadAmigos());
            pst.setString(4, user.getEmail());
            pst.setDate(5, user.getNacimiento());

//            //PreparedStatement 2
//            pst2.setDouble(1, dts.getSueldo());
//            pst2.setString(2, dts.getAcceso());
//            pst2.setString(3, dts.getLogin());
//            pst2.setString(4, dts.getPassword());
//            pst2.setString(5, dts.getEstado());
//            pst2.setInt(6, dts.getIdpersona());

            int n = pst.executeUpdate(); //save result of statement execute 
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public boolean eliminar(Usuario user) {
        sSQL = "delete from trabajador where idusuario =?";
        sSQL2 = "delete from persona where idpersona =?";

        try {
            PreparedStatement pst = conexion.prepareStatement(sSQL); //preparing the query
            PreparedStatement pst2 = conexion.prepareStatement(sSQL2); //preparing the query2

            //PreparedStatement 1
            pst.setInt(1, user.getIdusuario());

            //PreparedStatement 2
            pst2.setInt(1, user.getIdusuario());

            int n = pst.executeUpdate(); //save result of statement execute 
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }
    
//    public DefaultTableModel login(String login, String password) {
//        DefaultTableModel modelo;
//        String[] titulos = {"ID", "Nombre", "Apellido", "Nacimiento", "E-Mail", "Amigos", "Login", "Clave", "Estado"};
//        String[] registro = new String[6];
//
//        int totalregistros = 0;
//        modelo = new DefaultTableModel(null, titulos);
//
//        String sSQL = "SELECT u.idusuario, u.nombre, u.apellido, u.cantidadamigos, u.email, u.nacimiento "
//                + "FROM usuario u INNER JOIN persona p ON u.idusuario = p.idpersona "
//                + "WHERE p.login='" + login + "' and p.password='" + password + "' and p.estado='A'";
//
//        try {
//            Statement st = conexion.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
//
//            while (rs.next()) {
//                registro[0] = rs.getString("idusuario");
//                registro[1] = rs.getString("nombre");
//                registro[2] = rs.getString("apellido");
//                registro[3] = rs.getString("email");
//                registro[4] = rs.getString("cantidadamigos");
//                
//                registro[5] = rs.getString("login");
//                registro[6] = rs.getString("password");
//                registro[7] = rs.getString("estado");
//
//                totalregistros++;
//                modelo.addRow(registro);
//            }
//            return modelo;
//
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(null, e.getMessage());
//            return null;
//        }
//
//    }

    
}

