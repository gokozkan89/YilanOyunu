import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Yilan extends JLabel
{

    public Kutu mHead = new Kutu();
    public Timer mTimer = null;
    public ArrayList<Kutu> Kutular = new ArrayList<Kutu>();

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
        Kutular.add(mHead);

        for (int i = 1 ;i<10;i++)
        {
            Kutu K = Kutular.get(Kutular.size()-1).KutuOlustur();
            Kutular.add(K);
            add(K);
        }

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
                Kutular.get(0).mYon = YONLER.YUKARI;
                Kutular.get(1).mYon = YONLER.YUKARI;
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                Kutular.get(0).mYon = YONLER.SOL;
                Kutular.get(1).mYon = YONLER.SOL;

            }

            if (e.getKeyCode()== KeyEvent.VK_DOWN)
            {
                Kutular.get(0).mYon = YONLER.ASAGI;
                Kutular.get(1).mYon = YONLER.ASAGI;


            }

            if (e.getKeyCode()== KeyEvent.VK_RIGHT)
            {
                Kutular.get(0).mYon = YONLER.SAG;
                Kutular.get(1).mYon = YONLER.SAG;
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
          for (int i = 0; i<Kutular.size();i++)
          {
              Kutular.get(i).Hareket();
          }

        }
    }
}
