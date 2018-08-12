package editor.app.sentence;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

import editor.Sentence;

/**
 * Class to add content to a Sentence.
 */
public class DoAddContent extends Command<Sentence> {

	/** Sentence content. */
	Input<String> _content;

	/**
	 * Adds content to the Sentence.
	 * @param sentence The Sentence to perform the {@code addContent} operation.
	 */
	public DoAddContent( Sentence sentence ) {
		super( Labels.ADD_CONTENT, sentence );
		_content = _form.addStringInput( Messages.requestSentenceContent() );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_form.parse();

		_receiver.addContent( _content.value() );

		_display.popup(	Messages.addedContent() );
	}

}
