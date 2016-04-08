package jtools.action.shortcuts.preferences.editors;

import java.util.Arrays;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.preference.ListEditor;
import org.eclipse.swt.widgets.Composite;

public class ShortcutsListEditor extends ListEditor {

	
	
	public ShortcutsListEditor(String name, String labelText, Composite parent) {
		super(name, labelText, parent);

	}

	@Override
	protected String[] parseString(String stringList) {
        String[] list = stringList.split(";");
        Arrays.sort(list);
		return list;
	}
	
	@Override
	protected String getNewInputObject() {
		InputDialog input=new InputDialog(getShell(), "URL", "Enter a URL", "http://", null);
        input.open();
		return input.getValue();
	}
	
	@Override
	protected String createList(String[] items) {
		StringBuffer buf = new StringBuffer();
		for(int i=0;i<items.length;i++)
		{
			buf.append(items[i]).append(";");
			
		}
		return buf.toString();

	}
	

}
