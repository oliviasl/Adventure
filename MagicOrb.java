import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class MagicOrb extends Item {

    private ImageIcon magicOrb;

    public MagicOrb(int x, int y){
        super(x,y,45,45);

        magicOrb = new ImageIcon("ImageAssets/MagicOrb.png");

        setType("magicorb");
    }

    @Override
    public void drawMe(Graphics g, int xDiff, int yDiff){
        if( getGameLevel() == 3 ){
            magicOrb.paintIcon(null,g,getX()+xDiff,getY()+yDiff);
            g.setColor(Color.black);
        }
    }

    @Override
    public void drawInventoryItem(Graphics g, int x, int y){
        super.drawInventoryItem(g,x,y);
        magicOrb.paintIcon(null,g,x+15,y+15);
    }

}
