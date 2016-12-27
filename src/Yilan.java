import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

public class Yilan extends JLabel
{

    public Kutu mHead = new Kutu();
    public Timer mTimer = null;

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
        mTimer = new Timer(300,new TimerKontrol());
        mTimer.start();
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
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
               mHead.mYon = Yonler.yukari;
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                mHead.mYon = Yonler.sol;

            }

            if (e.getKeyCode()== KeyEvent.VK_DOWN)
            {
                mHead.mYon = Yonler.asagi;

            }

            if (e.getKeyCode()== KeyEvent.VK_RIGHT)
            {
                mHead.mYon = Yonler.sag;
            }
        }

        @Override
        public void keyReleased(KeyEvent e)
        {

        }
    }

    class TimerKontrol implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
          mHead.Hareket();
        }
    }
}
