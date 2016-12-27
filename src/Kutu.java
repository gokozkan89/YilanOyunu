import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;


public class Kutu extends JLabel
{
    public int mGenislik = 20;
    public int mYon = Yonler.sag;

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

    public void SolaGit()
    {
        int PosX = getX();

        int PosY = getY();

        PosX -= mGenislik;
        setBounds(PosX,PosY,mGenislik,mGenislik);
    }

    public void SagaGit()
    {
        int PosX = getX();

        int PosY = getY();

        PosX += mGenislik;
        setBounds(PosX,PosY,mGenislik,mGenislik);

    }

    public void YukariGit()
    {
        int PosX = getX();

        int PosY = getY();

        PosY -= mGenislik;
        setBounds(PosX,PosY,mGenislik,mGenislik);
    }

    public void AssaGit()
    {
        int PosX = getX();

        int PosY = getY();

        PosY += mGenislik;
        setBounds(PosX,PosY,mGenislik,mGenislik);
    }

    public void Hareket()
    {
        if (mYon == Yonler.sag)
        {
            SagaGit();
        }

        else if (mYon == Yonler.yukari)
        {
            YukariGit();
        }

        else if (mYon == Yonler.asagi)
        {
            AssaGit();
        }

        else
        {
            SolaGit();
        }
    }

}
