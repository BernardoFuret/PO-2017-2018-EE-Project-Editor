package editor.app.document;

/**
 * Messages.
 */
@SuppressWarnings( "nls" )
public final class Messages {

	/**
	 * @return A message stating the content is being retrieved from the Document. 
	 */
	public static String showContent() {
		return "Conteúdo do Documento:";
	}

	/**
	 * @return A message requesting the ID of the Chapter.
	 */
	public static String requestChapterId() {
		return "ID do Capítulo: ";
	}

	/**
	 * @param id An ID that doesn't belong to any Chapter.
	 * @return Warns there's no such Chapter with ID {@code id}.
	 */
	public static String noSuchChapter( long id ) {
		return "Não há nenhum Capítulo com o ID «" + id + "».";
	}

	/**
	 * @return A message requesting the title of the Chapter.
	 */
	public static String requestChapterTitle() {
		return "Título do Capítulo: ";
	}

	/**
	 * @param id The ID of the created Chapter.
	 * @param title The title of the created Chapter.
	 * @return A notification about the creation of the Chapter
	 * with title {@code title} and ID {@code id}.
	 */
	public static String createdChapter( long id, String title ) {
		return "O Capítulo com título «" + title + "» foi criado com o ID «" + id + "».";
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
	 * @param id The ID of the removed Text Element.
	 * @return A notification about the deletion of the
	 * Text Element with ID {@code id}.
	 */
	public static String removedTextElement( long id ) {
		return "O Elemento de Texto com o ID «" + id + "» foi apagado.";
	}

}
