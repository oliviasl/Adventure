import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Sword extends Item {

    private ImageIcon swordForRock, swordForGoblin;

    public Sword(int x, int y){
        super(x,y,33,75);

        swordForRock = new ImageIcon("ImageAssets/SwordForRock.png");
        swordForGoblin = new ImageIcon("ImageAssets/SwordForGoblin.png");

        setType("sword");
    }

    @Override
    public void drawMe(Graphics g, int xDiff, int yDiff){
        if( getGameLevel() == 2 ){
            swordForRock.paintIcon(null,g,getX()+xDiff,getY()+yDiff);
        } else if ( getGameLevel() == 3 ){
            swordForGoblin.paintIcon(null,g,getX()+xDiff,getY()+yDiff);
        }

    }

    @Override
    public void drawInventoryItem(Graphics g, int x, int y){
        super.drawInventoryItem(g,x,y);
        swordForRock.paintIcon(null,g,x+20,y);
    }


}
