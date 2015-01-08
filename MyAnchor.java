package edu.nebraska.lincoln.scid.wiki.ui.client.ideaspere.gui.participants;



import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Anchor;

public class MyAnchor extends Anchor {

	private static String LABEL_HREF = "href";
	private static String LABEL_TABINDEX = "tabindex";
	private String href = null;
	private String tabindex = null;
	private boolean enabled = true;

	public MyAnchor(String text) {
		super(text);
	}
	
	@Override
	public void onBrowserEvent(Event event) {
		switch (DOM.eventGetType(event)) {
			case Event.ONDBLCLICK:
			case Event.ONFOCUS:
			case Event.ONCLICK:
			case Event.ONMOUSEDOWN:
			case Event.ONMOUSEUP:
				if (!isEnabled()) {
					return;
				}
				break;
		}
		super.onBrowserEvent(event);
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		if(this.enabled != enabled)
		{
			this.enabled = enabled;
			if(enabled && href != null && tabindex != null)
			{
				this.getElement().setAttribute(LABEL_HREF, href);
				this.getElement().setAttribute(LABEL_TABINDEX, tabindex);
			}
			else
			{
				href = this.getElement().getAttribute(LABEL_HREF);
				this.getElement().removeAttribute(LABEL_HREF);
				tabindex = this.getElement().getAttribute(LABEL_TABINDEX);
				this.getElement().removeAttribute(LABEL_TABINDEX);
			}
		}
	}

	@Override
	public boolean isEnabled() {
		return enabled;
		this.get();
	}
}
