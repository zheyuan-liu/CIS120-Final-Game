
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Explosion extends Bubble {
	
	public static final String img_file = "Flame/Flame_f00.png";
	private int duration = 100;

	//public Character character;
	private static BufferedImage img;
	
	public Explosion
		(int courtWidth, int courtHeight, int center_x, int center_y){
		
	
		super(courtWidth, courtHeight, center_x, center_y);
		try {
			if (img == null) {
				img = ImageIO.read(new File(img_file));
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
	
	@Override
	public void draw(Graphics g){
		int img_x = pos_x + (OBJ_WIDTH - IMG_WIDTH) / 2;
		int img_y = pos_y + (OBJ_HEIGHT - IMG_HEIGHT) / 2;
		g.drawImage(img, img_x, img_y, IMG_WIDTH, IMG_HEIGHT, null); 
		
	}
	
	@Override
	public void countdown(){
		this.duration -= 1;
	}
	
	@Override
	public int getDuration(){
		return this.duration;
	}
	

}
