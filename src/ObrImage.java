import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ObrImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ObrImage obj = new ObrImage();
		obj.obrezka(200, 200, 650, 650);
	}

	void obrezka(int x1, int y1, int x2, int y2){
		
		System.out.println("obrezka");
		
		try {
			BufferedImage image = ImageIO.read(new File("D:\\tmp\\atenza_01.png"));
			image = image.getSubimage(x1, y1, x2, y2) ;
			
			
			ImageIO.write(image, "png", new File("D:\\tmp\\atenza_02.png"));
			
			System.out.println("obrezka finish");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
