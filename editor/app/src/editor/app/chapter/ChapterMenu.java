package editor.app.chapter;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;

import editor.Chapter;

import editor.app.DoShowContent;

/**
 * Class for the Chapter menu.
 */
public class ChapterMenu extends Menu {

	/**
	 * @param chapter The current Chapter.
	 */
	public ChapterMenu( Chapter chapter ) {
		super(
			Labels.TITLE,
			new Command<?>[] {
				new DoShowContent( chapter, Labels.SHOW, Messages.showContent() ),
				new DoAddSection( chapter ),
				new DoGetSection( chapter ),
			}
		);
	}

}
