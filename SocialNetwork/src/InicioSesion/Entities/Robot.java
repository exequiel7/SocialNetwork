
package InicioSesion.Entities;


public class Robot extends Usuario{

    private int idRobot;
    
    public Robot() {
        idRobot = super.getIdusuario();
    }

    public int getIdRobot() {
        return idRobot;
    }

    public void setIdRobot(int idRobot) {
        this.idRobot = idRobot;
    }
       
    
}
