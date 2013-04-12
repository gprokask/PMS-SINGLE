package de.gp.pms.shared.auth;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.gp.pms.shared.domain.auth.User;

public interface IAuthServiceAsync {

	void isAuthenticated(AsyncCallback<java.lang.Boolean> callback);
	
	/**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util {
        private static IAuthServiceAsync instance;

        public static final IAuthServiceAsync getInstance() {
        	if (instance == null) {
                instance = (IAuthServiceAsync) GWT.create(IAuthService.class);
            }
            return instance;
        }

        private Util() {
            // Utility class should not be instanciated
        }
    }
}
