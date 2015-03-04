package groupone.model;

/**
 * Model colours as RGB components.
 * @author Kiel Pykett
 * @version 04.03.2015
 */
public class Colour {
	// Standard colours
	public static final Colour RED     = new Colour(1.0f, 0.0f, 0.0f);
	public static final Colour GREEN   = new Colour(0.0f, 1.0f, 0.0f);
	public static final Colour BLUE    = new Colour(0.0f, 0.0f, 1.0f);
	public static final Colour YELLOW  = new Colour(1.0f, 1.0f, 0.0f);
	public static final Colour PINK    = new Colour(1.0f, 0.0f, 1.0f);
	public static final Colour CYAN    = new Colour(0.0f, 1.0f, 1.0f);
	public static final Colour BLACK   = new Colour(0.0f, 0.0f, 0.0f);
	public static final Colour WHITE   = new Colour(1.0f, 1.0f, 1.0f);
	
	// RGB variables
	private float red;
	private float green;
	private float blue;
	
	/**
	 * Construct a Colour using float parameters.
	 * @param red - The red component
	 * @param green - The green component
	 * @param blue - The blue component
	 */
	public Colour(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	/**
	 * Construct a Colour using integer parameters.
	 * @param red - The red component
	 * @param green - The green component
	 * @param blue - The blue component
	 */
	public Colour(int red, int green, int blue) {
		// Need to convert ints to floats
		
		this.red = ((float) red)/255.0f;
		this.green = ((float) green)/255.0f;
		this.blue = ((float) blue)/255.0f;
	}
}