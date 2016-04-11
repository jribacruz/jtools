package jtools.action.shortcuts.model;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class BookmarkLinkModel implements SelectionListener {

	private Composite composite;

	private Link link;

	private String url;

	public BookmarkLinkModel(Composite composite, String url) {
		super();
		this.composite = composite;
		this.url = url;
		this.init();
	}

	private void init() {
		this.link = new Link(composite, SWT.NULL);
		this.link.setText( "<A>" + url + "</A>");
		this.link.addSelectionListener(this);
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {

	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		try {
			PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser().openURL(new URL(this.url));
		} catch (PartInitException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
