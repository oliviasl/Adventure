import java.awt.Graphics;
import java.awt.Color;

public class Rock extends Item{


    private Color gray;


    public Rock(int x, int y){
        super(x,y,65,50);

        gray = new Color(153,153,153);
    }


    public void drawMe(Graphics g, int xDiff, int yDiff){
        g.setColor(gray);
        g.fillArc(getX()+xDiff,getY()+yDiff,75,60,0,180);
    }

}
