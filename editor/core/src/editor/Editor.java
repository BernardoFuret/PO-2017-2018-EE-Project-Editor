package editor;

import java.io.Serializable;

import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;

import java.io.IOException;
import java.io.FileNotFoundException;

import editor.exceptions.DocumentOpenException;
import editor.exceptions.DocumentSaveException;

/**
 * Editor
 */
public class Editor implements Serializable {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 2018_06_25_16_40L;

	/** Current document. */
	private Document document;

	/** Current user. */
	private String user;

	/**
	 * Creates an Editor with a fresh document open.
	 */
	public Editor() {
		this.user = "Unknown";
		this.create();
	}

	public Document getDocument() {
		return this.document;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser( String user ) {
		this.user = user;
		this.document.setCurrentAuthor( this.user );
	}

	/**
	 * Creates a new document.
	 */
	public void create() {
		this.document = new Document( this.user );
	}

	/**
	 * Opens a document, given a possible document name.
	 * <p>
	 * In the opened document, it is set the current user editing it. 
	 * @param filename The name of the document to be opened.
	 * @throws FileNotFoundException {@inheritDoc}
	 * @throws DocumentOpenException In case other exceptions occur
	 * (basically, agglomerates them, to facilitate treating them).
	 */
	public void open( String filename ) throws FileNotFoundException, DocumentOpenException {
		try (
			FileInputStream fileStream = new FileInputStream( filename );
			BufferedInputStream bufferedStream = new BufferedInputStream( fileStream );
			ObjectInputStream objectStream = new ObjectInputStream( bufferedStream )
		) {
			this.document = (Document) objectStream.readObject();
			this.document.setCurrentAuthor( this.user );
		} catch ( FileNotFoundException fnfe ) {
			// In case the client wants to deal differently with it
			// (e.g., implement a file search system to find a similar name).
			throw fnfe;
		} catch ( IOException | ClassNotFoundException ioeCnfe ) {
			throw new DocumentOpenException( ioeCnfe );
		}
	}

	/**
	 * Saves (serializes) the document with the name given.
	 * <p>
	 * Right before saving, the document info is updated
	 * (just like in real text editors).
	 * @param filename Saves the document with this name.
	 * @throws DocumentSaveException If there was a problem saving the file.
	 */
	public void save( String filename ) throws DocumentSaveException {
		try (
			FileOutputStream fileStream = new FileOutputStream( filename );
			BufferedOutputStream bufferedStream = new BufferedOutputStream( fileStream );
			ObjectOutputStream objectStream = new ObjectOutputStream( bufferedStream )
		) {
			this.document.updateData();
			objectStream.writeObject( this.document );
		} catch ( IOException ioe ) {
			throw new DocumentSaveException( ioe );
		}
	}

}
