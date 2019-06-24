
package SocialNetwork.Controller;

import static InicioSesion.Config.Variables.altaRobotView;
import SocialNetwork.View.SocialNetworkView;
import static InicioSesion.Config.Variables.socialNetworkView;
import SocialNetwork.Entities.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;

public class SocialNetworkController implements ActionListener{
    private Persona persona;
    
    public SocialNetworkController(Persona persona) {
        socialNetworkView = new SocialNetworkView();
        socialNetworkView.setVisible(true);
        this.persona = persona;
        cargarListeners();
    }
    
    private void cargarListeners(){
        socialNetworkView.actionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem button = (JMenuItem) e.getSource();
        AltaRobotController altaRobotController;
        
        switch (button.getName()) {
            case "btnAgregarBoot":
                altaRobotController = new AltaRobotController();
            break;

        }
    }
    
    
    
}
