
package SocialNetwork.Controller;

import static InicioSesion.Config.Variables.altaRobotView;
import SocialNetwork.Entities.Robot;
import SocialNetwork.Entities.Usuario;
import SocialNetwork.Model.RobotModel;
import SocialNetwork.View.AltaRobotView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JButton;


public class AltaRobotController implements ActionListener{
    private RobotModel robotModel;

    public AltaRobotController() {
        robotModel = new RobotModel();
        altaRobotView = new AltaRobotView();
        altaRobotView.setVisible(true);
        cargarListeners();
    }
    
    
    private void cargarListeners(){
        altaRobotView.actionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        
        switch (button.getName()) {
            case "btnConfirmar":
                if(validaCampos()){
                    agregarRobot();
                }
            break;
        }
    }
    
    public boolean validaCampos(){
        boolean camposValidos = true;
        
        if(altaRobotView.getTxtApellido().getText().isEmpty()){
            altaRobotView.getLblMensaje().setText("Debe ingresar un Apellido");
            camposValidos = false;
        }
        if(altaRobotView.getTxtNombre().getText().isEmpty()){
            altaRobotView.getLblMensaje().setText("Debe ingresar un Nombre");
            camposValidos = false;
        }
        if(altaRobotView.getDateNacimiento().getDate() == null){
            altaRobotView.getLblMensaje().setText("Debe ingresar una fecha de nacimiento");
            camposValidos = false;
        }
        
        return camposValidos;
    }
    
    public void agregarRobot(){
        Usuario robot = new Robot();
        
        robot.setNombre(altaRobotView.getTxtNombre().getText());
        robot.setApellido(altaRobotView.getTxtApellido().getText());
        robot.setEmail("");
        robot.setCantidadAmigos(0);
        robot.setNacimiento((Date) altaRobotView.getDateNacimiento().getDate());
        robotModel.insertarRobot((Robot) robot);
    }    
}
