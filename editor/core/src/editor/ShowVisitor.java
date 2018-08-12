package editor;

/**
 * ShowVisitor.
 */
public interface ShowVisitor {

	/**
	 * Parses and fetchs the gathered content of the visit,
	 * if the visit was done.
	 * @return The result of the visit.
	 */
	public String fetch();

	/**
	 * Visits the document.
	 * @param document Document to visit.
	 */
	public void visit( Document document );

	/**
	 * Visits the chapter.
	 * @param chapter Chapter to visit.
	 */
	public void visit( Chapter chapter );

	/**
	 * Visits the section.
	 * @param section Section to visit.
	 */
	public void visit( Section section );

	/**
	 * Visits the paragraph.
	 * @param paragraph Paragraph to visit.
	 */
	public void visit( Paragraph paragraph );

	/**
	 * Visits the sentence.
	 * @param sentence Sentence to visit.
	 */
	public void visit( Sentence sentence );

}