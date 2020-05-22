import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Villager extends Item {

    private ImageIcon oldManImage, womanImage;

    private int villagerType;

    public Villager(int x, int y, int villagerType){
        super(x,y,65,100);

        oldManImage = new ImageIcon("ImageAssets/OldMan.png");
        womanImage = new ImageIcon("ImageAssets/Woman.png");

        setType("villager");
        this.villagerType = villagerType;
    }

    @Override
    public void drawMe(Graphics g, int xDiff, int yDiff){
        if( villagerType == 1 ){
            oldManImage.paintIcon(null,g,getX()+xDiff,getY()+yDiff);
        } else {
            womanImage.paintIcon(null,g,getX()+xDiff,getY()+yDiff);
        }

    }

}
