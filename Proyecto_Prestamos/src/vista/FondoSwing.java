package vista;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FondoSwing implements Border { //clase para colocar una imagen de fondo
    private BufferedImage imagen = null;

    public FondoSwing(BufferedImage imagen) {
        this.imagen = imagen;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if(imagen !=null){
            g.drawImage(imagen, 0, 0, width, height, null);
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}

