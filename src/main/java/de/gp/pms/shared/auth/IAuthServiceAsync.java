package de.gp.pms.shared.auth;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IAuthServiceAsync {

	void isAuthenticated(AsyncCallback<java.lang.Boolean> callback);
	
	void login(String userid, String p_password, AsyncCallback<Void> callback);
	
	void logout(AsyncCallback<Void> callback);
	
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
