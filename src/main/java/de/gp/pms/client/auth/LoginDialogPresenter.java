package de.gp.pms.client.auth;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.HasSelectHandlers;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

import de.gp.pms.client.Messages;

public class LoginDialogPresenter extends WidgetPresenter<LoginDialogView> {
	
	private final Messages msg = GWT.create(Messages.class);

	public LoginDialogPresenter(LoginDialogView display, EventBus eventBus) {
		super(display, eventBus);
	}

	public interface Display extends WidgetDisplay {

		HasSelectHandlers getLoginButton();
		
		HasValue<String> getUseridValue();
		
		HasValue<String> getPasswordValue();
		
		HasText getErrorValue();
	}

	@Override
	protected void onBind() {
		display.getLoginButton().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				display.getErrorValue().setText(msg.authenticate_failure());
			}
			
		});

	}

	@Override
	protected void onUnbind() {
	}

	@Override
	protected void onRevealDisplay() {
	}

}
