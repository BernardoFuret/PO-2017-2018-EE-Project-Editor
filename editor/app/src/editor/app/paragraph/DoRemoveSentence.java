package editor.app.paragraph;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

import editor.Paragraph;

import editor.exceptions.NoSuchTextElementException;

/**
 * Class to remove a Sentence belonging to the Paragraph.
 */
public class DoRemoveSentence extends Command<Paragraph> {

	/** ID of the Sentence to remove. */
	Input<Integer> _id;

	/**
	 * Removes a Sentence from the Paragraph.
	 * @param paragraph The Paragraph to perform the {@code removeSentence} operation.
	 */
	public DoRemoveSentence( Paragraph paragraph ) {
		super( Labels.REMOVE_SENTENCE, paragraph );
		_id = _form.addIntegerInput( Messages.requestSentenceId() );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_form.parse();

		try {
			_receiver.removeSentence( _id.value() );
			_display.popup( Messages.removedSentence( _id.value() ) );
		} catch ( NoSuchTextElementException nstee ) {
			_display.popup( Messages.noSuchSentence( _id.value() ) );
		}
	}

}
