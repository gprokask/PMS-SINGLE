package de.gp.pms.client;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.gp.pms.client.auth.LoginDialogPresenter;
import de.gp.pms.client.auth.LoginDialogView;
import de.gp.pms.client.auth.event.LoginEvent;
import de.gp.pms.shared.auth.IAuthServiceAsync;

public class PmsModuleEntry implements EntryPoint {

	private final EventBus eventBus;

	public PmsModuleEntry() {
		eventBus = new DefaultEventBus();
	}

	@Override
	public void onModuleLoad() {
		authenticateUser();
	}

	public void authenticateUser() {
		IAuthServiceAsync authService = IAuthServiceAsync.Util.getInstance();
		authService.isAuthenticated(new AsyncCallback<java.lang.Boolean>() {

			@Override
			public void onSuccess(java.lang.Boolean result) {
				if (result) {
					eventBus.fireEvent(new LoginEvent());
				} else {
					login();
				}
			}

			@Override
			public void onFailure(Throwable p_caught) {
				login();
			}
		});
	}

	private void login() {
		LoginDialogView view = new LoginDialogView();
		LoginDialogPresenter presenter = new LoginDialogPresenter(view,
				eventBus);
		presenter.bind();
		view.show();
	}
}
