package editor.app.chapter;

/**
 * Messages.
 */
@SuppressWarnings( "nls" )
public final class Messages {

	/**
	 * @return A message stating the content is being retrieved from the Chapter. 
	 */
	public static String showContent() {
		return "Conteúdo do Capítulo:";
	}

	/**
	 * @return A message requesting the ID of the Section.
	 */
	public static String requestSectionId() {
		return "ID da Secção: ";
	}

	/**
	 * @param id An ID that doesn't belong to any Section.
	 * @return Warns there's no such Section with ID {@code id}.
	 */
	public static String noSuchSection( long id ) {
		return "Não há nenhuma Secção com o ID «" + id + "».";
	}

	/**
	 * @return A message requesting the title for the Section.
	 */
	public static String requestSectionTitle() {
		return "Título da Secção: ";
	}

	/**
	 * @param id The ID of the created Section.
	 * @param title The title of the created Section.
	 * @return A notification about the creation of the Section
	 * with title {@code title} and ID {@code id}.
	 */
	public static String createdSection( long id, String title ) {
		return "A Secção com título «" + title + "» foi criada com o ID «" + id + "».";
	}

}
