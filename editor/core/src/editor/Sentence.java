package editor;

import editor.exceptions.NoSuchTextElementException;

/**
 * Sentence.
 * <p>
 * Contains raw text.
 * <p>
 * This class is the/a leaf of the 
 * <a href="https://www.l2f.inesc-id.pt/~david/w/pt/Composite_(padr%C3%A3o_de_desenho)">
 *   Composite Design Pattern
 * </a> implemented.
 * @see CompositeElement
 */
public class Sentence extends TextElement {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 2018_06_28_20_07L;

	/** Sentence content (text). */
	private StringBuilder content;

	/**
	 * Creates a Sentence with empty content.
	 * @param document The document this sentence belongs to.
	 */
	public Sentence( Document document ) {
		super( document );
		this.content = new StringBuilder();
	}

	/**
	 * @return The content.
	 */
	public String getContent() {
		return this.content.toString();
	}

	/**
	 * Adds content to the sentence.
	 * <p>
	 * Updates the document data after inserting the content.
	 * @param content The content (words) to add to the sentence.
	 * @return The Sentence instance ({@code this}), to allow method chaining.
	 */
	public Sentence addContent( String content ) {
		this.content.append( content );
		this.document.updateData();
		return this;
	}

	/**
	 * Removes the content of the sentence.
	 * <p>
	 * Updates the document data after removing the content.
	 * @return The Sentence instance ({@code this}), to allow method chaining.
	 */
	public Sentence removeContent() {
		this.content = new StringBuilder();
		this.document.updateData();
		return this;
	}

	/**
	 * Retrieves the content of the sentence.
	 * @param visitor {@inheritDoc}
	 * @return {@inheritDoc}
	 * @see TextElement#show( ShowVisitor )
	 */
	@Override
	public String show( ShowVisitor visitor ) {
		visitor.visit( this );
		return visitor.fetch();
	}

	/**
	 * Counts the total number of characters in this sentence.
	 * @return The number of characters in this sentence.
	 * @see TextElement#charCount()
	 */
	@Override
	public int charCount() {
		return this.content.length();
	}

	/**
	 * Counts the total number of words in this sentence.
	 * @return The number of words in this sentence.
	 * @see TextElement#wordCountOn( String )
	 * @see TextElement#wordCount()
	 */
	@Override
	public int wordCount() {
		return TextElement.wordCountOn( this.getContent() );
	}

	/**
	 * Sentence is the leaf of the Composite. Thus, this operation
	 * is not supported by it.
	 * @see TextElement#addTextElement( TextElement )
	 */
	@Override
	protected void addTextElement( TextElement textElement ) {
		throw new UnsupportedOperationException( "Sentence cannot add text elements!" );
	}

	/**
	 * Sentence is the leaf of the Composite. Thus, this operation
	 * is not supported by it.
	 * @see TextElement#getTextElement( int )
	 */
	@Override
	public TextElement getTextElement( int id ) throws NoSuchTextElementException {
		throw new UnsupportedOperationException( "Sentence cannot get text elements!" );
	}

	/**
	 * Sentence is the leaf of the Composite. Thus, this operation
	 * is not supported by it.
	 * @see TextElement#removeTextElement( int )
	 */
	@Override
	public void removeTextElement( int id ) throws NoSuchTextElementException {
		throw new UnsupportedOperationException( "Sentence cannot remove text elements!" );
	}

}
