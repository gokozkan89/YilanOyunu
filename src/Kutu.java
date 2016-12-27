import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;


public class Kutu extends JLabel
{
    public int mGenislik = 20;

    Kutu()
    {
        setBounds(100,100,mGenislik,mGenislik);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        Graphics2D g2 = (Graphics2D)g;

        Rectangle2D rect = new Rectangle2D.Double(1,1,getWidth()-2,getHeight()-2);
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(2));
        g2.draw(rect);
        g2.setColor(Color.red);
        g2.fill(rect);

    }
}
