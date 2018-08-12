package editor.exceptions;

/**
 * NoSuchTextElementException.
 */
public class NoSuchTextElementException extends Exception {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 2018_06_28_23_32L;

	/** Incorrect text element ID. */
	private final int id;

	/**
	 * @param id The unused ID for a text element in a given context.
	 */ 
	public NoSuchTextElementException( int id ) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public String getMessage() {
		return "No element with id " + this.id;
	}

}
