package de.gp.pms.client.auth;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.HasSelectHandlers;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

import de.gp.pms.client.Messages;
import de.gp.pms.client.auth.event.LoginEvent;
import de.gp.pms.shared.auth.IAuthServiceAsync;

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

		boolean validate();
	}

	@Override
	protected void onBind() {
		display.getLoginButton().addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				if (display.validate()) {
					IAuthServiceAsync authService = IAuthServiceAsync.Util
							.getInstance();
					authService.login(display.getUseridValue().getValue(),
							display.getPasswordValue().getValue(),
							new AsyncCallback<Void>() {

								@Override
								public void onFailure(Throwable caught) {
									display.getErrorValue().setText(
											msg.authenticate_failure());
								}

								@Override
								public void onSuccess(Void result) {
									eventBus.fireEvent(new LoginEvent());
									display.hide();
								}
							});
				}
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
