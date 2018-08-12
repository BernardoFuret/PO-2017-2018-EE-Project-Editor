package editor.app.editor;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

import editor.Editor;

/**
 * Class to change the current user using the Editor.
 */
public class DoChangeUser extends Command<Editor> {

	/** New use name. */
	Input<String> _user;

	/**
	 * Changes user.
	 * @param editor The editor whose user will be changed.
	 */
	public DoChangeUser( Editor editor ) {
		super( Labels.CHANGE_USER, editor );
		_user = _form.addStringInput( Messages.requestUser() );
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_form.parse();

		_receiver.setUser( _user.value() );

		_display.popup( Messages.changedUser() );
	}

}
