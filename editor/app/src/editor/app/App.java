package editor.app;

import static pt.tecnico.po.ui.Dialog.IO;

import editor.Editor;

import editor.app.editor.EditorMenu;

/**
 * Editor application.
 */
public class App {

	@SuppressWarnings( "nls" )
	public static void main( String[] args ) {
		IO.setTitle( "Text Editor" );

		new EditorMenu( new Editor() ).open();

		IO.close();
	}

}