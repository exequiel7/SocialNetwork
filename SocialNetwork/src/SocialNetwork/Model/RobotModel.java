
package SocialNetwork.Model;

import static InicioSesion.Config.Variables.mysql;
import SocialNetwork.Entities.MensajeRobot;
import SocialNetwork.Entities.Robot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class RobotModel {
    private Connection conexion = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    private String dbMensajes = "mensajesrobots";
    private String dbUsuario = "usuario";
    private String dbRobot = "robot";
    private PreparedStatement pst;
    
    public RobotModel() {
    }
    
    public boolean insertarMensajesRobots(MensajeRobot mensaje){
        sSQL = "INSERT INTO " + dbMensajes + " (idmensajerobots, mensaje) "
                + " values (?,?)";
        int cantidadRegistros = 0;
        
        try{
            pst = conexion.prepareStatement(sSQL); //preparing the query
            pst.setInt(1, mensaje.getIdMensaje());
            pst.setString(2, mensaje.getMensaje());
            cantidadRegistros = pst.executeUpdate();
            if(cantidadRegistros > 0){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public String traerMensajePorIdMensaje(int idMensaje){
        int cantidadRegistros = 0;
        ResultSet rs;
        String mensajeRobot = "";
        
        sSQL = "SELECT mensaje from " + dbMensajes 
                + " WHERE 1=1"
                + " AND idmensaje=?";
        
        try{
            pst = conexion.prepareStatement(sSQL);
            pst.setInt(1, idMensaje);
            rs = pst.executeQuery();
            while(rs.next()){
                mensajeRobot = rs.getString("mensaje");
            }
            
            rs.close();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return null;
        }
        
        return mensajeRobot;
    }
    
    public int cantidadMensajesRobots(){
        sSQL = "SELECT count(*) as idmensaje from " + dbMensajes;
        int cantRegistros = 0;
        ResultSet rs;
        
        
        try {
            pst = conexion.prepareStatement(sSQL);
            rs = pst.executeQuery();
            cantRegistros = rs.getInt(1);
            
            rs.close();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return 0;
        }
        
        return cantRegistros;
    }
    
    public boolean insertarRobot(Robot robot){
        sSQL = "INSERT INTO " + dbUsuario + " (nombre, apellido, cantidadamigos, email, nacimiento)"
                + " values (?,?,?,?,?)";
        sSQL2 = "INSERT INTO " + dbRobot + " (idrobot)"
                + " values (?)";
        
        try {
            PreparedStatement pst = conexion.prepareStatement(sSQL); //preparing the query
            PreparedStatement pst2 = conexion.prepareStatement(sSQL2); //preparing the query2

            //PreparedStatement 1
            pst.setString(1, robot.getNombre());//send one to one all values to my PreparedStatement
            pst.setString(2, robot.getApellido());
            pst.setInt(3, robot.getCantidadAmigos());
            pst.setString(4, robot.getEmail());
            pst.setDate(5, robot.getNacimiento());

            //PreparedStatement 2
            pst2.setInt(1, robot.getIdRobot());
            
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
}
