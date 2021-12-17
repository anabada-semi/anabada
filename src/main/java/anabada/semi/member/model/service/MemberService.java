package anabada.semi.member.model.service;

import static anabada.semi.common.JDBCTemplate.*;

import java.sql.Connection;

import anabada.semi.member.model.dao.MemberDAO;
import anabada.semi.member.model.vo.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();
	
	public Member login(String memberId, String memberPw) throws Exception {
		
		Connection conn = getConnection();

		Member loginMember = dao.login(memberId, memberPw, conn);
		
		close(conn);
		
		return loginMember;
	}

}
