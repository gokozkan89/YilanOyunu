import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;


public class Kutu extends JLabel
{
    public int mGenislik = 20;
    public int mYon = YONLER.SAG;

    //İlk kutunun yani yılanın ilk parçasının ekranın ortasında oluşması sağlanacak...
    public Kutu()
    {

        setBounds(300,300,mGenislik,mGenislik);
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
        if (mYon == YONLER.SAG)
        {
            SagaGit();
        }

        else if (mYon == YONLER.YUKARI)
        {
            YukariGit();
        }

        else if (mYon == YONLER.ASAGI)
        {
            AssaGit();
        }

        else
        {
            SolaGit();
        }
    }

    public Kutu KutuOlustur()
    {
        Kutu K = new Kutu();

        int X = getX();
        int Y = getY();

        K.setBounds(X,Y,mGenislik,mGenislik);
        K.mYon = -mYon;
        K.Hareket();
        K.mYon = mYon;

        return K;
    }
}
