package editor.app.paragraph;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;

import editor.Paragraph;

import editor.app.DoShowContent;

/**
 * Class for the Paragraph menu.
 */
public class ParagraphMenu extends Menu {

	/**
	 * @param paragraph The current Paragraph.
	 */
	public ParagraphMenu( Paragraph paragraph ) {
		super(
			Labels.TITLE,
			new Command<?>[] {
				new DoShowContent( paragraph, Labels.SHOW, Messages.showContent() ),
				new DoAddSentence( paragraph ),
				new DoGetSentence( paragraph ),
				new DoRemoveSentence( paragraph ),
			}
		);
	}

}
