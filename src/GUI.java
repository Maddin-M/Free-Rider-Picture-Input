import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class GUI extends JFrame
{	
	private static final long serialVersionUID = 1L;
	
	private JButton bchoose;
	private JButton bgetcode;
	
	private JTextField x;
	private JTextField y;
	
	public GUI()
	{
		super("FRPI");
		setLayout(new FlowLayout());
	
		bchoose = new JButton("Choose Image");
		bgetcode = new JButton("Get Code");
		
		bgetcode.setEnabled(false);
		
		x = new JTextField("0",6);
		y = new JTextField("0",6);
		
		x.setHorizontalAlignment(JTextField.CENTER);
		y.setHorizontalAlignment(JTextField.CENTER);
		
		x.addFocusListener(new FocusListener()
		{
	        public void focusGained(FocusEvent e)
	        {
	        	if(x.getText().equals("X")) {x.setText("");}
	        }

			public void focusLost(FocusEvent e) 
			{
				if(x.getText().equals("")) {x.setText("X");}
			}
	    });
		
		y.addFocusListener(new FocusListener()
		{
	        public void focusGained(FocusEvent e)
	        {
	        	if(y.getText().equals("Y")) {y.setText("");}
	        }

			public void focusLost(FocusEvent e)
			{
				if(y.getText().equals("")) {y.setText("Y");}
			}
	    });
		
		add(bchoose);
		add(bgetcode);
		
		add(x);
		add(y);
		
		bchoose.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				new FileChooser();
				bgetcode.setEnabled(true);
			}
		});
		
		bgetcode.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{
				int ix = Integer.parseInt(x.getText());
				int iy = Integer.parseInt(y.getText());
				new CodeGenerator(ix, iy);
			}
		});
	}
}