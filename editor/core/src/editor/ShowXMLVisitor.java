package editor;

/**
 * Show XML Visitor.
 * <p>
 * To display content formatted in XML (pretty print).
 */
public class ShowXMLVisitor implements ShowVisitor {

	/** Content buffer. */
	private StringBuilder content;

	/** Indentation level (depth). */
	private int level;

	/**
	 * Initialize the concrete visitor with a 
	 * {@link java.lang.StringBuilder StringBuilder} buffer,
	 * to facilitate messing with strings.
	 */
	public ShowXMLVisitor() {
		this.content = new StringBuilder();
		this.level = 0; // I like being explicit.
	}

	/**
	 * Parses and fetchs the gathered content of the visit,
	 * if the visit was done.
	 * @return The result of the visit.
	 */
	public String fetch() {
		return this.content.toString();
	}

	/**
	 * Adds a line to the to be output string.
	 * @param line The line to be added.
	 */
	private void add( String line ) {
		for ( int  i = 0; i < this.level; i++ ) {
			this.content.append( "\t" );
		}
		this.content.append( line );
		this.content.append( "\n" );
	}

	/**
	 * Visits the document. Traverses the document elements.
	 * @param document Document to visit.
	 * @see ShowVisitor#visit( Document )
	 */
	@Override
	public void visit( Document document ) {
		StringBuilder sb = new StringBuilder()
			.append( "<document creator=\""     )
			.append( document.getCreator()      )
			.append( "\" creation-date=\""      )
			.append( document.getCreationDate() )
			.append( "\" latest-author=\""      )
			.append( document.getLatestAuthor() )
			.append( "\" latest-date=\""        )
			.append( document.getLatestDate()   )
			.append( "\" chars=\""              )
			.append( document.charCount()       )
			.append( "\" words=\""              )
			.append( document.wordCount()       )
			.append( "\">"                      )
		;

		this.add( sb.toString() );
		this.level++;
		document.getContent().stream()
			.forEach(
				textElement -> textElement.show( this )
			)
		;
		this.level--;
		this.add( "</document>" );
	}

	/**
	 * Visits the chapter. Traverses the chapter elements.
	 * @param chapter Chapter to visit.
	 * @see ShowVisitor#visit( Chapter )
	 */
	@Override
	public void visit( Chapter chapter ) {
		StringBuilder sb = new StringBuilder()
			.append( "<chapter id=\""    )
			.append( chapter.getId()     )
			.append( "\" title=\""       )
			.append( chapter.getTitle()  )
			.append( "\" chars=\""       )
			.append( chapter.charCount() )
			.append( "\" words=\""       )
			.append( chapter.wordCount() )
			.append( "\">"               )
		;

		this.add( sb.toString() );
		this.level++;
		chapter.getContent().stream()
			.forEach(
				textElement -> textElement.show( this )
			)
		;
		this.level--;
		this.add( "</chapter>" );
	}

	/**
	 * Visits the section. Traverses the section elements.
	 * @param section Section to visit.
	 * @see ShowVisitor#visit( Section )
	 */
	@Override
	public void visit( Section section ) {
		StringBuilder sb = new StringBuilder()
			.append( "<section id=\""    )
			.append( section.getId()     )
			.append( "\" title=\""       )
			.append( section.getTitle()  )
			.append( "\" chars=\""       )
			.append( section.charCount() )
			.append( "\" words=\""       )
			.append( section.wordCount() )
			.append( "\">"               )
		;

		this.add( sb.toString() );
		this.level++;
		section.getContent().stream()
			.forEach(
				textElement -> textElement.show( this )
			)
		;
		this.level--;
		this.add( "</section>" );
	}

	/**
	 * Visits the paragraph. Traverses the paragraph elements.
	 * @param paragraph Paragraph to visit.
	 * @see ShowVisitor#visit( Paragraph )
	 */
	@Override
	public void visit( Paragraph paragraph ) {
		StringBuilder sb = new StringBuilder()
			.append( "<paragraph id=\""    )
			.append( paragraph.getId()     )
			.append( "\" chars=\""         )
			.append( paragraph.charCount() )
			.append( "\" words=\""         )
			.append( paragraph.wordCount() )
			.append( "\">"                 )
		;

		this.add( sb.toString() );
		this.level++;
		paragraph.getContent().stream()
			.forEach(
				textElement -> textElement.show( this )
			)
		;
		this.level--;
		this.add( "</paragraph>" );
	}

	/**
	 * Visits the sentence. Gets its content.
	 * @param sentence Sentence to visit.
	 * @see ShowVisitor#visit( Sentence )
	 */
	@Override
	public void visit( Sentence sentence ) {
		StringBuilder sb = new StringBuilder()
			.append( "<sentence id=\""    )
			.append( sentence.getId()     )
			.append( "\" chars=\""        )
			.append( sentence.charCount() )
			.append( "\" words=\""        )
			.append( sentence.wordCount() )
			.append( "\">"                )
		;

		this.add( sb.toString() );
		this.level++;
		this.add( sentence.getContent() );
		this.level--;
		this.add( "</sentence>" );
	}

}
