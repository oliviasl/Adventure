import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Scroll extends Item {

    private ImageIcon scroll;

    public Scroll(int x, int y){
        super(x,y,75,24);

        scroll = new ImageIcon("ImageAssets/RolledScroll.png");

        setType("scroll");
    }

    @Override
    public void drawMe(Graphics g, int xDiff, int yDiff){
        scroll.paintIcon(null,g,getX()+xDiff,getY()+yDiff);
    }

    @Override
    public void drawInventoryItem(Graphics g, int x, int y){
        super.drawInventoryItem(g,x,y);
        scroll.paintIcon(null,g,x,y+30);
    }

}
