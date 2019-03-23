package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class KeyManager{
	public void addKeyBinding(JComponent comp, int key, String id, ActionListener actionListner) {
		InputMap im = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		im.put(KeyStroke.getKeyStroke(key, 0,false), id);
		
		ActionMap am = comp.getActionMap();
		am.put(id, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionListner.actionPerformed(e);
			}
		});
	}
}
