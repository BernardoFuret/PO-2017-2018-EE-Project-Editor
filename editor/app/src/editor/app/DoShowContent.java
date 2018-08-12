package editor.app;

import pt.tecnico.po.ui.Command;

import editor.TextElement;
import editor.ShowXMLVisitor;

/**
 * Class to show the TextElement content.
 */
public class DoShowContent extends Command<TextElement> {

	/** The message to display when printing the {@code TextElement} content. */
	private final String _message;

	/**
	 * Shows the TextElement content.
	 * @param element The TextElement to perform the {@code show} operation.
	 */
	public DoShowContent( TextElement element, String label, String message ) {
		super( label, element );
		_message = message;
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_display
			.addLine( _message )
			.addLine( _receiver.show( new ShowXMLVisitor() ) )
			.display()
		;
	}

}
