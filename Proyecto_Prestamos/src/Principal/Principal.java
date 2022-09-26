package Principal;
import Modelo.*;
import controlador.ControladorClientes;
import controlador.ControladorPrestamos;
import controlador.ControladorSupremo;
import vista.VistaClientes;

import java.io.IOException;

//
public class Principal
{
    public static void main(String [] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                try {
                    ControladorSupremo control = new ControladorSupremo();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });
    }
}
