package editor.app.editor;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;

import editor.Editor;

/**
 * Class for the main menu; the Editor menu.
 */
public class EditorMenu extends Menu {

	/**
	 * @param editor The Editor itself.
	 */
	public EditorMenu( Editor editor ) {
		super(
			Labels.TITLE,
			new Command<?>[] {
				new DoNewDocument( editor ),
				new DoOpenDocument( editor ),
				new DoSaveDocument( editor ),
				new DoChangeUser( editor ),
				new DoOpenDocumentMenu( editor ),
			}
		);
	}

}
