package de.gp.pms.client;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.sencha.gxt.widget.core.client.menu.Item;

import de.gp.pms.client.MainViewPresenter.Display;
import de.gp.pms.client.auth.event.LogoutEvent;

public class MainViewPresenter extends WidgetPresenter<Display> {

	public MainViewPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
	}

	public interface Display extends WidgetDisplay {
		HasSelectionHandlers<Item> getLogoutMenuItem();
	}

	@Override
	protected void onBind() {
		addLogoutButtonHandler();
	}

	@Override
	protected void onUnbind() {
	}

	@Override
	protected void onRevealDisplay() {
	}
	
	private void addLogoutButtonHandler() {
		display.getLogoutMenuItem().addSelectionHandler(new SelectionHandler<Item>() {

			@Override
			public void onSelection(SelectionEvent<Item> event) {
				eventBus.fireEvent(new LogoutEvent());
			}
			
		});
    }
}
