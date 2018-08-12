package editor.app.paragraph;

/**
 * Messages.
 */
@SuppressWarnings( "nls" )
public final class Messages {

	/**
	 * @return A message stating the content is being retrieved from the Paragraph. 
	 */
	public static String showContent() {
		return "Conteúdo do Parágrafo:";
	}

	/**
	 * @param id The ID of the created Sentence.
	 * @return A notification about the creation of the Sentence with ID {@code id}.
	 */
	public static String createdSentence( long id ) {
		return "A Frase foi criada com o ID «" + id + "».";
	}

	/**
	 * @return A message requesting the ID of the Sentence.
	 */
	public static String requestSentenceId() {
		return "ID da Frase: ";
	}

	/**
	 * @param id An ID that doesn't belong to any Sentence.
	 * @return Warns there's no such Sentence with ID {@code id}.
	 */
	public static String noSuchSentence( long id ) {
		return "Não há nenhuma Frase com o ID «" + id + "».";
	}

	/**
	 * @param id The ID of the removed Sentence.
	 * @return A notification about the deletion of the Sentence with ID {@code id}.
	 */
	public static String removedSentence( long id ) {
		return "A Frase com o ID «" + id + "» foi apagada.";
	}

}
