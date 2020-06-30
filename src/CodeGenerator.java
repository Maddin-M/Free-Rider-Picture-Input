import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class CodeGenerator
{
	int x;
	int y;
	
	public CodeGenerator(int x, int y)
	{
		this.x = x;
		this.y = y;
		
		String blackcode = "";
		String greycode = "";
		
		int width = 0;
		int height = 0;
		
		boolean nextRow = false;
		
		for(int i = 0; i < FileAnalyzer.pixels; i++)
		{
			if(nextRow)
			{
				width = 0;
				height++;
				nextRow = false;
			}
			
			if(FileAnalyzer.list.get(i) == 0)
			{
				blackcode = blackcode + codeSchreiber(y+width, x+height);
			}
			else if(FileAnalyzer.list.get(i) == 2)
			{
				greycode = greycode + codeSchreiber(y+width, x+height);
			}
			
			if(width < FileAnalyzer.width)
			{
				width++;
				if(width == FileAnalyzer.width)
				{
					nextRow = true;
				}
			}
		}
		
		if(!blackcode.isEmpty()) blackcode = blackcode.substring(0,blackcode.length()-1);
		if(!greycode.isEmpty()) greycode = greycode.substring(0,greycode.length()-1);
		
		blackcode = blackcode + "#";
		greycode = greycode + "#";
		
		blackcode = blackcode + greycode;
		
		StringSelection stringSelection = new StringSelection(blackcode);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
	}
	
	public String codeSchreiber(int height, int width)
	{
		String b32width = Integer.toString(width*3, 32);
		String b32height = Integer.toString(height*3, 32);
		
		String b32width1 = Integer.toString(width*3+1, 32);
		
		String b32width2 = Integer.toString(width*3+2, 32);
		String b32height2 = Integer.toString(height*3+2, 32);
		
		return b32width + " " + b32height + " " + b32width + " " + b32height2 + "," + b32width1 + " " + b32height + " " + b32width1 + " " + b32height2 + "," + b32width2 + " " + b32height + " " + b32width2 + " " + b32height2 + ",";
	}
}