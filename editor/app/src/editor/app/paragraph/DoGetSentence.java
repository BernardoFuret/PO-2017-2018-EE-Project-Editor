package editor.app.paragraph;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Menu;

import editor.Paragraph;
import editor.Sentence;

import editor.app.sentence.SentenceMenu;

import editor.exceptions.NoSuchTextElementException;

/**
 * Class to get a Sentence belonging to the Paragraph.
 */
public class DoGetSentence extends Command<Paragraph> {

	/** Sentence ID to look for. */
	Input<Integer> _id;

	/**
	 * Gets a Sentence from the Paragraph.
	 * @param paragraph The Paragraph to perform the {@code getSentence} operation.
	 */
	public DoGetSentence( Paragraph paragraph ) {
		super( Labels.GET_SENTENCE, paragraph );
		_id = _form.addIntegerInput( Messages.requestSentenceId() );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_form.parse();

		try {
			Sentence sentence = _receiver.getSentence( _id.value() );
			Menu menu = new SentenceMenu( sentence );
			menu.open();
		} catch ( NoSuchTextElementException nstee ) {
			_display.popup( Messages.noSuchSentence( _id.value() ) );
		}
	}

}
