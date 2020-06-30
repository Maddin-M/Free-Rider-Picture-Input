import javax.swing.JFrame;

public class Main
{
	static GUI gui = new GUI();
	
	public static void main(String args[])
	{
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.pack();
		gui.setSize(220,90);
		gui.setResizable(false);
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
	}
}