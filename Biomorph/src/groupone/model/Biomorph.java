package groupone.model;

public class Biomorph {
	// Maximum number of permitted genes
	static final int MAX_GENES = 8;
	// Array to store the Biomorph's genes coordinates
	private Coordinate2D[] genes;
	
	/**
	 * Biomorph constructor.
	 * @param genes - An array of Coordinates to act as the genes.	
	 */
	public Biomorph(Coordinate2D[] genes) {
		this.genes = genes;
	}
	
	/**
	 * Returns the array storing the genes.
	 * @return : genes.
	 */
	public Coordinate2D[] getGenes() {
		return genes;
	}
	
	/**
	 * Return the maximum number of permitted genes.
	 * @return MAX_GENES : The maximum number of permitted genes.
	 */
	public int getMaxGenes() {
		return MAX_GENES;
	}
	
	/**
	 * Retrieve the coordinates of a specified gene.
	 * @param index : The gene whose coordinates are to be returned.
	 * @return genes[index] : The coordinate object stored in the genes array at <i>index</i>.
	 */
	public Coordinate2D getGene(int index) {
		return genes[index];
	}
}