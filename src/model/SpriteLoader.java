package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class SpriteLoader {
	private volatile static ArrayList<Image> sol =null;
	private volatile static ArrayList<Image> wall =null;
	private volatile static ArrayList<Image> piece =null;
	private volatile static Image knight =null;
	private volatile static Image piegeOurs =null;
	private volatile static Image bump=null;
	private volatile static Image teleport=null;
	private volatile static Image teleport2=null;
	private volatile static Image squelette=null;
	private volatile static Image squelettedead=null;
	private volatile static Image fantome=null;
	private volatile static Image fantomedead=null;
	
	
	public static Image getSol(int id) {
		if(sol==null) {
			try {
				sol=new ArrayList<Image>();
				sol.add(ImageIO.read(new File("sol.jpg")));
				sol.add(ImageIO.read(new File("solskull.png")));
				sol.add(ImageIO.read(new File("soltoile.png")));
				sol.add(ImageIO.read(new File("solfire.png")));
				sol.add(ImageIO.read(new File("solstone.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		switch(id) {
			case 1:
				return sol.get(1);
			case 2:
				return sol.get(2);
			case 3:
				return sol.get(3);
			case 4:
				return sol.get(4);
			default:
				return sol.get(0);	
		}
	}
	
	public static Image getWall(int id) {
		if(wall==null) {
			try {
				wall=new ArrayList<Image>();
				for(int i=1;i<16;i++) {
					wall.add( ImageIO.read(new File("wall"+i+".png")));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return wall.get(id);
	}
	public static Image getPieces(int id) {
		if(piece==null) {
			try {
				piece=new ArrayList<Image>();
				for(int i=1;i<7;i++) {
					piece.add( ImageIO.read(new File("tresor"+i+".png")));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return piece.get(id);
	}

	public static Image getknight() {
		if(knight==null) {
			try {
				knight= ImageIO.read(new File("knight.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return knight;
	}
	
	public static Image getPiegeOurs() {
		if(piegeOurs==null) {
			try {
				piegeOurs= ImageIO.read(new File("piegeOurs.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return piegeOurs;
	}
	public static Image getBump() {
		if(bump==null) {
			try {
				bump= ImageIO.read(new File("bump.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bump;
	}
	public static Image getTeleport() {
		if(teleport==null) {
			try {
				teleport= ImageIO.read(new File("teleport.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return teleport;
	}
	
	public static Image getTeleport2() {
		if(teleport2==null) {
			try {
				teleport2= ImageIO.read(new File("teleport2.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return teleport2;
	}
	public static Image getSquelette() {
		if(squelette==null) {
			try {
				squelette= ImageIO.read(new File("squelette.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return squelette;
	}
	
	public static Image getSquelettedead() {
		if(squelettedead==null) {
			try {
				squelettedead= ImageIO.read(new File("squelette2.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return squelettedead;
	}
	
	public static Image getFantome() {
		if(fantome==null) {
			try {
				fantome= ImageIO.read(new File("fantome.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fantome;
	}
	
	public static Image getFantomedead() {
		if(fantomedead==null) {
			try {
				fantomedead= ImageIO.read(new File("fantomedead.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fantomedead;
	}
	
	
}