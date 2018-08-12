package editor.app.editor;

/**
 * Messages.
 */
@SuppressWarnings( "nls" )
public class Messages {

	/**
	 * @param user Name of the user currently using the editor
	 * @return A message notifying the Document was created. 
	 */
	public static String createdDocument( String user ) {
		return "Novo documento criado para o utilizador «" + user + "».";
	}

	/**
	 * @return String prompting for a document name.
	 */
	public static String requestDocumentName() {
		return "Nome do documento: ";
	}

	/**
	 * @param name The name of the Document that was opened. 
	 * @return Notifies that the Document with name {@code name}
	 * was successfully opened.
	 */
	public static String openedDocument( String name ) {
		return "Documento «" + name + "» aberto!";
	}

	/**
	 * @param name The name of the Document that couldn't be opened.
	 * @param reason Reason why the Document couldn't be opened. 
	 * @return Notifies that the Document with name {@code name}
	 * couldn't be opened due to reason {@code reason}.
	 */
	public static String openDocumentError( String name, String reason ) {
		return "Erro ao abrir documento «" + name + "»! Erro: «" + reason + "».";
	}

	/**
	 * @param name The name used to save the Document. 
	 * @return Notifies that the Document was saved.
	 */
	public static String savedDocument( String name ) {
		return "Documento guardado com o nome «" + name + "».";
	}

	/**
	 * @param name The name of the Document that couldn't be saved.
	 * @param reason Reason why the Document couldn't be saved. 
	 * @return Notifies that the Document with name {@code name}
	 * couldn't be saved due to reason {@code reason}.
	 */
	public static String saveDocumentError( String name, String reason ) {
		return "Erro ao guardar documento «" + name + "»! Erro: «" + reason + "».";
	}

	/**
	 * @return Requests a user name.
	 */
	public static String requestUser() {
		return "Nome de utilizador: ";
	}

	/**
	 * @return Notification about the user name being changed.
	 */
	public static String changedUser() {
		return "Nome de utilizador alterado.";
	}

}
