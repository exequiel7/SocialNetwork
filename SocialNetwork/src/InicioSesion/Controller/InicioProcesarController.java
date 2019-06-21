
package InicioSesion.Controller;

import static InicioSesion.Config.Variables.inicioSesionView;
import java.util.logging.Logger;



public class InicioProcesarController {
    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public InicioProcesarController() {
    }

    public static void main(String args[]) {
//        Debugging.setEnable(true);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InicioSesionProcesarController("INICIO DE SESIÓN");
                inicioSesionView.setVisible(true);

            }
        });
    }
}
