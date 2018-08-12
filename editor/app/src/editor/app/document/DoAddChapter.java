package editor.app.document;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

import editor.Document;
import editor.Chapter;

/**
 * Class to add a Chapter to the Document.
 */
public class DoAddChapter extends Command<Document> {

	/** Chapter title. */
	Input<String> _title;

	/**
	 * Adds a Chapter to the Document.
	 * @param document The Document to perform the {@code addChapter} operation.
	 */
	public DoAddChapter( Document document ) {
		super( Labels.ADD_CHAPTER, document );
		_title = _form.addStringInput( Messages.requestChapterTitle() );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_form.parse();

		Chapter chapter = _receiver.addChapter( _title.value() );

		_display.popup(
			Messages.createdChapter(
				chapter.getId(),
				chapter.getTitle()
			)
		);
	}

}
