package editor.app.section;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

import editor.Section;

/**
 * Class to add a Sub-Section to the Section.
 */
public class DoAddSubSection extends Command<Section> {

	/** Section title. */
	Input<String> _title;

	/**
	 * Adds a Sub-Section to the Section.
	 * @param section The Section to perform the {@code addSection} operation.
	 */
	public DoAddSubSection( Section section ) {
		super( Labels.ADD_SECTION, section );
		_title = _form.addStringInput( Messages.requestSubSectionTitle() );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_form.parse();

		Section section = _receiver.addSection( _title.value() );

		_display.popup(
			Messages.createdSubSection(
				section.getId(),
				section.getTitle()
			)
		);
	}

}
