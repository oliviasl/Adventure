import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class House{
	private int originalX;
	private int originalY;
    private int houseNumber;
    private ImageIcon house1, house2, house3, house4;

	public House(int x, int y, int houseNumber){
		originalX = x;
		originalY = y;
        this.houseNumber = houseNumber;

        house1 = new ImageIcon("ImageAssets/House1.png");
        house2 = new ImageIcon("ImageAssets/House2.png");
        house3 = new ImageIcon("ImageAssets/House3.png");
        house4 = new ImageIcon("ImageAssets/House4.png");
	}


	public void drawMe(Graphics g, int xDiff, int yDiff){
		int x = originalX + xDiff;
		int y = originalY + yDiff;

		switch(houseNumber){
			case 1:
				house1.paintIcon(null,g,x,y);
				break;
			case 2:
				house2.paintIcon(null,g,x,y);
				break;
			case 3:
				house3.paintIcon(null,g,x,y);
				break;
			case 4:
				house4.paintIcon(null,g,x,y);
				break;
			default:
				break;
		}
	}


}
