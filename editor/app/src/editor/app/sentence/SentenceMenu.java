package editor.app.sentence;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;

import editor.Sentence;

import editor.app.DoShowContent;

/**
 * Class for the Sentence menu.
 */
public class SentenceMenu extends Menu {

	/**
	 * @param sentence The current Sentence.
	 */
	public SentenceMenu( Sentence sentence ) {
		super(
			Labels.TITLE,
			new Command<?>[] {
				new DoShowContent( sentence, Labels.SHOW, Messages.showContent() ),
				new DoAddContent( sentence ),
			}
		);
	}

}
