package groupone.model;

/**
 * A class to model the points of a Biomorph.
 * @author Kiel Pykett
 * @version 04.03.2015 
 */
public class Point {
	// X Coordinate
	private int xPos;
	// Y Coordinate
	private int yPos;
	
	/**
	 * Construct a new Coordinate2D object.
	 * @param x : The value of the x coordinate.
	 * @param y : The value of the y coordinate.
	 */
	public Point(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	/**
	 * Return the value of the x coordinate.
	 * @return int
	 */
	public int getXPos() {
		return xPos;
	}
	
	/**
	 * Return the value of the y coordinate.
	 * @return int
	 */
	public int getYPos() {
		return yPos;
	}
	
	/**
	 * Set the value of the x coordinate.
	 * @param x - The x co-ordinate of the point
	 */
	public void setXPos(int x) {
		xPos = x;
	}
	
	/**
	 * Set the value of the y coordinate.
	 * @param y - The y co-ordinate of the point
	 */
	public void setYPos(int y) {
		yPos = y;
	}
}