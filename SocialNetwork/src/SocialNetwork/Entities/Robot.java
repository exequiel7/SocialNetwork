
package SocialNetwork.Entities;


public class Robot extends Usuario{

    private int idRobot;
    private MensajeRobot mensajeRobot;
    
    public Robot() {
        idRobot = super.getIdusuario();
    }

    public MensajeRobot getMensajeRobot() {
        return mensajeRobot;
    }

    public void setMensajeRobot(MensajeRobot mensajeRobot) {
        this.mensajeRobot = mensajeRobot;
    }
    public int getIdRobot() {
        return idRobot;
    }

    public void setIdRobot(int idRobot) {
        this.idRobot = idRobot;
    }
}
