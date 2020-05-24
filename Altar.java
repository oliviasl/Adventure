import java.awt.Graphics;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Altar extends Item{


    private ImageIcon altar;


    public Altar(int x, int y){
        super(x,y,100,150);

        altar = new ImageIcon("ImageAssets/Altar.png");
    }


    public void drawMe(Graphics g, int xDiff, int yDiff){
        altar.paintIcon(null,g,getX()+xDiff,getY()+yDiff);
    }

}
