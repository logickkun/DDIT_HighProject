package kr.or.ddit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.service.IService;
import kr.or.ddit.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private IService service;
	
	
	@GetMapping("/signup")
	public String signUpForm() {
		
		return "security/signup";
		
	}
	
	
	@PostMapping("/signup")
	public String signUp(MemberVO mv) {
		
		int pass = service.signup(mv);
		
		if(pass > 0) {
			
			return "security/login";
			
		}else {
			
			return "security/failure";
			0
			
		}
		
		
	}
	
	
	@GetMapping("/login")
	public String loginForm() {
		
		return "security/login";
	}
	
	
	@PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")
	@GetMapping("/success")
	public String successForm() {
		
		return "security/success";
		
	}
	
	public String member() {
		
		System.out.println("머지했어요");
		
		return null;
		
	
}
