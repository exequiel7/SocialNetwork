
package SocialNetwork.Entities;


public class Robot extends Usuario{

    private String idRobot;
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
    public String getIdRobot() {
        return idRobot;
    }

    public void setIdRobot(String idRobot) {
        this.idRobot = idRobot;
    }
}
