package editor.app.section;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Menu;

import editor.Section;
import editor.TextElement;
import editor.Paragraph;

import editor.app.paragraph.ParagraphMenu;

import editor.exceptions.NoSuchTextElementException;

/**
 * Class to get a Text Element belonging to the Section.
 */
public class DoGetTextElement extends Command<Section> {

	/** Chapter ID to look for. */
	Input<Integer> _id;

	/**
	 * Gets a Text Element (Paragraph or Sub-Section) from the Section.
	 * @param section The Section to perform the {@code getTextElement} operation.
	 */
	public DoGetTextElement( Section section ) {
		super( Labels.GET_TEXT_ELEMENT, section );
		_id = _form.addIntegerInput( Messages.requestTextElementId() );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_form.parse();

		try {
			TextElement element = _receiver.getTextElement( _id.value() );
			Menu menu = ( element instanceof Section
				? new SectionMenu( (Section) element )
				: new ParagraphMenu( (Paragraph) element )
			);
			menu.open();
		} catch ( NoSuchTextElementException nstee ) {
			_display.popup( Messages.noSuchTextElement( _id.value() ) );
		}
	}

}
