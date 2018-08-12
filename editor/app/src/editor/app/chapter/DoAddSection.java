package editor.app.chapter;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

import editor.Chapter;
import editor.Section;

/**
 * Class to add a Section to the Chapter.
 */
public class DoAddSection extends Command<Chapter> {

	/** Section title. */
	Input<String> _title;

	/**
	 * Adds a Section to the Chapter.
	 * @param chapter The Chapter to perform the {@code addSection} operation.
	 */
	public DoAddSection( Chapter chapter ) {
		super( Labels.ADD_SECTION, chapter );
		_title = _form.addStringInput( Messages.requestSectionTitle() );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_form.parse();

		Section section = _receiver.addSection( _title.value() );

		_display.popup(
			Messages.createdSection(
				section.getId(),
				section.getTitle()
			)
		);
	}

}
