
package SocialNetwork.Controller;

import SocialNetwork.View.SocialNetworkView;
import static InicioSesion.Config.Variables.socialNetworkView;
import SocialNetwork.Entities.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class SocialNetworkController implements ActionListener{
    private Persona persona;
    
    public SocialNetworkController(Persona persona) {
        socialNetworkView = new SocialNetworkView();
        socialNetworkView.setVisible(true);
        this.persona = persona;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        AltaRobotController altaRobotController;
        
        switch (button.getName()) {
            case "btnAgregarBoot":
                altaRobotController = new AltaRobotController();
            break;

        }
    }
    
    
    
}
