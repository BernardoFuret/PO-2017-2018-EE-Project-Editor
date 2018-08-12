package editor.app.editor;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;

import editor.Editor;
import editor.Document;

import editor.app.document.DocumentMenu;

/**
 * Class to open the current Document menu.
 */
public class DoOpenDocumentMenu extends Command<Editor> {

	/**
	 * Opens the Document menu.
	 * @param editor The editor with the Document open.
	 */
	public DoOpenDocumentMenu( Editor editor ) {
		super( Labels.DOCUMENT_MENU, editor );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		Menu menu = new DocumentMenu( _receiver.getDocument() );
		menu.open();
	}

}
