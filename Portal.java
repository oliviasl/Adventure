import java.awt.Graphics;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Portal extends Item{


    private ImageIcon portal;


    public Portal(int x, int y){
        super(x,y,250,230);

        portal = new ImageIcon("ImageAssets/Portal.png");
    }


    public void drawMe(Graphics g, int xDiff, int yDiff){
        portal.paintIcon(null,g,getX()+xDiff,getY()+yDiff);
    }

}
