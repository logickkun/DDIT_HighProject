package kr.or.ddit.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomNoOpPasswordEncoder implements PasswordEncoder{
	
	private static final Logger log = LoggerFactory.getLogger(CustomNoOpPasswordEncoder.class);

	
	/*
	 *	kr.or.ddit.security.CustomNoOpPasswordEncoder 위치에 해당하는 클래스를 
	 * 	customPasswordEncoder 아이디로 빈 등록하고, security:authentication-manager 태그내에
	 *  인증 제공자를 등록합니다.
	 *  
	 *  >security:password-encoder ref="customPasswordEncoder"
	 * 
	 * */
	
	@Override
	public String encode(CharSequence rawPassword) {
		log.info("before encode : " + rawPassword);
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String encodedRawPassword = encode(rawPassword);
		log.info("matches : " + encodedRawPassword + " : " + encodedPassword);
		return encodedRawPassword.toString().equals(encodedPassword);
		
	}
	

}
