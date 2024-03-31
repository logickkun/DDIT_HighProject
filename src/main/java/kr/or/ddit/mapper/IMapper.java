package kr.or.ddit.mapper;


import kr.or.ddit.vo.MemberVO;

public interface IMapper {

	public MemberVO readByUserId(String username);

	public int signup(MemberVO mv);

	public void signupAuth(int memNo);


}
