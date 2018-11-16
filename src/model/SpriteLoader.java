package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class SpriteLoader {
	
	private volatile static Image sol =null;
	private volatile static Image wall =null;
	private volatile static ArrayList<Image> piece =null;
	private volatile static Image knight =null;
	
	public static Image getSol() {
		if(sol==null) {
			try {
				sol= ImageIO.read(new File("sol.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sol;
	}
	
	public static Image getWall() {
		if(wall==null) {
			try {
				wall= ImageIO.read(new File("wall.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return wall;
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
}
