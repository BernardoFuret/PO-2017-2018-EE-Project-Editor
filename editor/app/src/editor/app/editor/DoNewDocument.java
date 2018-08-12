package editor.app.editor;

import pt.tecnico.po.ui.Command;

import editor.Editor;

/**
 * Class to handle creating new Documents.
 */
public class DoNewDocument extends Command<Editor> {

	/**
	 * Creates a new Document.
	 * @param editor The editor to perform the {@code create} operation.
	 */
	public DoNewDocument( Editor editor ) {
		super( Labels.NEW, editor );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_receiver.create();
		_display.popup( Messages.createdDocument( _receiver.getUser() ) );
	}

}
