package Modelo;

import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border{ //clase para colocarle borde a los botones creados

    private int radioBorde;

    public RoundedBorder(int radio){
        this.radioBorde = radio;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x,y,width-1,height-1,radioBorde,radioBorde);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radioBorde+1, this.radioBorde+1, this.radioBorde+2,this.radioBorde);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
