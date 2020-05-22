import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Player
{
	private int x;
	private int y;
	private int width;
	private int height;
	private int walk;
	private int directionFacing;

	private ImageIcon walkRight1, walkRight2, walkLeft1, walkLeft2;


	public Player(int x, int y)
	{
		this.x = x;
		this.y = y;

		width=55;	 //total width of the player
		height=100;  //total height of the player

		walk = 1;
		directionFacing = 1; //1 is right 2 is left

		//Images
		walkRight1 = new ImageIcon("ImageAssets/HeroWalkRight1.png");
		walkRight2 = new ImageIcon("ImageAssets/HeroWalkRight2.png");
		walkLeft1 = new ImageIcon("ImageAssets/HeroWalkLeft1.png");
		walkLeft2 = new ImageIcon("ImageAssets/HeroWalkLeft2.png");

	}


	public void drawMe(Graphics g)
	{
		if( walk == 1 ){
			if( directionFacing == 1 ){
				walkRight1.paintIcon(null,g,x,y);
			} else {
				walkLeft1.paintIcon(null,g,x,y);
			}
		} else {
			if( directionFacing == 1 ){
				walkRight2.paintIcon(null,g,x,y);
			} else {
				walkLeft2.paintIcon(null,g,x,y);
			}
		}
	}


	public boolean checkCollision(Item item, int xDiff, int yDiff){

		int pX = x;
		int pY = y;
		int pWidth = width;
		int pHeight = height;

		int iX = item.getX() + xDiff;
		int iY = item.getY() + yDiff;
		int iWidth = item.getWidth();
		int iHeight = item.getHeight();

		if( pX+pWidth >= iX && pX <= iX + iWidth && pY + pHeight >= iY && pY <= iY + iHeight){
			return true;
		}
		return false;

	}


	public void setWalk(int walk){
		this.walk = walk;
	}

	public void setDirectionFacing(int directionFacing){
		this.directionFacing = directionFacing;
	}


}
