package groupone.view;

import groupone.model.Biomorph;
import groupone.model.BiomorphFactory;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class BiomorphGUI {
	private BiomorphFactory factory;
	private JFrame  mainframe = new JFrame();
	
	public BiomorphGUI() {
		// A factory to produce Biomorphs
		factory = new BiomorphFactory();

		// GUI components
		JButton btnRandom = new JButton();
		JButton btnQuit	  = new JButton();
		JPanel commandBox = new JPanel();

		// Component properties
		mainframe.setTitle("Group One Biomorph");
		mainframe.setSize(700, 700);
		
		btnRandom.setText("Generate Random Biomorph");
		btnRandom.setToolTipText("Generates a new random Biomorph.");

		btnQuit.setText("Quit");
		btnQuit.setToolTipText("Quits the application.");

		// Component containers
		commandBox.setBorder(BorderFactory.createEtchedBorder());

		// Specify Layout Managers
		mainframe.setLayout(new BorderLayout());
		commandBox.setLayout(new BorderLayout());

		// Add components to containers
		commandBox.add(btnRandom, BorderLayout.WEST);
		commandBox.add(btnQuit, BorderLayout.EAST);
		mainframe.add(commandBox, BorderLayout.SOUTH);

		// Event handlers
		mainframe.setDefaultCloseOperation(
				WindowConstants.DO_NOTHING_ON_CLOSE);

		mainframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});

		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});

		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.repaint();
			}
		});

		// Display the GUI
		mainframe.setVisible(true);
	}

	public static void main(String args[]) {
		BiomorphGUI c = new BiomorphGUI();
	}

	/**
	 * Draw the Biomorph.
	 */
	public void paint(Graphics g) {
		mainframe.paint(g);
		Biomorph b = new Biomorph(factory.createRandomBiomorph());

		int x0 = b.getGene(0).getXPos();
		int y0 = b.getGene(0).getYPos();

		int x1 = b.getGene(1).getXPos();
		int y1 = b.getGene(1).getYPos();

		int x2 = b.getGene(2).getXPos();
		int y2 = b.getGene(2).getYPos();

		int x3 = b.getGene(3).getXPos();
		int y3 = b.getGene(3).getYPos();

		int x4 = b.getGene(4).getXPos();
		int y4 = b.getGene(4).getYPos();

		int x5 = b.getGene(5).getXPos();
		int y5 = b.getGene(5).getYPos();

		int x6 = b.getGene(6).getXPos();
		int y6 = b.getGene(6).getYPos();

		int x7 = b.getGene(7).getXPos();
		int y7 = b.getGene(7).getYPos();


		g.drawLine(x0, y0, x1, y1);
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x2, y2, x3, y3);
		g.drawLine(x3, y3, x4, y4);
		g.drawLine(x4, y4, x5, y5);
		g.drawLine(x5, y5, x6, y6);
		g.drawLine(x6, y6, x7, y7);
	}

	/**
	 * Display a dialog box for the user to confirm their exit.
	 */
	private static void exit() {
		// Display confirmation dialog box
		int response = JOptionPane.showConfirmDialog(null, 
				"Do you really want to quit?",
				"Quit?",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);

		if (response == JOptionPane.YES_OPTION) {
			// Quit
			System.exit(0);
		}

		// Don't quit
	}
}