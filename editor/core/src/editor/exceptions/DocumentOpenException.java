package editor.exceptions;

/**
 * DocumentOpenException.
 */
public class DocumentOpenException extends Exception {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 2018_07_01_12_05L;

	/**
	 * Triggered by when a {@link Document} cannot be opened. 
	 * @param cause {@inheritDoc}
	 */
	public DocumentOpenException( Throwable cause ) {
		super( cause );
	}

	@Override
	public String getMessage() {
		Throwable cause = this.getCause();
		return cause != null ? cause.toString() : "";
	}

}
