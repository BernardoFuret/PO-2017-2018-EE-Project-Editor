package editor.app.document;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;

import editor.Document;

import editor.app.DoShowContent;

/**
 * Class for the Document menu.
 */
public class DocumentMenu extends Menu {

	/**
	 * @param document The current Document.
	 */
	public DocumentMenu( Document document ) {
		super(
			Labels.TITLE,
			new Command<?>[] {
				new DoShowContent( document, Labels.SHOW, Messages.showContent() ),
				new DoAddChapter( document ),
				new DoGetChapter( document ),
				new DoRemoveTextElement( document ),
			}
		);
	}

}
