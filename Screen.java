import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;


public class Screen extends JPanel implements KeyListener, ActionListener {


	private Player p1;

	private int xDiff, yDiff;
	private int gameLevel;
	private int walk, directionFacing;
	private int narrationSequence;

	private boolean narrationGo, villagersFound;

	private ArrayList<Item> groundItems, inventoryItems;
	private ArrayList<Villager> villagerList;
	private ArrayList<Tree> treeList, forestList;
	private ArrayList<House> houseList;

	private JButton startButton;

	private Color groundGreen, groundBrown, rockGray;

	private ImageIcon openingNarration1, openingNarration2, openingNarration3;
	private ImageIcon openingNarration4, openingNarration5, openingNarration6;
	private ImageIcon openingNarration7, openingNarration8, openingNarration9;
	private ImageIcon openingNarration10, openingNarration11, openingNarration12;
	private ImageIcon quest1Narration1, quest1Narration2;


	public Screen(){

		//sets up the instance variables
		p1 = new Player(350,270);
		xDiff = 0;
		yDiff = 0;
		gameLevel = 0;
		walk = 1;
		directionFacing = 1; //1 for right, 2 for left
		narrationSequence = 1;
		narrationGo = true;
		villagersFound = false;

		//Colors
		groundGreen = new Color(75,189,75);
		groundBrown = new Color(112,101,89);
		rockGray = new Color(153,153,153);


		//array lists
		//ground items
		groundItems = new ArrayList<Item>();
		groundItems.add(new Scroll(500,300));
		groundItems.add(new Sword(1250,200));

		//inventory
		inventoryItems = new ArrayList<Item>();

		//trees
		treeList = new ArrayList<Tree>();
		//top trees 0-12
		int x = 0;
		for(int i = 0;i < 13;i ++){
			treeList.add(new Tree(x,-65));
			x += 130;
		}
		//bottom trees 13-25
		x = 0;
		for(int i = 0;i < 13;i ++){
			treeList.add(new Tree(x,1170));
			x += 130;
		}
		//right trees 26-38
		int y = -62;
		for(int i = 0;i < 12;i ++){
			treeList.add(new Tree(1630,y));
			y += 112;
		}
		//left trees 42-51
		y = -62;
		for(int i = 0;i < 12;i ++){
			treeList.add(new Tree(-45,y));
			y += 112;
		}


		//forest trees
		forestList = new ArrayList<Tree>();
		forestList.add(new Tree(1200,50));
		forestList.add(new Tree(1400,75));
		forestList.add(new Tree(1500,100));
		forestList.add(new Tree(950,110));
		forestList.add(new Tree(1000,275));
		forestList.add(new Tree(1450,300));
		forestList.add(new Tree(1050,325));
		forestList.add(new Tree(900,330));
		forestList.add(new Tree(1325,450));
		forestList.add(new Tree(1000,475));
		forestList.add(new Tree(1425,475));
		forestList.add(new Tree(925,530));
		forestList.add(new Tree(1500,570));
		forestList.add(new Tree(1200,575));


		//houses
		houseList = new ArrayList<House>();
		houseList.add(new House(1130,800,1));
		houseList.add(new House(1400,800,2));
		houseList.add(new House(1030,950,3));
		houseList.add(new House(1350,1000,4));

		//villagers
		villagerList = new ArrayList<Villager>();
		villagerList.add(new Villager(900,900,1));
		villagerList.add(new Villager(1000,900,2));


		//JButton
		startButton = new JButton("START");
		startButton.setBounds(350,350,100,40);
		startButton.addActionListener(this);
		startButton.setVisible(true);
		add(startButton);


		//Images
		openingNarration1 = new ImageIcon("NarrationAssets/OpeningNarration1.png");
		openingNarration2 = new ImageIcon("NarrationAssets/OpeningNarration2.png");
		openingNarration3 = new ImageIcon("NarrationAssets/OpeningNarration3.png");
		openingNarration4 = new ImageIcon("NarrationAssets/OpeningNarration4.png");
		openingNarration5 = new ImageIcon("NarrationAssets/OpeningNarration5.png");
		openingNarration6 = new ImageIcon("NarrationAssets/OpeningNarration6.png");
		openingNarration7 = new ImageIcon("NarrationAssets/OpeningNarration7.png");
		openingNarration8 = new ImageIcon("NarrationAssets/OpeningNarration8.png");
		openingNarration9 = new ImageIcon("NarrationAssets/OpeningNarration9.png");
		openingNarration10 = new ImageIcon("NarrationAssets/OpeningNarration10.png");
		openingNarration11 = new ImageIcon("NarrationAssets/OpeningNarration11.png");
		openingNarration12 = new ImageIcon("NarrationAssets/OpeningNarration12.png");
		quest1Narration1 = new ImageIcon("NarrationAssets/Quest1Narration1.png");
		quest1Narration2 = new ImageIcon("NarrationAssets/Quest1Narration2.png");

		//sets keylistener
		setFocusable(true);
		setLayout(null);
        addKeyListener(this);
	}

