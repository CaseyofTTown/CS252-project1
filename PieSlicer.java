

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Main program: opens a window containing a PieView and two buttons
 * for selecting the colors used to represent the pie.
 * 
 * @author zeil
 *
 */
public class PieSlicer extends JFrame implements ActionListener {

	private JButton base;
	private JButton slice;
	private JLabel pieText;
	PieView pv;

	
	/**
	 * Open a window with the PieView and color
	 * selection buttons.
	 */
	public PieSlicer(String title) {
		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		pv = new PieView();
		content.add (pv, BorderLayout.CENTER);
		
		JPanel header = new JPanel();
		pieText = new JLabel(title);
		header.add(pieText);
		content.add (header, BorderLayout.NORTH);
		
		JPanel controls = new JPanel();
		base = new JButton ("Base");
		slice = new JButton("Slice");
		base.setForeground(pv.getPie().baseColor);
		slice.setForeground(pv.getPie().sliceColor);
		controls.add(base);
		controls.add(slice);
		content.add (controls, BorderLayout.SOUTH);
		
		base.addActionListener(this);
		slice.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	/**
	 * Respond to the pressing of a color selection button.
	 */
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		Color chosen = JColorChooser.showDialog(this, "Choose a color", button.getForeground());
		if (button == base)
			pv.getPie().baseColor = chosen;
		else
			pv.getPie().sliceColor = chosen;
		pv.repaint();
		pieText.setText("" + pv.getPie());
	}

	
	
	/**
	 * Run the program.
	 * adding another comment :) 
	 * @param args ignored
	 */
	public static void main(String[] args) {
		String title = "Cake";
		if (args.length > 0) {
			title = args[0];
		}
		PieSlicer window = new PieSlicer(title);
		window.pack();
		window.setVisible(true);
	}




}
