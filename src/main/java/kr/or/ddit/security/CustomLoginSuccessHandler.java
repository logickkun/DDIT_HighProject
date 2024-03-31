package kr.or.ddit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	private static final Logger log = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		log.info("## Login Success");
		
		User customUser = (User) authentication.getPrincipal();
		
		log.info("## username : " + customUser.getUsername());
		log.info("## password : " + customUser.getPassword());
		
		clearAuthenticationArrtibute(request);
		
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		
		String targetUrl = "/";
		
		if(savedRequest != null) {
			
			
			targetUrl = savedRequest.getRedirectUrl();
			
		}		
		
		
		log.info("Login Success targetUrl : " + targetUrl);
		response.sendRedirect(targetUrl);
		
	}

	private void clearAuthenticationArrtibute(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		if(session == null) {
			
			return;
			
		}
		
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

}
