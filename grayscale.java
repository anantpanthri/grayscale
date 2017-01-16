import java.io.File;

import edu.duke.*;
public class GrayScale {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DirectoryResource dr= new DirectoryResource();
		for(File f:dr.selectedFiles()){
			// This algorithm will draw and select files in gray scale.
			System.out.println(f);
			System.out.println(f.getPath());
			ImageResource ir = new ImageResource(f);
			ir.getFileName();
			ImageResource outImage= new ImageResource(ir.getWidth(),ir.getHeight());
			for(Pixel px:outImage.pixels()){
				Pixel p=ir.getPixel(px.getX(), px.getY());
				int avg=(p.getRed()+p.getBlue()+p.getGreen())/3;
				px.setRed(avg);
				px.setBlue(avg);
				px.setGreen(avg);
				outImage.setPixel(px.getX(), px.getY(), px);
			}
			
			outImage.draw();
			
		}
	}

}
