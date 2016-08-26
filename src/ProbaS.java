import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ProbaS {

	byte []barr;
	byte []barr9;
	byte []btmparr = new byte[9];
	byte []maskarr = {5,2,8,7,1,6,3,0,4};

	                       
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ProbaS obj = new ProbaS();
		
		/*
		//obj.openImage("D:\\tmp\\37_Levitan.bmp");
		obj.openImage("D:\\tmp\\32_Brullov.bmp");
		obj.rotate();
		obj.saveArr("D:\\tmp\\Lout.bmp");
		 */
		
		
		obj.openImageR("D:\\tmp\\Lout.bmp");
		obj.derotate();
		//obj.saveArrContol("D:\\tmp\\37_Levitan2.bmp");
		obj.saveArrContol("D:\\tmp\\32_Brullov2.bmp");
		
		
		System.out.println("***  Finish!  ***");
		
	}

	void openImage(String strFileName) throws IOException{
		
		File ff = new File(strFileName);
		BufferedImage image = ImageIO.read(ff);
		
		DataInputStream in = new DataInputStream( new FileInputStream(strFileName));
		long size = ff.length();
		int mod = (int) (size%9);
		
		
		barr = new byte[(int)size + mod + 9 - 1];
		
		int ind = 0;
		while(in.available()>0){
			
			barr[ind] = in.readByte();
			ind++;
			
		}
		ind = 0;
	}
	
	void saveArr(String strFileName) throws IOException{
		
		DataOutputStream out = new DataOutputStream( new FileOutputStream(strFileName));
		
		for(int ind = 0; ind<barr.length; ind++){
			
			out.writeByte(barr[ind]);
			
		}
	}
	
	void rotate(){
		
		int nIter = barr.length/9 - 1;
		
		for(int ind = 0; ind<nIter; ind++){
			System.arraycopy(barr, ind*9, btmparr, 0, 9);
			rotate9(ind*9);
		}
		
		System.arraycopy(maskarr, 0, barr, barr.length-9, 9);
		
		
	}
	
	void rotate9(int pos){
		
		
		for(int ind = 0; ind<9; ind++){
			
			barr[pos+maskarr[ind]] = btmparr[ind];
			
		}
		
	}
	
	void openImageR(String strFileName) throws IOException{
		
		File ff = new File(strFileName);
		BufferedImage image = ImageIO.read(ff);
		
		DataInputStream in = new DataInputStream( new FileInputStream(strFileName));
		long size = ff.length();
		
		
		barr = new byte[(int)size];
		
		int ind = 0;
		while(in.available()>0){
			
			barr[ind] = in.readByte();
			ind++;
			
		}
		ind = 0;
	}


	void derotate(){
		
		int nIter = barr.length/9 - 1;
		
		System.arraycopy(barr, barr.length-9, maskarr, 0, 9);
		
		for(int ind = 0; ind<nIter; ind++){
			System.arraycopy(barr, ind*9, btmparr, 0, 9);
			derotate9(ind*9);
		}
	}
	void derotate9(int pos){
		
		
		for(int ind = 0; ind<9; ind++){
			
			//barr[pos+maskarr[ind]] = btmparr[ind];
			barr[pos+ind] = btmparr[maskarr[ind]];
			
		}
		
	}	
	
	void saveArrContol(String strFileName) throws IOException{
		
		DataOutputStream out = new DataOutputStream( new FileOutputStream(strFileName));
		
		for(int ind = 0; ind<barr.length-9; ind++){
			
			out.writeByte(barr[ind]);
			
		}
	}
	
}
