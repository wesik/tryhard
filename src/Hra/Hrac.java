package Hra;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Hrac {
	public static final int SIRKA = 40;  //��rka a v��ka hr��e
	public static final int VYSKA = 33;
	
	//velikost skoku hrace
	private static final int KOEF_ZRYCHLENI = 1;	
	//rychlost padu hrace
	private static final int KOEF_RYCHLOST = 2;
	
	private BufferedImage img = null; //Buffered se nevymazava pri minimalizaci nap�
	
	//pocatecni x-ova pozice hrace, nemeni se(hrac neskace horizontalne)
	private int x;	
	// ppocatecni y-ova pozice hrace se meni (vertikalne nahoru dolu)
	private int y;
	private int rychlost;
	
	//konstruktor
	public Hrac(BufferedImage img){
		this.img = img;
		x = (HraciPlocha.SIRKA / 2) - (img.getWidth()/2);
		y = HraciPlocha.VYSKA/2;
		
		rychlost = KOEF_RYCHLOST;
	}
	
	//VOLA SE PO NARAZU do zdi, do kraje okna
	
	public void reset(){
		y= HraciPlocha.VYSKA/2;
		rychlost = KOEF_RYCHLOST;
		
		
}
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	
	public void skok(){
		rychlost = -17; //zaporny proto�e vlevo nahore je 0,0 souradnice
	}
	
	// zajistuje pohyb hrace
	public void posun(){
		rychlost = rychlost + KOEF_ZRYCHLENI;
		y = y + rychlost;
	}
	
	public void paint(Graphics g){
		g.drawImage(img, x,y,null);
	}
	
	public int getVyskaHrace(){
		return img.getHeight();
	}
	
	// vraci pomyslny ctverec/obdelnik, ktery opisuje hrace
	
	public Rectangle getMez(){
		return new Rectangle(x, y, img.getWidth(), img.getHeight());
	}
}
