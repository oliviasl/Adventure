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

import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Screen extends JPanel implements KeyListener, ActionListener {


	private Player p1;

	private int xDiff, yDiff;
	private int gameLevel;
	private int walk, directionFacing;
	private int narrationSequence;
	private int monsterTiming;
	private int fadeVar;
	private int fadeIncrement;
	private int fadeSequence;

	private boolean narrationGo, villagersFound, interactivePadGo;
	private boolean monsterGo, fadeGo, goblinGo, portalGo, fadeOutGo;
	private boolean showObjective;

	private ArrayList<Item> groundItems, inventoryItems;
	private ArrayList<Villager> villagerList;
	private ArrayList<Tree> treeList, forestList;
	private ArrayList<House> houseList;
	private ArrayList<Rock> rockList;

	private InteractivePad interactivePad;
	private Altar altar;
	private Portal portal;

	private JButton startButton, returnStartButton, controlsButton, backButton;

	private Color groundGreen, groundBrown, rockGray, lakeBlue;

	private ImageIcon openingNarration1, openingNarration2, openingNarration3;
	private ImageIcon openingNarration4, openingNarration5, openingNarration6;
	private ImageIcon openingNarration7, openingNarration8, openingNarration9;
	private ImageIcon openingNarration10, openingNarration11, openingNarration12;
	private ImageIcon quest1Narration1, quest1Narration2, quest1Narration3;
	private ImageIcon quest1Narration4, quest1Narration5, quest1Narration6;
	private ImageIcon quest1Narration7, quest1Narration8, quest1Narration9;
	private ImageIcon quest1Narration10, quest1Narration11, quest1Narration12;
	private ImageIcon quest2Narration1, quest2Narration2, quest2Narration3;
	private ImageIcon quest2Narration4, quest2Narration5, quest2Narration6;
	private ImageIcon quest2Narration7;
	private ImageIcon background;
	private ImageIcon waterDragon, waterSplash;
	private ImageIcon goblin, magicOrb;
	private ImageIcon title, endTitle;
	private ImageIcon controls, controls2, controlsTitle;
	private ImageIcon objective1, objective2, objective3, objective4;
	private ImageIcon objective5, objective6, objective7, objective8;
	private ImageIcon currentObjective;


	public Screen(){

		//sets up the instance variables
		p1 = new Player(350,270);
		xDiff = 0;
		yDiff = 0;
		gameLevel = 0;
		walk = 1;
		directionFacing = 1; //1 for right, 2 for left
		narrationSequence = 0;
		monsterTiming = 1;
		fadeVar = 255;
		fadeIncrement = 2;
		fadeSequence = 0;
		narrationGo = true;
		villagersFound = false;
		interactivePadGo = false;
		monsterGo = false;
		fadeGo = false;
		goblinGo = false;
		portalGo = false;
		fadeOutGo = false;
		showObjective = false;

		//Colors
		groundGreen = new Color(75,189,75);
		groundBrown = new Color(112,101,89);
		rockGray = new Color(153,153,153);
		lakeBlue = new Color(84,201,255);


		//array lists
		//ground items
		groundItems = new ArrayList<Item>();
		groundItems.add(new Scroll(485,250));
		groundItems.add(new Sword(1245,200));
		groundItems.add(new MagicOrb(1225,250));

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
		//bottom trees 13-21
		x = 520;
		for(int i = 0;i < 9;i ++){
			treeList.add(new Tree(x,1170));
			x += 130;
		}
		//right trees 22-33
		int y = -62;
		for(int i = 0;i < 12;i ++){
			treeList.add(new Tree(1630,y));
			y += 112;
		}
		//left trees 34-40
		y = -62;
		for(int i = 0;i < 7;i ++){
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

		//miscellaneous trees
		forestList.add(new Tree(575,75));
		forestList.add(new Tree(175,350));
		forestList.add(new Tree(640,140));
		forestList.add(new Tree(250,450));

		//out of bounds trees 41-67
		x = -300;
		y = -275;
		for(int i = 0;i < 10;i ++){
			treeList.add(new Tree(x,y));
			x += 250;
		}
		y = 1300;
		x = 700;
		for(int i = 0;i < 6;i ++){
			treeList.add(new Tree(x,y));
			x += 250;
		}
		y = -75;
		for(int i = 0;i < 4;i ++){
			treeList.add(new Tree(-300,y));
			y += 200;
		}
		y = -75;
		for(int i = 0;i < 7;i ++){
			treeList.add(new Tree(1950,y));
			y += 200;
		}




		//rock lake barrier
		rockList = new ArrayList<Rock>();
		x = -30;
		y = 700;
		for(int i = 0;i < 23;i ++){
			rockList.add(new Rock(x,y));
			x += 25;
			y += 25;
		}
		rockList.add(new Rock(-55,730));
		rockList.add(new Rock(-35,745));
		rockList.add(new Rock(-10,770));
		rockList.add(new Rock(440,1200));
		rockList.add(new Rock(470,1255));


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


		//InteractivePad
		interactivePad = new InteractivePad(300,900);

		//Altar
		altar = new Altar(100,100);

		//Portal
		portal = new Portal(200,-100);

		//JButtons
		startButton = new JButton("BEGIN");
		startButton.setBounds(350,350,100,40);
		startButton.addActionListener(this);
		startButton.setVisible(true);
		add(startButton);

		controlsButton = new JButton("CONTROLS");
		controlsButton.setBounds(350,410,100,40);
		controlsButton.addActionListener(this);
		controlsButton.setVisible(true);
		add(controlsButton);

		backButton = new JButton("BACK");
		backButton.setBounds(20,20,80,40);
		backButton.addActionListener(this);
		backButton.setVisible(false);
		add(backButton);

		returnStartButton = new JButton("RETURN TO START");
		returnStartButton.setBounds(300,350,200,40);
		returnStartButton.addActionListener(this);
		returnStartButton.setVisible(false);
		add(returnStartButton);


		//narration images
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
		quest1Narration3 = new ImageIcon("NarrationAssets/Quest1Narration3.png");
		quest1Narration4 = new ImageIcon("NarrationAssets/Quest1Narration4.png");
		quest1Narration5 = new ImageIcon("NarrationAssets/Quest1Narration5.png");
		quest1Narration6 = new ImageIcon("NarrationAssets/Quest1Narration6.png");
		quest1Narration7 = new ImageIcon("NarrationAssets/Quest1Narration7.png");
		quest1Narration8 = new ImageIcon("NarrationAssets/Quest1Narration8.png");
		quest1Narration9 = new ImageIcon("NarrationAssets/Quest1Narration9.png");
		quest1Narration10 = new ImageIcon("NarrationAssets/Quest1Narration10.png");
		quest1Narration11 = new ImageIcon("NarrationAssets/Quest1Narration11.png");
		quest1Narration12 = new ImageIcon("NarrationAssets/Quest1Narration12.png");
		quest2Narration1 = new ImageIcon("NarrationAssets/Quest2Narration1.png");
		quest2Narration2 = new ImageIcon("NarrationAssets/Quest2Narration2.png");
		quest2Narration3 = new ImageIcon("NarrationAssets/Quest2Narration3.png");
		quest2Narration4 = new ImageIcon("NarrationAssets/Quest2Narration4.png");
		quest2Narration5 = new ImageIcon("NarrationAssets/Quest2Narration5.png");
		quest2Narration6 = new ImageIcon("NarrationAssets/Quest2Narration6.png");
		quest2Narration7 = new ImageIcon("NarrationAssets/Quest2Narration7.png");

		//objectives
		objective1 = new ImageIcon("ObjectiveAssets/Objective1.png");
		objective2 = new ImageIcon("ObjectiveAssets/Objective2.png");
		objective3 = new ImageIcon("ObjectiveAssets/Objective3.png");
		objective4 = new ImageIcon("ObjectiveAssets/Objective4.png");
		objective5 = new ImageIcon("ObjectiveAssets/Objective5.png");
		objective6 = new ImageIcon("ObjectiveAssets/Objective6.png");
		objective7 = new ImageIcon("ObjectiveAssets/Objective7.png");
		objective8 = new ImageIcon("ObjectiveAssets/Objective8.png");
		currentObjective = objective1;

		//other images
		background = new ImageIcon("ImageAssets/Background.png");
		waterDragon = new ImageIcon("ImageAssets/WaterDragon.png");
		waterSplash = new ImageIcon("ImageAssets/WaterSplash.png");
		goblin = new ImageIcon("ImageAssets/Goblin.png");
		magicOrb = new ImageIcon("ImageAssets/MagicOrb.png");
		title = new ImageIcon("ImageAssets/Title.png");
		endTitle = new ImageIcon("ImageAssets/EndTitle.png");
		controls = new ImageIcon("ImageAssets/Controls.png");
		controls2 = new ImageIcon("ImageAssets/Controls2.png");
		controlsTitle = new ImageIcon("ImageAssets/ControlsTitle.png");


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
			g.fillRect(0,0,800,600);
			title.paintIcon(null,g,75,175);
		} else if ( gameLevel >= 1 && gameLevel <= 3 ){
			//ground
			background.paintIcon(null,g,-400+xDiff,-400+yDiff);
			g.setColor(groundBrown);
			g.fillOval(1050+xDiff,800+yDiff,625,450);
			g.fillOval(825+xDiff,890+yDiff,875,390);
			g.fillRect(1400+xDiff,1000+yDiff,250,280);


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

			//draw rocks
			//sword rock
			g.setColor(rockGray);
			g.fillArc(1195+xDiff,270+yDiff,150,100,0,180);
			//lower rock path
			g.fillArc(290+xDiff,490+yDiff,75,60,0,180);
			g.fillArc(350+xDiff,550+yDiff,75,60,0,180);
			g.fillArc(425+xDiff,650+yDiff,75,60,0,180);
			g.fillArc(510+xDiff,715+yDiff,75,60,0,180);
			g.fillArc(560+xDiff,785+yDiff,75,60,0,180);
			g.fillArc(610+xDiff,870+yDiff,75,60,0,180);
			g.fillArc(690+xDiff,965+yDiff,75,60,0,180);
			//upper rock path
			g.fillArc(550+xDiff,300+yDiff,75,60,0,180);
			g.fillArc(615+xDiff,375+yDiff,75,60,0,180);
			g.fillArc(675+xDiff,480+yDiff,75,60,0,180);
			g.fillArc(735+xDiff,555+yDiff,75,60,0,180);
			g.fillArc(800+xDiff,645+yDiff,75,60,0,180);
			g.fillArc(870+xDiff,700+yDiff,75,60,0,180);
			g.fillArc(895+xDiff,750+yDiff,75,60,0,180);
			g.fillArc(970+xDiff,825+yDiff,75,60,0,180);


			//Altar
			altar.drawMe(g,xDiff,yDiff);


			//forest and miscellaneous trees
			for(int i = 0;i < forestList.size();i ++){
				forestList.get(i).drawMe(g,xDiff,yDiff);
			}


			//lake
			g.setColor(lakeBlue);
			g.fillArc(-1400+xDiff,700+yDiff,1925,1700,0,90);

			//interactivePad
			if( interactivePadGo ){
				interactivePad.drawMe(g,xDiff,yDiff);
			}


			//draw groundItems
			for(int i = 0;i < groundItems.size();i ++){
				groundItems.get(i).drawMe(g,xDiff,yDiff);
			}


			//goblin
			if( goblinGo ){
				goblin.paintIcon(null,g,1250+xDiff,200+yDiff);
			}

			//portal
			if( portalGo ){
				portal.drawMe(g,xDiff,yDiff);
			}

			//Draw player
			p1.drawMe(g);


			//rock lake barrier
			for(int i = 0;i < rockList.size();i ++){
				rockList.get(i).drawMe(g,xDiff,yDiff);
			}


			//bottom tree bound
			for(int i = 13;i < 22;i ++){
				treeList.get(i).drawMeWithBush(g,xDiff,yDiff);
			}


			//right and left tree bound
			for(int i = 22;i < 41;i ++){
				treeList.get(i).drawMe(g,xDiff,yDiff);
			}

			//out of bounds trees
			for(int i = 41;i < 68;i ++){
				treeList.get(i).drawMe(g,xDiff,yDiff);
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


			//quest number
			g.setColor(Color.black);
			if( gameLevel == 1 ){
				g.drawString("Quest: 0",725,20);
			} else if ( gameLevel == 2 ){
				g.drawString("Quest: 1",725,20);
			} else if ( gameLevel == 3 ){
				g.drawString("Quest: 2",725,20);
			}


			//show objective
			if( showObjective ){
				currentObjective.paintIcon(null,g,225,212);
			}


			//fade
			if( fadeGo ){
				g.setColor(new Color(0,0,0,fadeVar));
				g.fillRect(0,0,800,600);
			}

		} else if ( gameLevel == 4 ){
			g.setColor(Color.black);
			g.fillRect(0,0,800,600);
			endTitle.paintIcon(null,g,150,150);
		} else if ( gameLevel == -1 ){
			g.setColor(Color.black);
			g.fillRect(0,0,800,600);
			controls.paintIcon(null,g,50,200);
			controls2.paintIcon(null,g,50,403);
			controlsTitle.paintIcon(null,g,150,65);
			interactivePad.drawMe(g,xDiff,yDiff);
		}

		//fade out
		if( fadeOutGo ){
			g.setColor(new Color(255,255,255,fadeVar));
			g.fillRect(0,0,800,600);
		}
	}


	//implement methods of the KeyListener
	public void keyPressed(KeyEvent e) {

		//Movement of player
		if( gameLevel >= 1 && gameLevel <= 3 ){

			//show objective
			if( e.getKeyCode() == 81 ){ //q
				if( showObjective ){
					showObjective = false;
				} else {
					showObjective = true;
				}
			}


			//check if touching rock barrier
			boolean rockBarrier = false;
			for(int i = 0;i < rockList.size();i ++){
				if( p1.checkCollision(rockList.get(i),xDiff,yDiff) ){
					rockBarrier = true;
				}
			}

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
			} else if ( e.getKeyCode() == 37 && xDiff < 350 && !rockBarrier ){ //left arrow
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
			} else if ( e.getKeyCode() == 40 && yDiff > -830 && !rockBarrier ){ //down arrow
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
			//increments narrationSequence after setting narrationGo to false
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
							break;
						default:
							break;
					}
					narrationSequence ++;
				} else if ( narrationGo && gameLevel == 2 ){
					switch(narrationSequence){
						case 2:
							interactivePadGo = true;
							narrationGo = false;
							break;
						case 4:
							playSound("Splash");
							break;
						case 8:
							narrationGo = false;
							break;
						case 14:
							narrationGo = false;
							gameLevel = 3;
							narrationSequence = 0;
							interactivePad.setX(1150);
							interactivePad.setY(370);
							interactivePadGo = true;
							monsterGo = false;
							goblinGo = true;
							break;
						default:
							break;
					}
					narrationSequence ++;
				} else if ( narrationGo && gameLevel == 3 ){
					switch(narrationSequence){
						case 3:
							fadeGo = true;
							break;
						case 5:
							narrationGo = false;
							break;
						case 7:
							narrationGo = false;
							break;
						case 8:
							fadeGo = true;
							break;
						case 9:
							narrationGo = false;
							break;
						default:
							break;
					}
					narrationSequence ++;
				}
			}


			//cheat key
			if( e.getKeyCode() == 80 && !fadeGo && !fadeOutGo ){ //p
				if( gameLevel == 1 ){ //pass quest 0
					//remove scroll
					for(int i = 0;i < groundItems.size();i ++){
						if( groundItems.get(i).getType().equals("scroll") ){
							groundItems.remove(i);
							i --;
						}
					}
					for(int i = 0;i < inventoryItems.size();i ++){
						if( inventoryItems.get(i).getType().equals("scroll") ){
							inventoryItems.remove(i);
							i --;
						}
					}

					//set sword
					for(int i = 0;i < groundItems.size();i ++){
						if( groundItems.get(i).getType().equals("sword") ){
							groundItems.get(i).setGameLevel(2);
						}
					}

					//reset narration sequence
					narrationGo = false;
					gameLevel = 2;
					narrationSequence = 1;
					currentObjective = objective3;
				} else if ( gameLevel == 2 ){ //pass quest 1
					//add sword to inventory
					for(int i = 0;i < groundItems.size();i ++){
						if( groundItems.get(i).getType().equals("sword") ){
							groundItems.remove(i);
							i --;
						}
					}
					for(int i = 0;i < inventoryItems.size();i ++){
						inventoryItems.remove(i);
						i --;
					}
					inventoryItems.add(new Sword(1250,200));
					inventoryItems.get(0).setGameLevel(3);

					//set magicOrb and interactivePad
					for(int i = 0;i < groundItems.size();i ++){
						if( groundItems.get(i).getType().equals("magicorb") ){
							groundItems.get(i).setGameLevel(3);
						}
					}

					//reset narration sequence
					narrationGo = false;
					gameLevel = 3;
					narrationSequence = 1;
					interactivePad.setX(1150);
					interactivePad.setY(370);
					interactivePadGo = true;
					monsterGo = false;
					goblinGo = true;
					currentObjective = objective6;
				} else if ( gameLevel == 3 ){ //pass quest 2
					gameLevel = 4;
					returnStartButton.setVisible(true);
				}
			}

			//Check collision between player and groundItems
			for(int i = 0;i < groundItems.size();i ++){
				if( p1.checkCollision(groundItems.get(i),xDiff,yDiff) ){
					if( groundItems.get(i).getType().equals("scroll") ){
						narrationGo = true;
						inventoryItems.add(groundItems.get(i));
						groundItems.remove(i);
						i --;
						playSound("Item");
					} else if ( groundItems.get(i).getType().equals("sword") && gameLevel == 2 ){
						narrationGo = true;
						inventoryItems.add(groundItems.get(i));
						groundItems.remove(i);
						i --;
						playSound("Item");
					} else if ( groundItems.get(i).getType().equals("magicorb") && gameLevel == 3 && narrationSequence > 4 ){
						narrationGo = true;
						inventoryItems.add(groundItems.get(i));
						groundItems.remove(i);
						playSound("Item");
					}
				}
			}


			//Check screen collision
			if( gameLevel == 1 && !villagersFound && narrationSequence == 6){
				for(int i = 0;i < villagerList.size();i ++){
					if( checkScreenCollision(villagerList.get(i)) ){
						narrationGo = true;
						villagersFound = true;
					}
				}
			}

			//Check collision between player and villagers
			if( gameLevel == 1 && villagersFound){
				for(int i = 0;i < villagerList.size();i ++){
					if( p1.checkCollision(villagerList.get(i),xDiff,yDiff) ){
						narrationGo = true;
					}
				}
			} else if ( gameLevel == 2  && monsterGo && narrationSequence == 9 ){
				for(int i = 0;i < villagerList.size();i ++){
					if( p1.checkCollision(villagerList.get(i),xDiff,yDiff) ){
						narrationGo = true;
					}
				}
			}

			//Check collision between player and interactivePad
			if( gameLevel == 2 && interactivePadGo ){
				if( p1.checkCollision(interactivePad,xDiff,yDiff) ){
					narrationGo = true;
					monsterGo = true;
				}
			} else if ( gameLevel == 3 && interactivePadGo ){
				if( p1.checkCollision(interactivePad,xDiff,yDiff) ){
					narrationGo = true;
				}
			}

			//Check collision between player and altar
			if( inventoryItems.size() > 0 ){
				if( inventoryItems.get(0).getType().equals("magicorb") ){
					if( p1.checkCollision(altar,xDiff,yDiff) ){
						narrationGo = true;
						groundItems.add(inventoryItems.get(0));
						inventoryItems.remove(0);
						groundItems.get(0).setX(128);
						groundItems.get(0).setY(55);
						fadeGo = true;
					}
				}
			}


			//Check collision between player and portal;
			if( portalGo && p1.checkCollision(portal,xDiff,yDiff) ){
				fadeOutGo = true;
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
			controlsButton.setVisible(false);
			fadeGo = true;
		} else if ( e.getSource() == controlsButton ){
			gameLevel = -1;
			startButton.setVisible(false);
			controlsButton.setVisible(false);
			backButton.setVisible(true);
			interactivePadGo = true;
			interactivePad.setX(362);
			interactivePad.setY(447);
		} else if ( e.getSource() == backButton ){
			startButton.setVisible(true);
			controlsButton.setVisible(true);
			backButton.setVisible(false);
			gameLevel = 0;
			interactivePad.setX(300);
			interactivePad.setY(900);
			interactivePadGo = false;
		} else if ( e.getSource() == returnStartButton ){
			gameLevel = 0;
			startButton.setVisible(true);
			controlsButton.setVisible(true);
			returnStartButton.setVisible(false);

			//reset all variables
			//sets up the instance variables
			p1 = new Player(350,270);
			xDiff = 0;
			yDiff = 0;
			gameLevel = 0;
			walk = 1;
			directionFacing = 1; //1 for right, 2 for left
			narrationSequence = 0;
			monsterTiming = 1;
			fadeVar = 255;
			fadeIncrement = 2;
			fadeSequence = 0;
			narrationGo = true;
			villagersFound = false;
			interactivePadGo = false;
			monsterGo = false;
			fadeGo = false;
			goblinGo = false;
			portalGo = false;
			fadeOutGo = false;
			showObjective = false;
			currentObjective = objective1;

			//reset items
			for(int i = 0;i < groundItems.size();i ++){
				groundItems.remove(i);
				i --;
			}
			groundItems.add(new Scroll(485,250));
			groundItems.add(new Sword(1245,200));
			groundItems.add(new MagicOrb(1225,250));
			for(int i = 0;i < inventoryItems.size();i ++){
				inventoryItems.remove(i);
				i --;
			}

			//reset interactivePad
			interactivePad.setX(300);
			interactivePad.setY(900);
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
					currentObjective = objective2;
					break;
				case 6:
					openingNarration6.paintIcon(null,g,225,237);
					break;
				case 7:
					openingNarration7.paintIcon(null,g,920+xDiff,800+yDiff);
					break;
				case 8:
					openingNarration8.paintIcon(null,g,225,237);
					if( inventoryItems.size() > 0 ){
						inventoryItems.remove(0);
					}
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
					//set game level of sword to 2
					for(int i = 0;i < groundItems.size();i ++){
						if ( groundItems.get(i).getType().equals("sword") ){
							groundItems.get(i).setGameLevel(2);
						}
					}
					currentObjective = objective3;
					break;
				default:
					break;
			}
		} else if ( narrationGo && gameLevel == 2 ){
			switch( narrationSequence ){
				case 1:
					quest1Narration1.paintIcon(null,g,225,237);
					break;
				case 2:
					quest1Narration2.paintIcon(null,g,225,237);
					currentObjective = objective4;
					break;
				case 3:
					waterDragon.paintIcon(null,g,50+xDiff,800+yDiff);
					quest1Narration3.paintIcon(null,g,225,237);
					interactivePadGo = false;
					break;
				case 4:
					waterDragon.paintIcon(null,g,50+xDiff,800+yDiff);
					quest1Narration4.paintIcon(null,g,225,237);
					break;
				case 5:
					waterDragon.paintIcon(null,g,50+xDiff,800+yDiff);
					break;
				case 6:
					waterSplash.paintIcon(null,g,50+xDiff,900+yDiff);
					break;
				case 7:
					quest1Narration5.paintIcon(null,g,225,237);
					break;
				case 8:
					quest1Narration6.paintIcon(null,g,225,237);
					currentObjective = objective5;
					break;
				case 9:
					quest1Narration7.paintIcon(null,g,690+xDiff,800+yDiff);
					break;
				case 10:
					quest1Narration8.paintIcon(null,g,920+xDiff,800+yDiff);
					break;
				case 11:
					quest1Narration9.paintIcon(null,g,920+xDiff,800+yDiff);
					break;
				case 12:
					quest1Narration10.paintIcon(null,g,920+xDiff,800+yDiff);
					break;
				case 13:
					quest1Narration11.paintIcon(null,g,920+xDiff,800+yDiff);
					break;
				case 14:
					quest1Narration12.paintIcon(null,g,920+xDiff,800+yDiff);
					//set game level of magicOrb to 3
					for(int i = 0;i < groundItems.size();i ++){
						if ( groundItems.get(i).getType().equals("magicorb") ){
							groundItems.get(i).setGameLevel(3);
						}
					}
					currentObjective = objective6;
					break;
				default:
					break;
			}
		} else if ( narrationGo && gameLevel == 3 ){
			switch( narrationSequence ){
				case 1:
					quest2Narration1.paintIcon(null,g,225,237);
					interactivePadGo = false;
					break;
				case 2:
					quest2Narration2.paintIcon(null,g,225,237);
					break;
				case 3:
					quest2Narration3.paintIcon(null,g,225,237);
					break;
				case 5:
					quest2Narration4.paintIcon(null,g,225,237);
					break;
				case 6:
					quest2Narration5.paintIcon(null,g,225,237);
					break;
				case 7:
					quest2Narration6.paintIcon(null,g,225,237);
					currentObjective = objective7;
					break;
				case 9:
					quest2Narration7.paintIcon(null,g,225,237);
					currentObjective = objective8;
				default:
					break;
			}
		}
	}


	//animation
	public void animate(){
		while( true ){

			//pulse color of interative pad
			if( interactivePadGo ){
				interactivePad.changeColor();
			}


			//monster sequence timing
			if( monsterGo && (narrationSequence == 5 || narrationSequence == 6) ){
				if( monsterTiming == 100 ){
					narrationSequence ++;
					monsterTiming = 0;
					if( narrationSequence == 7 ){
						playSound("Victory");
					}
				} else {
					monsterTiming ++;
				}
			}


			//fade animation timing
			if( fadeGo ){
				if( fadeVar >= 255 ){
					fadeIncrement = -2;
					if( fadeSequence == 1 ){
						goblinGo = false;
						playSound("Walk");
						for(int i = 0;i < inventoryItems.size();i ++){
							if ( inventoryItems.get(i).getType().equals("sword") ){
								inventoryItems.remove(i);
							}
						}
					} else if ( fadeSequence == 2 ){
						portalGo = true;
					}
				}
				fadeVar += fadeIncrement;
				if( fadeVar <= 0 ){
					fadeGo = false;
					narrationSequence ++;
					narrationGo = true;
					fadeIncrement = 2;
					fadeVar = 1;
					fadeSequence ++;
				}
			}


			//fade out timing
			if( fadeOutGo ){
				if( fadeVar >= 255 ){
					gameLevel = 4;
					returnStartButton.setVisible(true);
					fadeIncrement = -2;
					playSound("portal");
				}
				fadeVar += fadeIncrement;
				if( fadeVar <= 0 ){
					fadeOutGo = false;
					fadeIncrement = 2;
					fadeVar = 1;
				}

			}

			//slow it down and repaint
			try{
				Thread.sleep(10);//milliseconds
			}catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}

			repaint();

		}
	}


	//sounds
	public void playSound(String filepath) {

	   try {
		   URL url = this.getClass().getClassLoader().getResource("SoundAssets/" + filepath + ".wav");
		   Clip clip = AudioSystem.getClip();
		   clip.open(AudioSystem.getAudioInputStream(url));
		   clip.start();
	   } catch (Exception exc) {
		   exc.printStackTrace(System.out);
	   }
   }

}
