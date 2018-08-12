package editor;

/**
 * Show JSON Visitor.
 * <p>
 * To display content formatted in JSON (pretty print).
 */
public class ShowJSONVisitor implements ShowVisitor {

	/** Content buffer. */
	private StringBuilder content;

	/** Indentation level (depth). */
	private int level;

	/**
	 * Initialize the concrete visitor with a 
	 * {@link java.lang.StringBuilder StringBuilder} buffer,
	 * to facilitate messing with strings.
	 */
	public ShowJSONVisitor() {
		this.content = new StringBuilder();
		this.level = 0; // I like being explicit.
	}

	/**
	 * Parses and fetchs the gathered content of the visit,
	 * if the visit was done.
	 * @return The result of the visit.
	 */
	public String fetch() {
		return this.content.toString().replaceAll( "},(\\s*)(]|$)", "}$1$2" );
	}

	/**
	 * Adds a line to the to be output string.
	 * @param line The line to be added.
	 * @return A reference to {@code this} object.
	 */
	private ShowJSONVisitor add( String line ) {
		for ( int  i = 0; i < this.level; i++ ) {
			this.content.append( "  " );
		}
		this.content.append( line );
		this.content.append( "\n" );
		return this;
	}

	/**
	 * Opens a bracket ({@code &#123;}).
	 * @return A reference to {@code this} object.
	 */
	private ShowJSONVisitor openBracket() {
		this.add( "{" );
		this.level++;
		return this;
	}

	/**
	 * Closes a bracket ({@code &#125;}).
	 * @return A reference to {@code this} object.
	 */
	private ShowJSONVisitor closeBracket() {
		this.level--;
		this.add( "}," );
		return this;
	}

	/**
	 * Visits the document. Traverses the document elements.
	 * @param document Document to visit.
	 * @see ShowVisitor#visit( Document )
	 */
	@Override
	public void visit( Document document ) {
		this
			.openBracket()
				.add( "\"type\": \"Document\"," )
				.add( "\"creator\": \"" + document.getCreator() + "\"," )
				.add( "\"creation date\": \"" + document.getCreationDate() + "\"," )
				.add( "\"latest author\": \"" + document.getLatestAuthor() + "\"," )
				.add( "\"latest date\": \"" + document.getLatestDate() + "\"," )
				.add( "\"chars\": " + document.charCount() + "," )
				.add( "\"words\": " + document.wordCount() + "," )
				.add( "\"content\": [" );
					this.level++;
					document.getContent().stream()
						.forEach(
							textElement -> textElement.show( this )
						)
					;
				this.level--;
				this.add( "]" )
			.closeBracket()
		;
	}

	/**
	 * Visits the chapter. Traverses the chapter elements.
	 * @param chapter Chapter to visit.
	 * @see ShowVisitor#visit( Chapter )
	 */
	@Override
	public void visit( Chapter chapter ) {
		this
			.openBracket()
				.add( "\"type\": \"Chapter\"," )
				.add( "\"id\": " + chapter.getId() + "," )
				.add( "\"title\": \"" + chapter.getTitle() + "\"," )
				.add( "\"chars\": " + chapter.charCount() + "," )
				.add( "\"words\": " + chapter.wordCount() + "," )
				.add( "\"content\": [" );
					this.level++;
					chapter.getContent().stream()
						.forEach(
							textElement -> textElement.show( this )
						)
					;
				this.level--;
				this.add( "]" )
			.closeBracket()
		;
	}

	/**
	 * Visits the section. Traverses the section elements.
	 * @param section Section to visit.
	 * @see ShowVisitor#visit( Section )
	 */
	@Override
	public void visit( Section section ) {
		this
			.openBracket()
				.add( "\"type\": \"Section\"," )
				.add( "\"id\": " + section.getId() + "," )
				.add( "\"title\": \"" + section.getTitle() + "\"," )
				.add( "\"chars\": " + section.charCount() + "," )
				.add( "\"words\": " + section.wordCount() + "," )
				.add( "\"content\": [" );
				this.level++;
					section.getContent().stream()
						.forEach(
							textElement -> textElement.show( this )
						)
					;
				this.level--;
				this.add( "]" )
			.closeBracket()
		;
	}

	/**
	 * Visits the paragraph. Traverses the paragraph elements.
	 * @param paragraph Paragraph to visit.
	 * @see ShowVisitor#visit( Paragraph )
	 */
	@Override
	public void visit( Paragraph paragraph ) {
		this
			.openBracket()
				.add( "\"type\": \"Paragraph\"," )
				.add( "\"id\": " + paragraph.getId() + "," )
				.add( "\"chars\": " + paragraph.charCount() + "," )
				.add( "\"words\": " + paragraph.wordCount() + "," )
				.add( "\"content\": [" );
				this.level++;
					paragraph.getContent().stream()
						.forEach(
							textElement -> textElement.show( this )
						)
					;
				this.level--;
				this.add( "]" )
			.closeBracket()
		;
	}

	/**
	 * Visits the sentence. Gets its content.
	 * @param sentence Sentence to visit.
	 * @see ShowVisitor#visit( Sentence )
	 */
	@Override
	public void visit( Sentence sentence ) {
		this
			.openBracket()
				.add( "\"type\": \"Sentence\"," )
				.add( "\"id\": " + sentence.getId() + "," )
				.add( "\"chars\": " + sentence.charCount() + "," )
				.add( "\"words\": " + sentence.wordCount() + "," )
				.add( "\"content\": \"" + sentence.getContent() + "\"" )
			.closeBracket()
		;
	}

}
