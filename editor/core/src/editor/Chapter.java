package editor;

import java.util.List;
import java.util.ArrayList;

import editor.exceptions.NoSuchTextElementException;

/**
 * Chapter.
 * <p>
 * May contain {@link Section sections} and {@link Paragraph paragraphs}. 
 */
public class Chapter extends CompositeElement {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 2018_06_29_15_22L;

	/** Chapter title. */
	private String title;

	/**
	 * Creates an empty Chapter.
	 * @param title The chapter title.
	 * @param document The document this chapter belongs to.
	 */
	public Chapter( Document document, String title ) {
		super( document );
		this.title = title != null ? title : "";
	}

	/**
	 * @return The chapter title.
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Appends a Section to the chapter.
	 * @param title The title to give to the added Section.
	 * @return The created Section.
	 */
	public Section addSection( String title ) {
		Section section = new Section( this.document, title );
		this.addTextElement( section );
		return section;
	}

	/**
	 * Appends a Paragraph to the chapter.
	 * @return The created Paragraph.
	 */
	public Paragraph addParagraph() {
		Paragraph paragraph = new Paragraph( this.document );
		this.addTextElement( paragraph );
		return paragraph;
	}

	/**
	 * Returns a Section, given an ID.
	 * <p>
	 * If such Section doesn't exist in this chapter, it throws.
	 * @param id The ID to look for.
	 * @return A Section with the ID {@code id}.
	 * @throws NoSuchTextElementException If there's no such Section
	 * in this chapter with the ID {@code id}.
	 */
	public Section getSection( int id ) throws NoSuchTextElementException {
		return this.<Section>getTextElement( Section.class, id );
	}

	/**
	 * Returns a Paragraph, given an ID.
	 * <p>
	 * If such Paragraph doesn't exist in this chapter, it throws.
	 * @param id The ID to look for.
	 * @return A Paragraph with the ID {@code id}.
	 * @throws NoSuchTextElementException If there's no such Paragraph
	 * in this chapter with the ID {@code id}.
	 */
	public Paragraph getParagraph( int id ) throws NoSuchTextElementException {
		return this.<Paragraph>getTextElement( Paragraph.class, id );
	}

	/**
	 * Removes a section, given an ID.
	 * <p>
	 * If such section doesn't exist in this chapter, it throws.
	 * @param id The ID of the section to be removed.
	 * @throws NoSuchTextElementException If there's no such section
	 * in this chapter with the ID {@code id}.
	 */
	public void removeSection( int id ) throws NoSuchTextElementException {
		this.<Section>removeTextElement( Section.class, id );
	}

	/**
	 * Removes a paragraph, given an ID.
	 * <p>
	 * If such paragraph doesn't exist in this chapter, it throws.
	 * @param id The ID of the paragraph to be removed.
	 * @throws NoSuchTextElementException If there's no such paragraph
	 * in this chapter with the ID {@code id}.
	 */
	public void removeParagraph( int id ) throws NoSuchTextElementException {
		this.<Paragraph>removeTextElement( Paragraph.class, id );
	}

	/**
	 * Retrieves the content of the chapter.
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
	 * Counts the total number of characters in this chapter.
	 * @return The number of characters in this chapter.
	 * @see TextElement#charCount()
	 * @see CompositeElement#charCount()
	 */
	@Override
	public int charCount() {
		return this.title.length() + super.charCount();
	}

	/**
	 * Get the total number of words in this chapter.
	 * @return The number of words in this chapter.
	 * @see TextElement#wordCountOn( String )
	 * @see TextElement#wordCount()
	 * @see CompositeElement#wordCount()
	 */
	@Override
	public int wordCount() {
		return TextElement.wordCountOn( this.title ) + super.wordCount();
	}

}
