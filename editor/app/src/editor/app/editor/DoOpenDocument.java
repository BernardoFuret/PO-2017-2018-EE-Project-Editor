package editor.app.editor;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

import editor.Editor;

import java.io.FileNotFoundException;
import editor.exceptions.DocumentOpenException;

/**
 * Class to handle opening Documents.
 */
public class DoOpenDocument extends Command<Editor> {

	/** Name of the document to open. */
	Input<String> _name;

	/**
	 * Opens a Document.
	 * @param editor The editor to perform the {@code open} operation.
	 */
	public DoOpenDocument( Editor editor ) {
		super( Labels.OPEN, editor );
		_name = _form.addStringInput( Messages.requestDocumentName() );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_form.parse();

		try {
			_receiver.open( _name.value() );
			_display.popup( Messages.openedDocument( _name.value() ) );
		} catch ( FileNotFoundException | DocumentOpenException fnfeDoe ) {
			_display.popup(
				Messages.openDocumentError(
					_name.value(),
					fnfeDoe.getMessage()
				)
			);
		}
	}

}
