package anabada.semi.member.model.dao;

import static anabada.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import anabada.semi.member.model.dao.MemberDAO;
import anabada.semi.member.model.vo.Member;
import anabada.semi.shop.model.vo.Shop;

public class MemberDAO {
	
	// JDBC 객체 참조 변수
		private Statement stmt;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		// XML에 작성된 SQL을 얻어와 저장할 Collection 객체 참조 변수 선언
		private Properties prop;
		// Properties : key, value가 모두 String인 Map
		
		public MemberDAO() { // 기본 생성자
			
			
			// DAO 객체 생성 시 특정 위치에 있는 XML 파일을 읽어와 prop에 저장
			try {
				prop = new Properties();
				
				String filePath 
				= MemberDAO.class.getResource("/anabada/semi/sql/member-query.xml").getPath();     
				// -> SQL이 작성된 XML 파일의 경로
				
				prop.loadFromXML( new FileInputStream( filePath ) );
			}catch (Exception e) {
				e.printStackTrace();
			}

			
		}

		
		/** 로그인
		 * @param memberId
		 * @param memberPw
		 * @param conn
		 * @return loginMember
		 * @throws Exception
		 */
		public Member login(String memberId, String memberPw, Connection conn) throws Exception{

			Member loginMember = null;
			
			try {
				
				String sql = prop.getProperty("login");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberId);
				pstmt.setString(2, memberPw);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
				
					loginMember = new Member();
					
					loginMember.setMemberNo(rs.getInt("MEMBER_NO"));
					loginMember.setMemberId(memberId);
					loginMember.setMemberPw(memberPw);
					loginMember.setMemberNm(rs.getString("MEMBER_NM"));
					loginMember.setMemberEmail(rs.getString("MEMBER_EMAIL"));
					loginMember.setMemberPhone(rs.getString("MEMBER_PHONE"));
					loginMember.setMemberAddress(rs.getString("ADDRESS"));
					loginMember.setEnrollDate(rs.getString("ENROLL_DATE"));
					
				}
				
			}finally{
				close(rs);
				close(pstmt);
			}
			
			return loginMember;
		}


		/** 회원가입
		 * @param member
		 * @param conn
		 * @return result(1성공)
		 * @throws Exception
		 */
		public int signUp(Member member, Connection conn) throws Exception{
			
			int result = 0;
			
			try {
				String sql = prop.getProperty("signUp");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, member.getMemberId());
				pstmt.setString(2, member.getMemberPw());
				pstmt.setString(3, member.getMemberNm());
				pstmt.setString(4, member.getMemberEmail());
				pstmt.setString(5, member.getMemberPhone());
				pstmt.setString(6, member.getMemberAddress());
				
				result = pstmt.executeUpdate();
				
			}finally {
				close(pstmt);
			}
			
			return result;
		}


		
		/** 비밀번호 확인
		 * @param memberPw
		 * @param conn
		 * @return 1(일치)
		 * @throws Exception
		 */
		public int passwordChk(String memberPw, Connection conn) throws Exception{

			int result2 = 0;
			
			try {
				
				String sql = prop.getProperty("passwordChk");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberPw);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result2 = rs.getInt(1);
				}
				
			}finally {
				close(rs);
				close(pstmt);
			}
			
			return result2;
		}
	
		
		
		/** 회원 탈퇴
		 * @param memberNo
		 * @param conn
		 * @return result(1성공)
		 * @throws Exception
		 */
		public int resignMember(int memberNo, Connection conn) throws Exception{
			
			int result = 0;
			
			try {
				
			String sql = prop.getProperty("resignMember");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			result = pstmt.executeUpdate();
			
			}finally {
				close(pstmt);
			}
			
			return result;
		}


		public Shop selectShop(int memberNo, Connection conn) throws Exception {
			Shop shop = null;
			try {
				String sql = prop.getProperty("selectShop");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, memberNo);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
					shop = new Shop();
					shop.setMemberNo(memberNo);
					shop.setShopIntroduce(rs.getString("SHOP_INTRODUCE"));
					shop.setShopName(rs.getString("SHOP_NM"));
				}
			} finally {
				close(rs);
				close(pstmt);
			}
			return shop;
		}


		public int createShop(int memberNo, String memberNm, Connection conn) throws Exception {
			int createS = 0;
			try {
				String sql = prop.getProperty("createShop");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, memberNo);
				pstmt.setString(2, memberNm);
				
				createS = pstmt.executeUpdate();
				
			} finally {
				close(pstmt);
			}
			return createS;
		}


		
		/** 아이디 중복 체크
		 * @param inputId
		 * @param conn
		 * @return result(1 중복)
		 * @throws Exception
		 */
		public int idDupCheck(String inputId, Connection conn) throws Exception{
			
			int result = 0;
			
			try{
				String sql = prop.getProperty("idDupCheck");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, inputId);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt(1);
				}
				
				
			}finally {
				close(rs);
				close(pstmt);
			}
			
			return result;
		}


		/** 이메일 중복 체크
		 * @param inputEmail
		 * @param conn
		 * @return result(1 중복)
		 * @throws Exception
		 */
		public int emailDupCheck(String inputEmail, Connection conn) throws Exception {
			
			int result = 0;
			
			try {
				
				String sql = prop.getProperty("emailDupCheck");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, inputEmail);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt(1);
				}
				
			}finally {
				close(rs);
				close(pstmt);
			}
			
			return result;
			
		}


		/** 내 정보 수정
		 * @param member
		 * @param conn
		 * @return result(1 성공)
		 * @throws Exception
		 */
		public int myInfoModify(Member member, Connection conn) throws Exception {

			int result = 0;
			
			try {
				
				String sql = prop.getProperty("myInfoModify");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, member.getMemberPw());
				pstmt.setString(2, member.getMemberNm());
				pstmt.setString(3, member.getMemberEmail());
				pstmt.setString(4, member.getMemberPhone());
				pstmt.setString(5, member.getMemberAddress());
				pstmt.setInt(6, member.getMemberNo());
				
				result = pstmt.executeUpdate();
				
				
			}finally {
				close(pstmt);
			}
			
			return result;
		}



}
