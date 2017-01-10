import javafx.geometry.Pos;

import javax.swing.*;
import java.awt.*;

//Singelton tasarım deseni kullanıldı.
public class Pencere extends JFrame
{

    private int mGenislik = 606;
    private int mYukseklik = 629;

    private static Pencere mPencere = null;

    private Pencere()
    {
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        EkraniOrtala();

        Yilan Y = new Yilan();

        add(Y);
    }

    public static Pencere PencereGetir()
    {
        if(mPencere == null)
            mPencere = new Pencere();

        return mPencere;
    }

    public void EkraniOrtala()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int PosX = 0;
        int PosY = 0;

        if(mGenislik + 100 > dim.width)
        {
            mGenislik = dim.width - 100;
        }

        if(mYukseklik + 100 > dim.height)
        {
            mYukseklik = dim.height - 100;
        }

        PosX = (dim.width - mGenislik)/2;
        PosY = (dim.height - mYukseklik)/2;

        setBounds(PosX,PosY,mGenislik,mYukseklik);
    }
}
