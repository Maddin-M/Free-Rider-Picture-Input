import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class FileAnalyzer
{
	File file;
	
	public static ArrayList<Integer> list;
	
	public static int width;
	public static int height;
	public static int pixels;
	
	public FileAnalyzer(File file)
	{
		this.file = file;
		
		BufferedImage bi = null;
		
		try {bi = ImageIO.read(file);}
		catch (IOException e) {e.printStackTrace();}
	    
//		AffineTransform tx = new AffineTransform();
//	    tx.rotate(Math.toRadians(90), bi.getWidth() / 2, bi.getHeight() / 2);
//	    AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_BILINEAR);
//	    bi = op.filter(bi, null);
	    
	    width = bi.getWidth();
	    height = bi.getHeight();
	    
	    pixels = width * height;
	    
	    list = new ArrayList<Integer>();
	    
	    int widthcount = 0;
		int heightcount = 0;
		
		boolean nextRow = false;
		
		for(int i = 0; i < pixels; i++)
		{
			if(nextRow)
			{
				heightcount = 0;
				widthcount++;
				nextRow = false;
			}
			
			int color = bi.getRGB(widthcount, heightcount);
			
			int red   = (color >>> 16) & 0xFF;
	    	int green = (color >>>  8) & 0xFF;
	    	int blue  = (color >>>  0) & 0xFF;
	    	
	    	float luminance = (red * 0.2126f + green * 0.7152f + blue * 0.0722f) / 255;

	    	if (luminance >= 0.7f)
	    	{
	    	    list.add(1);
	    	}
	    	else if (luminance <= 0.3f)
	    	{
	    		list.add(0);
	    	}
	    	else
	    	{
	    	    list.add(2);
	    	}
			
			if(heightcount < height)
			{
				heightcount++;
				if(heightcount == height)
				{
					nextRow = true;
				}
			}
		}
	}
}