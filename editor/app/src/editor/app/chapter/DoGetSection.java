package editor.app.chapter;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Menu;

import editor.Chapter;
import editor.Section;

import editor.app.section.SectionMenu;

import editor.exceptions.NoSuchTextElementException;

/**
 * Class to get a Section belonging to the Chapter.
 */
public class DoGetSection extends Command<Chapter> {

	/** Section ID to look for. */
	Input<Integer> _id;

	/**
	 * Gets a Section from the Chapter.
	 * @param chapter The Chapter to perform the {@code getSection} operation.
	 */
	public DoGetSection( Chapter chapter ) {
		super( Labels.GET_SECTION, chapter );
		_id = _form.addIntegerInput( Messages.requestSectionId() );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_form.parse();

		try {
			Section section = _receiver.getSection( _id.value() );
			Menu menu = new SectionMenu( section );
			menu.open();
		} catch ( NoSuchTextElementException nstee ) {
			_display.popup( Messages.noSuchSection( _id.value() ) );
		}
	}

}
