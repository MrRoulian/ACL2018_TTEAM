package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class SpriteLoader {
	private static final String SPRITE_ROUTE = "Sprites/";
	
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
				sol.add( ImageIO.read(new File(SPRITE_ROUTE + "Sol/Sol.png")));
				sol.add( ImageIO.read(new File(SPRITE_ROUTE + "Sol/solfire.png")));
				sol.add( ImageIO.read(new File(SPRITE_ROUTE + "Sol/solskull.png")));
				sol.add( ImageIO.read(new File(SPRITE_ROUTE + "Sol/soltoile.png")));
				sol.add( ImageIO.read(new File(SPRITE_ROUTE + "Sol/solstone.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		return sol.get(id);
	}

	public static Image getWall(int id) {
		if(wall==null) {
			try {
				wall=new ArrayList<Image>();
				BufferedImage source = ImageIO.read(new File(SPRITE_ROUTE + "Mur/Mur.png"));
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 8; j++) {
						wall.add(source.getSubimage(j*32, i*32, 32, 32));
					}
				}
			} catch (IOException e) {
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
					piece.add( ImageIO.read(new File(SPRITE_ROUTE + "tresor"+i+".png")));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return piece.get(id);
	}

	public static Image getknight() {
		if(knight==null) {
			try {
				knight= ImageIO.read(new File(SPRITE_ROUTE + "knight.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return knight;
	}
	
	public static Image getPiegeOurs() {
		if(piegeOurs==null) {
			try {
				piegeOurs= ImageIO.read(new File(SPRITE_ROUTE + "piegeOurs.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return piegeOurs;
	}
	public static Image getBump() {
		if(bump==null) {
			try {
				bump= ImageIO.read(new File(SPRITE_ROUTE + "bump.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bump;
	}
	public static Image getTeleport() {
		if(teleport==null) {
			try {
				teleport= ImageIO.read(new File(SPRITE_ROUTE + "teleport.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return teleport;
	}
	
	public static Image getTeleport2() {
		if(teleport2==null) {
			try {
				teleport2= ImageIO.read(new File(SPRITE_ROUTE + "teleport2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return teleport2;
	}
	public static Image getSquelette() {
		if(squelette==null) {
			try {
				squelette= ImageIO.read(new File(SPRITE_ROUTE + "squelette.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return squelette;
	}
	
	public static Image getSquelettedead() {
		if(squelettedead==null) {
			try {
				squelettedead= ImageIO.read(new File(SPRITE_ROUTE + "squelette2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return squelettedead;
	}
	
	public static Image getFantome() {
		if(fantome==null) {
			try {
				fantome= ImageIO.read(new File(SPRITE_ROUTE + "fantome.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fantome;
	}
	
	public static Image getFantomedead() {
		if(fantomedead==null) {
			try {
				fantomedead= ImageIO.read(new File(SPRITE_ROUTE + "fantomedead.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fantomedead;
	}
	
}