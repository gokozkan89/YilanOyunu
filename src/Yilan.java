import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
public class Yilan extends JLabel
{

    public Kutu mHead = new Kutu();
    public Timer mTimer = null;
    public Yem mYem= new Yem();
    public ArrayList<Kutu> Kutular = new ArrayList<Kutu>();
    public Random r = new Random();
    public int Score = 0;
    public int ArtisMiktari = 10;

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
        add(mYem);
        add(mHead);
        for (int i = 1 ;i<10;i++)
        {
            KuyrukEkle();
        }


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


            Kutular.get(i).Hareket();
            Sonraki.mYon = Onceki.mYon;
        }
        mHead.Hareket();

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
        //int Kalem = 10;
        int genislik = getWidth();
        int yukseklik = getHeight();
        if (mHead.getX() <= 10 || mHead.getX() >= genislik - 19|| mHead.getY() <= 10 || mHead.getY() >= yukseklik-19)
            return true;
        for (int i=1; i<Kutular.size();i++)
        {
            int X = Kutular.get(i).getX();
            int Y = Kutular.get(i).getY();
            if ((X==mHead.getX())&&(Y==mHead.getY()))
                return true;
        }
        return false;
    }
    public boolean yemYenildimi()
    {
        int genislik = getWidth();
        int yuksekik = getHeight();
        return mHead.getX()==mYem.getX()&&mHead.getY()==mYem.getY();
    }
    public void YemOlustur()
    {

        //Yılan boyu uzatılacak
        int randomX = r.nextInt(30)*20;
        int randomY = r.nextInt(30)*20;
        mYem.setPosition(randomX,randomY);
        KuyrukEkle();
        ScoreArttir();

    }

    public void ScoreArttir()
    {
        //Score Ekrana Yazdırılacak
        Score+=ArtisMiktari;
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
                if (mHead.mYon != YONLER.ASAGI)
                    Kutular.get(0).mYon = YONLER.YUKARI;
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                if (mHead.mYon != YONLER.SAG)
                    Kutular.get(0).mYon = YONLER.SOL;
            }

            if (e.getKeyCode()== KeyEvent.VK_DOWN)
            {
                if (mHead.mYon != YONLER.YUKARI)
                    Kutular.get(0).mYon = YONLER.ASAGI;
            }

            if (e.getKeyCode()== KeyEvent.VK_RIGHT)
            {
                if (mHead.mYon != YONLER.SOL)
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
            if (yemYenildimi())
            {
                YemOlustur();
            }
        }
    }
}
