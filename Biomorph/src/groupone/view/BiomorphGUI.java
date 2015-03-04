package groupone.view;

import groupone.model.Biomorph;
import groupone.model.BiomorphFactory;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

/**
 * Graphical User Interface for the Biomorph Project
 * @author Kiel Pykett
 * @version 04.03.2015
 */
public class BiomorphGUI {
	// Something to produce Biomorphs
	private BiomorphFactory factory;
	
	private JFrame  mainframe;
	
	// Adjustable sliders
	private LabelledSlider heightSlider;
	private LabelledSlider widthSlider;
	private LabelledSlider depthSlider;
	
	public BiomorphGUI() {
		factory = new BiomorphFactory();

		// GUI components
		mainframe    = new JFrame();
		heightSlider = new LabelledSlider("Height: ", 5, 1, 10, 1);
		widthSlider  = new LabelledSlider("Width: ",  5, 1, 10, 1);
		depthSlider  = new LabelledSlider("Depth: ",  5, 1, 10, 1);
		
		// Menu components
		JMenuBar menubar  = new JMenuBar();
		JMenu fileMenu    = new JMenu("File");
		JMenu helpMenu    = new JMenu("Help");

		JButton btnRandom = new JButton();
		JButton btnQuit	  = new JButton();
		JPanel topPanel   = new JPanel();
		JPanel commandBox = new JPanel();
		JPanel sliderBox  = new JPanel();

		// Component properties
		// Frame properties
		mainframe.setTitle("Group One Biomorph");
		mainframe.setSize(700, 700);
		
		// Menu properties
		fileMenu.setMnemonic(KeyEvent.VK_F);
		fileMenu.getAccessibleContext().setAccessibleDescription("File options");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		helpMenu.getAccessibleContext().setAccessibleDescription("Help options");
		
		// Add the menus to the menubar
		menubar.add(fileMenu);
		menubar.add(helpMenu);
		
		// Add menu items to the file menu
		// Menu Item : Load
		JMenuItem loadItem = new JMenuItem("Load");
		loadItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_L, ActionEvent.CTRL_MASK));			// Perform action when CTRL + L is pressed
		loadItem.getAccessibleContext().setAccessibleDescription("Load a saved Biomorph");
		
		// Menu Item : Save
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_S, ActionEvent.CTRL_MASK));			// Perform action when CTRL + S is pressed
		saveItem.getAccessibleContext().setAccessibleDescription("Save the current Biomorph");
		
		// Add the menu items to the file menu
		fileMenu.add(loadItem);
		fileMenu.add(saveItem);
		
		// Add menu items to the help menu
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		exitItem.getAccessibleContext().setAccessibleDescription("Exit the application");
		
		// Add the menu items to the help menu
		helpMenu.add(exitItem);
		
		// Slider properties
		heightSlider.setToolTipText("Manipulate the height of the Biomorph");
		widthSlider.setToolTipText("Manipulate the width of the Biomorph");
		depthSlider.setToolTipText("Manipulate the depth of the Biomorph");
		
		// Button properties
		btnRandom.setText("Generate Random Biomorph");
		btnRandom.setToolTipText("Generates a new random Biomorph.");
		btnQuit.setText("Quit");
		btnQuit.setToolTipText("Quits the application.");

		// Component containers
		topPanel.setBorder(BorderFactory.createEtchedBorder());
		commandBox.setBorder(BorderFactory.createEtchedBorder());
		sliderBox.setBorder(BorderFactory.createEmptyBorder());

		// Specify Layout Managers
		mainframe.setLayout(new BorderLayout());
		topPanel.setLayout(new BorderLayout());
		commandBox.setLayout(new BorderLayout());
		sliderBox.setLayout(new BorderLayout());

		// Add components to containers
		commandBox.add(btnRandom, BorderLayout.WEST);				// Put the generate random button on the left
		commandBox.add(btnQuit, BorderLayout.EAST);					// Put the exit button on the right
		
		sliderBox.add(heightSlider, BorderLayout.NORTH);			// Put the height slider on top
		sliderBox.add(widthSlider, BorderLayout.CENTER);			// Put the width slider in the middle
		sliderBox.add(depthSlider, BorderLayout.SOUTH);				// Put the depth slider on the bottom
		
		topPanel.add(menubar, BorderLayout.NORTH);					// Put the menubar on top
		topPanel.add(sliderBox, BorderLayout.SOUTH);				// Put the sliders on the bottom
		
		mainframe.add(topPanel, BorderLayout.NORTH);				// Put the menu & sliders on top
		mainframe.add(commandBox, BorderLayout.SOUTH);				// Put the command box on the bottom

		// Event handlers
		mainframe.setDefaultCloseOperation(
				WindowConstants.DO_NOTHING_ON_CLOSE);
		
		// When the "close" button is pressed
		mainframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		// When the "exit" button is pressed
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		
		// When the "exit" option is selected from the menu
		exitItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						exit();
					}
				});
		
		// When the "random" button is pressed
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
		paint(g);
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