	public Dimension getPreferredSize() {
		//Sets the size of the panel
        return new Dimension(800,600);
	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);

		if( gameLevel == 0 ){
			g.setColor(Color.BLACK);
			g.drawString("AdventureGame",350,275);
		} else {
			//ground
			g.setColor(groundGreen);
			g.fillRect(0, 0, 800, 600);
			g.setColor(groundBrown);
			g.fillOval(1050+xDiff,800+yDiff,625,450);
			g.fillOval(825+xDiff,890+yDiff,875,390);
			g.fillRect(1400+xDiff,1000+yDiff,250,280);

			//bounds box
			g.setColor(Color.BLACK);
			g.drawRect(xDiff,yDiff,1600,1200);

			//top tree bound
			for(int i = 0;i < 13;i ++){
				treeList.get(i).drawMeWithBush(g,xDiff,yDiff);
			}

			//houses
			for(int i = 0;i < houseList.size();i ++){
				houseList.get(i).drawMe(g,xDiff,yDiff);
			}

			//villagers
			for(int i = 0;i < villagerList.size();i ++){
				villagerList.get(i).drawMe(g,xDiff,yDiff);
			}

			//forest
			for(int i = 0;i < forestList.size();i ++){
				forestList.get(i).drawMe(g,xDiff,yDiff);
			}

			//draw rocks
			g.setColor(rockGray);
			g.fillArc(1195+xDiff,270+yDiff,150,100,0,180);

			//Draw player
			p1.drawMe(g);


			//bottom tree bound
			for(int i = 13;i < 26;i ++){
				treeList.get(i).drawMeWithBush(g,xDiff,yDiff);
			}

			//right and left tree bound
			for(int i = 26;i < 50;i ++){
				treeList.get(i).drawMe(g,xDiff,yDiff);
			}

			//draw groundItems
			for(int i = 0;i < groundItems.size();i ++){
				groundItems.get(i).drawMe(g,xDiff,yDiff);
			}

			//Draw inventory;
			int x = 0;
			int y = 0;
			for(int i = 0;i < inventoryItems.size();i ++){
				inventoryItems.get(i).drawInventoryItem(g,x,y);
				x += 75;
			}


			//narration
			showNarration(g);

		}
	}


	//implement methods of the KeyListener
	public void keyPressed(KeyEvent e) {

		//Movement of player
		if( gameLevel != 0 ){
			//going right is negative, going left is positive
			//going down is negative, going up is positive
			if( e.getKeyCode() == 39 && xDiff > -1195){ //right arrow
				xDiff -= 20;
				directionFacing = 1;
				if( walk == 1 ){
					walk = 2;
				} else {
					walk = 1;
				}
			} else if ( e.getKeyCode() == 37 && xDiff < 350){ //left arrow
				xDiff += 20;
				directionFacing = 2;
				if( walk == 1 ){
					walk = 2;
				} else {
					walk = 1;
				}
			} else if ( e.getKeyCode() == 38 && yDiff < 270){ //up arrow
				yDiff += 20;
				if( walk == 1 ){
					walk = 2;
				} else {
					walk = 1;
				}
			} else if ( e.getKeyCode() == 40 && yDiff > -830){ //down arrow
				yDiff -= 20;
				if( walk == 1 ){
					walk = 2;
				} else {
					walk = 1;
				}
			}
			p1.setWalk(walk);
			p1.setDirectionFacing(directionFacing);


			//narration
			if( e.getKeyCode() == 32 ){
				if( narrationGo && gameLevel == 1 ){
					switch(narrationSequence){
						case 2:
							narrationGo = false;
							break;
						case 5:
							narrationGo = false;
							break;
						case 6:
							narrationGo = false;
							break;
						case 12:
							narrationGo = false;
							gameLevel = 2;
							narrationSequence = 0;
							System.out.println(narrationSequence);
							break;
						default:
							break;
					}
					narrationSequence ++;
				} else if ( narrationGo && gameLevel == 2 ){
					switch(narrationSequence){
						case 2:
							narrationGo = false;
							break;
						default:
							break;
					}
					narrationSequence ++;
				}
			}
		}

		//Check collision between player and groundItems
		for(int i = 0;i < groundItems.size();i ++){
			if( p1.checkCollision(groundItems.get(i),xDiff,yDiff) ){
				if( groundItems.get(i).getType().equals("scroll") ){
					narrationGo = true;
				} else if ( groundItems.get(i).getType().equals("sword") && gameLevel == 2 ){
					narrationGo = true;
					System.out.println(narrationSequence);
					System.out.println(narrationGo);
					System.out.println(gameLevel);
				}
				inventoryItems.add(groundItems.get(i));
				groundItems.remove(i);
				i --;
			}
		}

		//Check screen collision
		if( gameLevel == 1 && !villagersFound ){
			for(int i = 0;i < villagerList.size();i ++){
				if( checkScreenCollision(villagerList.get(i)) ){
					narrationGo = true;
					villagersFound = true;
				}
			}
		}

		//Check collision between player and villagers
		if( gameLevel == 1 ){
			for(int i = 0;i < villagerList.size();i ++){
				if( p1.checkCollision(villagerList.get(i),xDiff,yDiff) ){
					narrationGo = true;
				}
			}
		}

		repaint();
	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}


	//implement methods of ActionListener
	public void actionPerformed(ActionEvent e) {
    	if( e.getSource() == startButton ){
			gameLevel = 1;
			startButton.setVisible(false);
		}


		repaint();
  	}


	//Check screen collision
	public boolean checkScreenCollision(Item item){
		int pX = 20;
		int pY = 20;
		int pWidth = 760;
		int pHeight = 560;

		int iX = item.getX() + xDiff;
		int iY = item.getY() + yDiff;
		int iWidth = item.getWidth();
		int iHeight = item.getHeight();

		if( pX+pWidth >= iX && pX <= iX + iWidth && pY + pHeight >= iY && pY <= iY + iHeight){
			return true;
		}
		return false;
	}

	//show narration
	public void showNarration(Graphics g){
		if( narrationGo && gameLevel == 1 ){
			switch( narrationSequence ){
				case 1:
					openingNarration1.paintIcon(null,g,225,237);
					break;
				case 2:
					openingNarration2.paintIcon(null,g,225,237);
					break;
				case 3:
					openingNarration3.paintIcon(null,g,225,237);
					break;
				case 4:
					openingNarration4.paintIcon(null,g,95,95);
					break;
				case 5:
					openingNarration5.paintIcon(null,g,225,237);
					break;
				case 6:
					openingNarration6.paintIcon(null,g,225,237);
					break;
				case 7:
					openingNarration7.paintIcon(null,g,920+xDiff,800+yDiff);
					break;
				case 8:
					openingNarration8.paintIcon(null,g,225,237);
					inventoryItems.remove(0);
					break;
				case 9:
					openingNarration9.paintIcon(null,g,920+xDiff,800+yDiff);
					break;
				case 10:
					openingNarration10.paintIcon(null,g,690+xDiff,800+yDiff);
					break;
				case 11:
					openingNarration11.paintIcon(null,g,690+xDiff,800+yDiff);
					break;
				case 12:
					openingNarration12.paintIcon(null,g,920+xDiff,800+yDiff);
					for(int i = 0;i < groundItems.size();i ++){
						if ( groundItems.get(i).getType().equals("sword") ){
							groundItems.get(i).setGameLevel(2);
						}
					}
					break;
				default:
					break;
			}
		} else if ( narrationGo && gameLevel == 2 ){
			switch( narrationSequence ){
				case 1:
					quest1Narration1.paintIcon(null,g,225,237);
					System.out.println("Hello again");
					break;
				case 2:
					quest1Narration2.paintIcon(null,g,225,237);
					break;
				default:
					break;
			}
		}
	}

}
