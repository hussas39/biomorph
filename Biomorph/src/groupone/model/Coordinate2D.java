package groupone.model;

public class Coordinate2D {
	// X Coordinate
	private int xPos;
	// Y Coordinate
	private int yPos;
	
	/**
	 * Construct a new Coordinate2D object.
	 * @param x : The value of the x coordinate.
	 * @param y : The value of the y coordinate.
	 */
	public Coordinate2D(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	/**
	 * Return the value of the x coordinate.
	 * @return xPos : int.
	 */
	public int getXPos() {
		return xPos;
	}
	
	/**
	 * Return the value of the y coordinate.
	 * @return yPos : int.
	 */
	public int getYPos() {
		return yPos;
	}
	
	/**
	 * Set the value of the x coordinate.
	 * @param x : int.
	 */
	public void setXPos(int x) {
		xPos = x;
	}
	
	/**
	 * Set the value of the y coordinate.
	 * @param y : int.
	 */
	public void setYPos(int y) {
		yPos = y;
	}
}