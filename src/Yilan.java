import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

public class Yilan extends JLabel
{
    public Kutu mHead = new Kutu();

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D)g;

        Rectangle2D rect = new Rectangle2D.Double(5,5,getWidth()-10,getHeight()-10);
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(10));
        g2.draw(rect);

    }
    Yilan()
    {

        addKeyListener(new KlavyeKontrol());
        setFocusable(true);
        add(mHead);
    }
    class KlavyeKontrol implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e)
        {

        }

        @Override
        public void keyPressed(KeyEvent e)
        {

            if (e.getKeyCode() == KeyEvent.VK_W)
            {
                int PosX = mHead.getX();

                int PosY = mHead.getY();

                PosY -= mHead.mGenislik;
                mHead.setBounds(PosX,PosY,mHead.mGenislik,mHead.mGenislik);
            }

            if (e.getKeyCode() == KeyEvent.VK_A)
            {
                int PosX = mHead.getX();

                int PosY = mHead.getY();

                PosX -= mHead.mGenislik;
                mHead.setBounds(PosX,PosY,mHead.mGenislik,mHead.mGenislik);
            }

            if (e.getKeyCode()== KeyEvent.VK_S)
            {
                int PosX = mHead.getX();

                int PosY = mHead.getY();

                PosY += mHead.mGenislik;
                mHead.setBounds(PosX,PosY,mHead.mGenislik,mHead.mGenislik);
            }

            if (e.getKeyCode()== KeyEvent.VK_D)
            {
                int PosX = mHead.getX();

                int PosY = mHead.getY();

                PosX += mHead.mGenislik;
                mHead.setBounds(PosX,PosY,mHead.mGenislik,mHead.mGenislik);
            }
        }

        @Override
        public void keyReleased(KeyEvent e)
        {

        }
    }

}
