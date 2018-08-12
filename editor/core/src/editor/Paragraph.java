package editor;

import java.util.List;
import java.util.ArrayList;

import editor.exceptions.NoSuchTextElementException;

/**
 * Paragraph.
 * <p>
 * May contain {@link Sentence sentences}.
 */
public class Paragraph extends CompositeElement {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 2018_06_28_20_52L;

	/**
	 * Creates an empty Paragraph.
	 * @param document The document this paragraph belongs to.
	 */
	public Paragraph( Document document ) {
		super( document );
	}

	/**
	 * Adds a Sentence to this paragraph.
	 * @return The created Sentence.
	 */
	public Sentence addSentence() {
		Sentence sentence = new Sentence( this.document );
		this.addTextElement( sentence );
		return sentence;
	}

	/**
	 * Returns a Sentence, given an ID.
	 * <p>
	 * If such Sentence doesn't exist in this paragraph, it throws.
	 * @param id The ID to look for.
	 * @return A Sentence with the ID {@code id}.
	 * @throws NoSuchTextElementException If there's no such Sentence
	 * in this paragraph with the ID {@code id}.
	 */
	public Sentence getSentence( int id ) throws NoSuchTextElementException {
		return this.<Sentence>getTextElement( Sentence.class, id );
	}

	/**
	 * Removes a sentence, given an ID.
	 * <p>
	 * If such sentence doesn't exist in this paragraph, it throws.
	 * @param id The ID of the sentence to be removed.
	 * @throws NoSuchTextElementException If there's no such sentence
	 * in this paragraph with the ID {@code id}.
	 */
	public void removeSentence( int id ) throws NoSuchTextElementException {
		this.<Sentence>removeTextElement( Sentence.class, id );
	}

	/**
	 * Retrieves the content of the paragraph.
	 * @param visitor {@inheritDoc}
	 * @return {@inheritDoc}
	 * @see TextElement#show( ShowVisitor )
	 */
	@Override
	public String show( ShowVisitor visitor ) {
		visitor.visit( this );
		return visitor.fetch();
	}

}
