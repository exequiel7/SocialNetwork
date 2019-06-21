
package SocialNetwork.Controller;

import SocialNetwork.View.SocialNetworkView;
import static InicioSesion.Config.Variables.socialNetworkView;
import SocialNetwork.Entities.Persona;

public class SocialNetworkController {
    private Persona persona;
    
    public SocialNetworkController(Persona persona) {
        socialNetworkView = new SocialNetworkView();
        socialNetworkView.setVisible(true);
        this.persona = persona;
    }
    
    
    
}
