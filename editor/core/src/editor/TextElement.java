package editor;

import java.io.Serializable;

import editor.exceptions.NoSuchTextElementException;

/**
 * Text Element that can be contained in a Document.
 */
public abstract class TextElement implements Serializable {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 2018_06_28_16_00L;

	/** Text element unique ID. */
	private final int id;

	/** Document this TextElement belongs to. */
	protected Document document;

	/**
	 * Defines a general way to count words in a string.
	 * @param stringOfWords The string, whose words are to be counted.
	 * @return The number of words in {@code stringOfWords}.
	 */
	public static final int wordCountOn( String stringOfWords ) {
		return stringOfWords.trim().equals( "" )
			? 0
			: stringOfWords.trim().split( "\\s+" ).length
		;
	}

	/**
	 * Assigns the unique ID to the text element.
	 * <p>
	 * This ID is unique for each TextElement inside the same document.
	 * Thus, it is decided by the document itself.
	 * @param document The document the Text Element belongs to.
	 * <p>
	 * If this parameter is {@code null}, then, {@code this} TextElement
	 * is necessarily the document itself (the document being the root),
	 * because all other constructors pass the document they're contained on.
	 * If they pass {@code null}, then they are not contained in the document,
	 * meaning they are the document. Again, since the document is the root
	 * of all of the other elements, as soon as the document creates a TextElement
	 * (safely assuming the individual text elements are instantiated <em>always</em>
	 * by other text elements that can involve them), then it passes a reference to
	 * itself; thus, sanely spreading a legitimate {@code this.document}.
	 */
	protected TextElement( Document document ) {
		this.id = document != null ? document.getNextId() : 0;
		this.document = document != null
			? document
			: (Document) this
		;
	}

	/**
	 * @return The TextElement ID.
	 */
	public final int getId() {
		return this.id;
	}

	/**
	 * @return The Document this TextElement belongs to.
	 */
	public Document getDocument() {
		return this.document;
	}

	/**
	 * Adds a TextElement to this element.
	 * <p>
	 * Updates the Document data after inserting the TextElement.
	 * <p>
	 * A TextElement should always be inserted in a concrete way.
	 * That means: we can't have a TextElement floating meaninglessly;
	 * we always create them associated with a {@link Document}.
	 * So, we can't have, for instance, a List of TextElements to be
	 * inserted somewhere, because they must already belong to some Document.
	 * (I'm not contemplating copying from one Document to another.)
	 * It's set as {@code protected} because of this (internal use only).
	 * @param textElement The TextElement to add.
	 */
	protected abstract void addTextElement( TextElement textElement );

	/**
	 * Returns a TextElement, given an ID.
	 * <p>
	 * If such TextElement doesn't exist in this element, it throws.
	 * @param id The ID to look for.
	 * @return A TextElement with the ID {@code id}.
	 * @throws NoSuchTextElementException If there's no such
	 * TextElement in this element with the ID {@code id}.
	 */
	public abstract TextElement getTextElement( int id ) throws NoSuchTextElementException;

	/**
	 * Removes a TextElement, given an ID.
	 * <p>
	 * If such element doesn't exist in this element, it throws.
	 * @param id The ID to look for.
	 * @throws NoSuchTextElementException If there's no such
	 * TextElement in this element with the ID {@code id}.
	 */
	public abstract void removeTextElement( int id ) throws NoSuchTextElementException;

	/**
	 * Traverses the elements, gathering their content
	 * and retrives it properly formatted. 
	 * @param visitor The ShowVisitor to apply,
	 * to gather and format the content.
	 * @return The content gathered, formatted in a specific way. 
	 */
	public abstract String show( ShowVisitor visitor );

	/**
	 * Counts the total number of characters.
	 * @return The number of characters.
	 */
	public abstract int charCount();

	/**
	 * Counts the total number of words.
	 * @return The number of words.
	 */
	public abstract int wordCount();

}