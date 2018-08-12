package editor.app.section;

import pt.tecnico.po.ui.Command;

import editor.Section;
import editor.Paragraph;

/**
 * Class to add a Paragraph to the Section.
 */
public class DoAddParagraph extends Command<Section> {

	/**
	 * Adds a Paragraph to the Section.
	 * @param section The Section to perform the {@code addParagraph} operation.
	 */
	public DoAddParagraph( Section section ) {
		super( Labels.ADD_PARAGRAPH, section );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		Paragraph paragraph = _receiver.addParagraph();

		_display.popup(	Messages.createdParagraph( paragraph.getId() ) );
	}

}
