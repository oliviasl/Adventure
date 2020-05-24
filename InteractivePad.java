import java.awt.Graphics;
import java.awt.Color;

public class InteractivePad extends Item{


    private int b;
    private int increment;

    public InteractivePad(int x, int y){
        super(x,y,75,75);

        b = 64;
        increment = 2;
    }


    public void drawMe(Graphics g, int xDiff, int yDiff){
        g.setColor(new Color(169,252,b));
        g.fillOval(getX()+xDiff,getY()+yDiff,75,75);
    }


    public void changeColor(){
        if( b == 126 ){
            increment = -2;
        } else if ( b == 30 ){
            increment = 2;
        }
        b += increment;
    }

}
