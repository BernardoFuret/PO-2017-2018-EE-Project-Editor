package editor.app.paragraph;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

import editor.Paragraph;
import editor.Sentence;

/**
 * Class to add a Sentence to the Paragraph.
 */
public class DoAddSentence extends Command<Paragraph> {

	/**
	 * Adds a Sentence to the Paragraph.
	 * @param paragraph The Paragraph to perform the {@code addSentence} operation.
	 */
	public DoAddSentence( Paragraph paragraph ) {
		super( Labels.ADD_SENTENCE, paragraph );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		Sentence sentence = _receiver.addSentence();

		_display.popup(	Messages.createdSentence( sentence.getId() ) );
	}

}
