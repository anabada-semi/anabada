package anabada.semi.member.model.service;

import static anabada.semi.common.JDBCTemplate.*;
import static anabada.semi.common.JDBCTemplate.close;
import static anabada.semi.common.JDBCTemplate.commit;
import static anabada.semi.common.JDBCTemplate.getConnection;
import static anabada.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;

import anabada.semi.member.model.dao.MemberDAO;
import anabada.semi.member.model.vo.Member;
import anabada.semi.shop.model.vo.Shop;

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

	

	/** 회원 탈퇴
	 * @param memberPw
	 * @param memberNo
	 * @return result(1성공)
	 * @throws Exception
	 */
	public int resignMember(String memberPw, int memberNo) throws Exception{
		
		int result = 0;
		
		Connection conn = getConnection();
		
		int result2 = dao.passwordChk(memberPw, conn);
		
		if(result2 > 0) {
			
			result = dao.resignMember(memberNo, conn);
			
			if(result > 0) commit(conn);
			else		   rollback(conn);
		}

		close(conn);
		
		return result;
		
	}


	public Shop selectShop(int memberNo) throws Exception {
		Connection conn = getConnection();
		
		Shop shop = dao.selectShop(memberNo, conn);
		
		close(conn);
		
		return shop;
	}


	public int createShop(int memberNo, String memberNm) throws Exception {
		Connection conn = getConnection();
		
		int createS = dao.createShop(memberNo, memberNm, conn);
		
		if(createS > 0) commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		return createS;
	}


	/** 아이디 중복 체크
	 * @param inputId
	 * @return result(1 중복)
	 * @throws Exception
	 */
	public int idDupCheck(String inputId) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.idDupCheck(inputId, conn);
		
		close(conn);
		
		return result;
	}


	
	/** 이메일 중복 체크
	 * @param inputEmail
	 * @return result(1 중복)
	 * @throws Exception
	 */
	public int EmailDupCheck(String inputEmail) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.emailDupCheck(inputEmail, conn);
		
		close(conn);
		
		return result;
	}


	
	/** 내 정보 수정
	 * @param member
	 * @return result(1 성공)
	 * @throws Exception
	 */
	public int myInfoModify(Member member) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.myInfoModify(member, conn);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);

		close(conn);
		
		return result;
	}


	
	/** 이메일로 회원 정보 얻기
	 * @param inputEmail
	 * @return member
	 * @throws Exception
	 */
	public Member updatePw(String inputEmail) throws Exception{
		
		Connection conn = getConnection();
		
		Member member = dao.updatePw(inputEmail, conn);
		
		close(conn);
		
		return member;
	}

}
