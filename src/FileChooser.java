import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends JFileChooser
{
	private static final long serialVersionUID = 1L;
	
	private int result;
	
	public FileChooser()
	{
		setFileFilter(new FileNameExtensionFilter("Bilddateien", "png"));

		result = this.showOpenDialog(null);
		
		if (result == JFileChooser.APPROVE_OPTION)
		{
			new FileAnalyzer(getSelectedFile());
		}
	}
}