package de.gp.pms.shared.auth;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("AuthenticationService.rpc")
public interface IAuthService extends RemoteService {
	
	boolean isAuthenticated();

	void login(String userid, String password) throws AuthenticationFailedException;

}
