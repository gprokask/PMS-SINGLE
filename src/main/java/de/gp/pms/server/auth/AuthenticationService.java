package de.gp.pms.server.auth;

import java.security.Principal;

import javax.servlet.annotation.WebServlet;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.gp.pms.shared.auth.IAuthService;

@WebServlet("/PmsModule/AuthenticationService.rpc")
public class AuthenticationService extends RemoteServiceServlet implements IAuthService {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean isAuthenticated() {
		Principal userPrincipal = getThreadLocalRequest().getUserPrincipal();
		if (userPrincipal != null) {
		  return true;
		} else {
		  return false;
		}
	}

}
