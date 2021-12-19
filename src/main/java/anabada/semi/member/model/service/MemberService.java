package anabada.semi.member.model.service;

import static anabada.semi.common.JDBCTemplate.*;
import static anabada.semi.common.JDBCTemplate.close;
import static anabada.semi.common.JDBCTemplate.commit;
import static anabada.semi.common.JDBCTemplate.getConnection;
import static anabada.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;

import anabada.semi.member.model.dao.MemberDAO;
import anabada.semi.member.model.vo.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();
	
	/** 로그인
	 * @param memberId
	 * @param memberPw
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(String memberId, String memberPw) throws Exception {
		
		Connection conn = getConnection();

		Member loginMember = dao.login(memberId, memberPw, conn);
		
		close(conn);
		
		return loginMember;
	}

	
	/** 회원 가입
	 * @param member
	 * @return result(1성공)
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception{

		Connection conn = getConnection();
		
		int result = dao.signUp(member, conn);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);

		close(conn);
		
		return result;
		
	}

}
