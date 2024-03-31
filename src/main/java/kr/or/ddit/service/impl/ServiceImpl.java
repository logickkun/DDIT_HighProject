package kr.or.ddit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.IMapper;
import kr.or.ddit.service.IService;
import kr.or.ddit.vo.MemberVO;

@Service
public class ServiceImpl implements IService{
	
	@Autowired
	private IMapper mapper;
	
	@Autowired
	private PasswordEncoder pe;

	@Override
	public int signup(MemberVO mv) {
		
		mv.setMemPw(pe.encode(mv.getMemPw()));
		
		int pass = mapper.signup(mv);
		
		if(pass >0) {
			
			mapper.signupAuth(mv.getMemNo());
			
			return pass;
		
		}else {
			
			return pass;
			
		}
		
	}
}
