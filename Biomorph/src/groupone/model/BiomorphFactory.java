package groupone.model;

import java.util.Random;

public class BiomorphFactory {
	// Seed for the random number generator
	private static final int SEED = 42;
	// Maximum permitted value for an x coordinate
	private static final int MAX_X_COORD_VALUE = 350;
	// Maximum permitted value for a y coordinate
	private static final int MAX_Y_COORD_VALUE = 600;
	// Random number generator
	private Random rnd;
	// Array of gene coordinates
	private Point[] genes;
	
	public BiomorphFactory() {
		rnd = new Random(SEED);
		genes = new Point[Biomorph.MAX_GENES];
	}
	
	/**
	 * Creates a random Biomorph.
	 * @return A random Biomorph.
	 */
	public Point[] createRandomBiomorph() {
		
		for (int i = 0; i < Biomorph.MAX_GENES; i++) {
			// Ensure values are between 0 and 700
			int xPos = rnd.nextInt(MAX_X_COORD_VALUE);
			int yPos = rnd.nextInt(MAX_Y_COORD_VALUE);
			
			// Create a new Coordinate2D object with the random numbers and enter it into the array
			genes[i] = new Point(xPos, yPos);
		}
				
		return genes;
	}
}