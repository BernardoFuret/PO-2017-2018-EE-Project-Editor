package editor.app.editor;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

import editor.Editor;

import editor.exceptions.DocumentSaveException;

/**
 * Class to handle saving Documents.
 */
public class DoSaveDocument extends Command<Editor> {

	/** Name that will be used to save the document. */
	Input<String> _name;

	/**
	 * Saves a Document.
	 * @param editor The editor to perform the {@code save} operation.
	 */
	public DoSaveDocument( Editor editor ) {
		super( Labels.SAVE, editor );
		_name = _form.addStringInput( Messages.requestDocumentName() );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_form.parse();

		try {
			_receiver.save( _name.value() );
			_display.popup( Messages.savedDocument( _name.value() ) );
		} catch ( DocumentSaveException dse ) {
			_display.popup(
				Messages.saveDocumentError(
					_name.value(),
					dse.getMessage()
				)
			);
		}
	}

}
