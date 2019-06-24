
package SocialNetwork.Controller;

import SocialNetwork.Entities.Robot;
import SocialNetwork.Entities.Usuario;
import SocialNetwork.Model.RobotModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class RobotController implements ActionListener{
    private RobotModel robotModel;

    public RobotController() {
        robotModel = new RobotModel();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        
        switch (button.getName()) {
            case "btnAgregarBoot":
                agregarRobot();
            
            break;
        }
    }
    
    public void agregarRobot(){
        Usuario robot = new Robot();
    }
}
