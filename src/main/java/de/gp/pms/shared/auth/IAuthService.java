package de.gp.pms.shared.auth;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.gp.pms.shared.domain.auth.User;

@RemoteServiceRelativePath("AuthenticationService.rpc")
public interface IAuthService extends RemoteService {
	
	boolean isAuthenticated();

}
