
package SocialNetwork.Entities;


public class MensajeRobot {
    private String mensaje;
    public static int idMensaje = 0;

    public MensajeRobot() {
        idMensaje++;
        mensaje = "";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }
    
}
