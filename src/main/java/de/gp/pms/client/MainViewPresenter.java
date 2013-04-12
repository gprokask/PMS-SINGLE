package de.gp.pms.client;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import de.gp.pms.client.MainViewPresenter.Display;

public class MainViewPresenter extends WidgetPresenter<Display> {

	public MainViewPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
	}

	public interface Display extends WidgetDisplay {
		
	}

	@Override
	protected void onBind() {
	}

	@Override
	protected void onUnbind() {
	}

	@Override
	protected void onRevealDisplay() {
	}
}
