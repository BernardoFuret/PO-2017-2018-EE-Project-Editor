package editor.app.section;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;

import editor.Section;

import editor.app.DoShowContent;

/**
 * Class for the Section menu.
 */
public class SectionMenu extends Menu {

	/**
	 * @param section The current Section.
	 */
	public SectionMenu( Section section ) {
		super(
			Labels.TITLE,
			new Command<?>[] {
				new DoShowContent( section, Labels.SHOW, Messages.showContent() ),
				new DoAddSubSection( section ),
				new DoGetTextElement( section ),
				new DoAddParagraph( section ),
				new DoRemoveTextElement( section ),
			}
		);
	}

}
