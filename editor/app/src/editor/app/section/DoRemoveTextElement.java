package editor.app.section;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

import editor.Section;

import editor.exceptions.NoSuchTextElementException;

/**
 * Class to remove a Text Element belonging to the Document.
 */
public class DoRemoveTextElement extends Command<Section> {

	/** ID of the Text Element to remove. */
	Input<Integer> _id;

	/**
	 * Removes a Text Element from the Section.
	 * @param section The Section to perform the {@code removeTextElement} operation.
	 */
	public DoRemoveTextElement( Section section ) {
		super( Labels.REMOVE_TEXT_ELEMENT, section );
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
