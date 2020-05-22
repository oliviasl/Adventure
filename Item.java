import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Item {
	private int x;
	private int y;
	private int width;
	private int height;
	private int gameLevel;

	private String type;

	public Item(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		gameLevel = 1;

		type = "type";
	}

	public void drawMe(Graphics g, int x, int y){
	}

	public void drawInventoryItem(Graphics g, int x, int y){
		//draw black border of an inventory Item
		g.setColor(Color.black);
		g.drawRect(x,y,75,75);
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}


	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public void setGameLevel(int gameLevel){
        this.gameLevel = gameLevel;
    }

	public int getGameLevel(){
		return gameLevel;
	}

}
