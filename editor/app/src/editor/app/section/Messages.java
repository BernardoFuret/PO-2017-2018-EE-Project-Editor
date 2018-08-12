package editor.app.section;

/**
 * Messages.
 */
@SuppressWarnings( "nls" )
public final class Messages {

	/**
	 * @return A message stating the content is being retrieved from the Section. 
	 */
	public static String showContent() {
		return "Conteúdo da Secção:";
	}

	/**
	 * @return A message requesting the title of the Chapter.
	 */
	public static String requestSubSectionTitle() {
		return "Título da Sub-Secção: ";
	}

	/**
	 * @param id The ID of the created Sub-Section.
	 * @param title The title of the created Sub-Section.
	 * @return A notification about the creation of the Sub-Section
	 * with title {@code title} and ID {@code id}.
	 */
	public static String createdSubSection( long id, String title ) {
		return "A Sub-Secção com título «" + title + "» foi criada com o ID «" + id + "».";
	}

	/**
	 * @return A message requesting the ID of the Text Element.
	 */
	public static String requestTextElementId() {
		return "ID do Elemento de Texto: ";
	}

	/**
	 * @param id An ID that doesn't belong to any Text Element.
	 * @return Warns there's no such Text Element with ID {@code id}.
	 */
	public static String noSuchTextElement( long id ) {
		return "Não há nenhum Elemento de Texto com o ID «" + id + "».";
	}

	/**
	 * @param id The ID of the created Paragraph.
	 * @return A notification about the creation of the Paragraph with ID {@code id}.
	 */
	public static String createdParagraph( long id ) {
		return "O Parágrafo foi criado com o ID «" + id + "».";
	}

	/**
	 * @param id The ID of the removed Text Element.
	 * @return A notification about the deletion of the
	 * Text Element with ID {@code id}.
	 */
	public static String removedTextElement( long id ) {
		return "O Elemento de Texto com o ID «" + id + "» foi apagado.";
	}

}
