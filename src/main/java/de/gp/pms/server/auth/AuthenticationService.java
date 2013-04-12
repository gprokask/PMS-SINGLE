package de.gp.pms.server.auth;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.gp.pms.shared.auth.AuthenticationFailedException;
import de.gp.pms.shared.auth.IAuthService;

@WebServlet("/PmsModule/AuthenticationService.rpc")
public class AuthenticationService extends RemoteServiceServlet implements IAuthService {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(AuthenticationService.class);

	@Override
	public boolean isAuthenticated() {
		Principal userPrincipal = getThreadLocalRequest().getUserPrincipal();
		if (userPrincipal != null) {
		  return true;
		} else {
		  return false;
		}
	}

	@Override
	public void login(String userid, String password) throws AuthenticationFailedException {
		HttpServletRequest request = getThreadLocalRequest();
		if (request.getUserPrincipal() == null) {
	        try {
	            HttpSession session = request.getSession(false);
	            if (session != null) {
	                session.invalidate();
	            }
	            request.getSession();
	            request.login(userid.trim().toUpperCase(), password);
	        } catch (ServletException e) {
	        	LOGGER.error(e);
	            throw new AuthenticationFailedException();
	        }
		}
	}

}
