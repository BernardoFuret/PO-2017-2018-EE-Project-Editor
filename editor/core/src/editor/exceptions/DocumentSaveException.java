package editor.exceptions;

/**
 * DocumentSaveException.
 */
public class DocumentSaveException extends Exception {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 2018_07_01_12_17L;

	/**
	 * Triggered by when a {@link Document} cannot be saved. 
	 * @param cause {@inheritDoc}
	 */
	public DocumentSaveException( Throwable cause ) {
		super( cause );
	}

	@Override
	public String getMessage() {
		Throwable cause = this.getCause();
		return cause != null ? cause.toString() : "";
	}

}
