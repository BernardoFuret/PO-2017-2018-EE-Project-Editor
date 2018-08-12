package editor;

import java.time.LocalDateTime;

import java.util.List;
import java.util.ArrayList;

import editor.exceptions.NoSuchTextElementException;

/**
 * Document.
 * <p>
 * May contain {@link Chapter chapters}, {@link Section sections},
 * {@link Paragraph paragraphs} and {@link Sentence sentences}. 
 */
public class Document extends CompositeElement {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 2018_06_27_20_06L;

	/** Text Element ID counter. */
	private int idCount;

	/** Document creator (original author). */
	private String creator;

	/** Document creation date. */
	private LocalDateTime creationDate;

	/** Author currently editing the document. */
	private String currentAuthor;

	/** Document latest author. */
	private String latestAuthor;

	/** Document last modification date. */
	private LocalDateTime latestDate;

	/**
	 * Creates a Document.
	 * @param creator The name of the original author of the document.
	 */
	public Document( String creator ) {
		super( null );
		this.idCount = 0;
		this.creator = creator;
		this.creationDate = LocalDateTime.now();
		this.currentAuthor = this.creator;
		this.latestAuthor = this.currentAuthor;
		this.latestDate = this.creationDate;
	}

	public String getCreator() {
		return this.creator;
	}

	public LocalDateTime getCreationDate() {
		return this.creationDate;
	}

	public String getLatestAuthor() {
		return this.latestAuthor;
	}

	public LocalDateTime getLatestDate() {
		return this.latestDate;
	}

	public void setCurrentAuthor( String author ) {
		this.currentAuthor = author;
	}

	/**
	 * Retrieves the next ID to assign to a Text Element.
	 * @return The next ID to assign.
	 */
	public int getNextId() {
		return ++this.idCount;
	}

	/**
	 * Updates the document data (most recent author and date).
	 */
	public void updateData() {
		this.latestAuthor = this.currentAuthor;
		this.latestDate = LocalDateTime.now();
	}

	/**
	 * Adds a Chapter to this document.
	 * @param title The title to give to the added Chapter.
	 * @return The created Chapter.
	 */
	public Chapter addChapter( String title ) {
		Chapter chapter = new Chapter( this, title );
		this.addTextElement( chapter );
		return chapter;
	}

	/**
	 * Adds a Section to this document.
	 * @param title The title to give to the added Section.
	 * @return The created Section.
	 */
	public Section addSection( String title ) {
		Section section = new Section( this, title );
		this.addTextElement( section );
		return section;
	}

	/**
	 * Adds a Paragraph to this document.
	 * @return The created Paragraph.
	 */
	public Paragraph addParagraph() {
		Paragraph paragraph = new Paragraph( this );
		this.addTextElement( paragraph );
		return paragraph;
	}

	/**
	 * Adds a Sentence to this document.
	 * @return The created Sentence.
	 */
	public Sentence addSentence() {
		Sentence sentence = new Sentence( this );
		this.addTextElement( sentence );
		return sentence;
	}

	/**
	 * Returns a Chapter, given an ID.
	 * <p>
	 * If such Chapter doesn't exist in this document, it throws.
	 * @param id The ID to look for.
	 * @return A Chapter with the ID {@code id}.
	 * @throws NoSuchTextElementException If there's no such Chapter
	 * in this document with the ID {@code id}.
	 */
	public Chapter getChapter( int id ) throws NoSuchTextElementException {
		return this.<Chapter>getTextElement( Chapter.class, id );
	}

	/**
	 * Returns a Section, given an ID.
	 * <p>
	 * If such Section doesn't exist in this document, it throws.
	 * @param id The ID to look for.
	 * @return A Section with the ID {@code id}.
	 * @throws NoSuchTextElementException If there's no such Section
	 * in this document with the ID {@code id}.
	 */
	public Section getSection( int id ) throws NoSuchTextElementException {
		return this.<Section>getTextElement( Section.class, id );
	}

	/**
	 * Returns a Paragraph, given an ID.
	 * <p>
	 * If such Paragraph doesn't exist in this document, it throws.
	 * @param id The ID to look for.
	 * @return A Paragraph with the ID {@code id}.
	 * @throws NoSuchTextElementException If there's no such Paragraph
	 * in this document with the ID {@code id}.
	 */
	public Paragraph getParagraph( int id ) throws NoSuchTextElementException {
		return this.<Paragraph>getTextElement( Paragraph.class, id );
	}

	/**
	 * Returns a Sentence, given an ID.
	 * <p>
	 * If such Sentence doesn't exist in this document, it throws.
	 * @param id The ID to look for.
	 * @return A Sentence with the ID {@code id}.
	 * @throws NoSuchTextElementException If there's no such Sentence
	 * in this document with the ID {@code id}.
	 */
	public Sentence getSentence( int id ) throws NoSuchTextElementException {
		return this.<Sentence>getTextElement( Sentence.class, id );
	}

	/**
	 * Removes a chapter, given an ID.
	 * <p>
	 * If such chapter doesn't exist in this document, it throws.
	 * @param id The ID of the chapter to be removed.
	 * @throws NoSuchTextElementException If there's no such chapter
	 * in this document with the ID {@code id}.
	 */
	public void removeChapter( int id ) throws NoSuchTextElementException {
		this.<Chapter>removeTextElement( Chapter.class, id );
	}

	/**
	 * Removes a section, given an ID.
	 * <p>
	 * If such section doesn't exist in this document, it throws.
	 * @param id The ID of the section to be removed.
	 * @throws NoSuchTextElementException If there's no such section
	 * in this document with the ID {@code id}.
	 */
	public void removeSection( int id ) throws NoSuchTextElementException {
		this.<Section>removeTextElement( Section.class, id );
	}

	/**
	 * Removes a paragraph, given an ID.
	 * <p>
	 * If such paragraph doesn't exist in this document, it throws.
	 * @param id The ID of the paragraph to be removed.
	 * @throws NoSuchTextElementException If there's no such paragraph
	 * in this document with the ID {@code id}.
	 */
	public void removeParagraph( int id ) throws NoSuchTextElementException {
		this.<Paragraph>removeTextElement( Paragraph.class, id );
	}

	/**
	 * Removes a sentence, given an ID.
	 * <p>
	 * If such sentence doesn't exist in this document, it throws.
	 * @param id The ID of the sentence to be removed.
	 * @throws NoSuchTextElementException If there's no such sentence
	 * in this document with the ID {@code id}.
	 */
	public void removeSentence( int id ) throws NoSuchTextElementException {
		this.<Sentence>removeTextElement( Sentence.class, id );
	}

	/**
	 * Retrieves the content of the document.
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