package kr.or.ddit.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.or.ddit.mapper.IMapper;
import kr.or.ddit.vo.CustomUser;
import kr.or.ddit.vo.MemberVO;

public class CustomUserDetailsService implements UserDetailsService{

	private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private IMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberVO member = null;
		
		try {
			
//			log.info("queried by member mapper : " + member);
			member = mapper.readByUserId(username);
			log.info("queried by member mapper : " + member);
			
			return member == null ? null : new CustomUser(member);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return null;
	}

}
