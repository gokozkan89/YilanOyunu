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
    public void paint(Graphics g)
    {
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
            KuyrukEkle();
        }

        add(mHead);
    }

    public void KuyrukEkle()
    {
        Kutu K = Kutular.get(Kutular.size()-1).KutuOlustur();
        Kutular.add(K);
        add(K);
    }

    public void HepsiniYurut()
    {
        for (int i = Kutular.size()-1 ; i>0 ; i--)
        {
            Kutu Onceki = Kutular.get(i-1);
            Kutu Sonraki = Kutular.get(i);

            Sonraki.mYon = Onceki.mYon;
            Kutular.get(i-1).Hareket();
        }

        /*
        for (int i = 1 ; i<Kutular.size() ; i++)
        {
            Kutu Onceki = Kutular.get(i-1);
            Kutu Sonraki = Kutular.get(i);

            Sonraki.mYon = Onceki.mYon;
            Kutular.get(i-1).Hareket();
        }*/
    }

    public boolean CarpismaVarmi()
    {
        int Kalem = 10;
        int genislik = getWidth();
        int yukseklik = getHeight();

        if (mHead.getX() <= 10)
            return true;
        else if(mHead.getX() >= genislik)
            return true;
        else if(mHead.getY() <= 10)
            return true;
        else if(mHead.getY() >= 590)
            return true;
        else
            return false;
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
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                Kutular.get(0).mYon = YONLER.SOL;
            }

            if (e.getKeyCode()== KeyEvent.VK_DOWN)
            {
                Kutular.get(0).mYon = YONLER.ASAGI;
            }

            if (e.getKeyCode()== KeyEvent.VK_RIGHT)
            {
                Kutular.get(0).mYon = YONLER.SAG;
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

            HepsiniYurut();
            if(CarpismaVarmi())
               mTimer.stop();
        }
    }
}
