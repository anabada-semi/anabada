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
		 * @return member
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
					
					loginMember.setMemberId(rs.getString("MEMBER_ID"));
					loginMember.setMemberPw(rs.getString("MEMBER_PW"));
					
				}
				
			}finally{
				close(rs);
				close(pstmt);
			}
			
			return loginMember;
		}
	
}
