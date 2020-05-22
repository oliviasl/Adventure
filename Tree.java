import java.awt.Color;
import java.awt.Graphics;

public class Tree{
	private int originalX;
	private int originalY;
	private Color treeBrown;
	private Color treeGreen;
	private Color bushGreen;

	public Tree(int x, int y){
		originalX = x;
		originalY = y;

		treeBrown = new Color(205,133,63);
		treeGreen = new Color(0,100,0);
		bushGreen = new Color(2,69,2);
	}


	public void drawMe(Graphics g, int xDiff, int yDiff){
		int x = originalX + xDiff;
		int y = originalY + yDiff;

		g.setColor(treeBrown);
		g.fillRect(x-7,y,30,120);
		g.fillPolygon(new int[] {x-30,x+45,x+7},new int[] {y+120,y+120,y+95},3);
		g.setColor(treeGreen);
		g.fillOval(x-67,y-22,70,85);
		g.fillOval(x-38,y-34,90,105);
		g.fillOval(x+12,y-22,70,85);
		x += 120;
	}

	public void drawMeWithBush(Graphics g, int xDiff, int yDiff){
		int x = originalX + xDiff;
		int y = originalY + yDiff;

		//bush
		g.setColor(bushGreen);
		g.fillOval(x+20,y+90,65,30);
		g.fillOval(x+60,y+90,65,30);

		//tree
		g.setColor(treeBrown);
		g.fillRect(x-7,y,30,120);
		g.fillPolygon(new int[] {x-30,x+45,x+7},new int[] {y+120,y+120,y+95},3);
		g.setColor(treeGreen);
		g.fillOval(x-67,y-22,70,85);
		g.fillOval(x-38,y-34,90,105);
		g.fillOval(x+12,y-22,70,85);
	}


}
