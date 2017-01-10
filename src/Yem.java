import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JLabel;


public class Yem extends JLabel
{
    public int mGenislik = 20;
    Yem()
    {
        setPosition(100,100);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        Graphics2D g2 = (Graphics2D)g;

        Ellipse2D ellipse = new Ellipse2D.Double(1,1,mGenislik-2,mGenislik-2);
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(2));
        g2.draw(ellipse);
        g2.setColor(Color.red);
        g2.fill(ellipse);
    }
    public void setPosition(int PosX,int PosY)
    {
        setBounds(PosX,PosY,mGenislik,mGenislik);
    }
}
