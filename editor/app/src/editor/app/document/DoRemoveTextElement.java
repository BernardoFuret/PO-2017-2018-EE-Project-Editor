package editor.app.document;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

import editor.Document;

import editor.exceptions.NoSuchTextElementException;

/**
 * Class to remove a Text Element belonging to the Document.
 */
public class DoRemoveTextElement extends Command<Document> {

	/** ID of the Text Element to remove. */
	Input<Integer> _id;

	/**
	 * Removes a Text Element from the Document.
	 * @param document The Document to perform the {@code removeTextElement} operation.
	 */
	public DoRemoveTextElement( Document document ) {
		super( Labels.REMOVE_TEXT_ELEMENT, document );
		_id = _form.addIntegerInput( Messages.requestTextElementId() );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_form.parse();

		try {
			_receiver.removeTextElement( _id.value() );
			_display.popup( Messages.removedTextElement( _id.value() ) );
		} catch ( NoSuchTextElementException nstee ) {
			_display.popup( Messages.noSuchTextElement( _id.value() ) );
		}
	}

}
