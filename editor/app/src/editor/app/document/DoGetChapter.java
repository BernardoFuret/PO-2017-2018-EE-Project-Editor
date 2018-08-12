package editor.app.document;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Menu;

import editor.Document;
import editor.Chapter;

import editor.app.chapter.ChapterMenu;

import editor.exceptions.NoSuchTextElementException;

/**
 * Class to get a Chapter belonging to the Document.
 */
public class DoGetChapter extends Command<Document> {

	/** Chapter ID to look for. */
	Input<Integer> _id;

	/**
	 * Gets a Chapter from the Document.
	 * @param document The Document to perform the {@code getChapter} operation.
	 */
	public DoGetChapter( Document document ) {
		super( Labels.GET_CHAPTER, document );
		_id = _form.addIntegerInput( Messages.requestChapterId() );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_form.parse();

		try {
			Chapter chapter = _receiver.getChapter( _id.value() );
			Menu menu = new ChapterMenu( chapter );
			menu.open();
		} catch ( NoSuchTextElementException nstee ) {
			_display.popup( Messages.noSuchChapter( _id.value() ) );
		}
	}

}
