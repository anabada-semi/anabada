package anabada.semi.notice.model.dao;

import static anabada.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import anabada.semi.item.model.vo.Reply;
import anabada.semi.notice.model.vo.Notice;

public class NoticeDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public NoticeDAO () {
		String filePath = NoticeDAO.class.getResource("/anabada/semi/sql/notice-query.xml").getPath();
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 알림 테이블 조회
	 * @param loginMemberNo
	 * @param conn
	 * @return noticeList
	 * @throws Exception
	 */
	public List<Notice> selectNotice(int loginMemberNo, Connection conn) throws Exception{
		
		List<Notice> noticeList = new ArrayList<Notice>(); 
		
		try {
			String sql = prop.getProperty("selectNotice");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginMemberNo);
			pstmt.setInt(2, loginMemberNo);
			pstmt.setInt(3, loginMemberNo);
			pstmt.setInt(4, loginMemberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Notice notice = new Notice();
				
				notice.setNoticeNo(rs.getInt("NOTICE_NO"));
				notice.setNoticeContent(rs.getInt("NOTICE_CONTENT"));
				notice.setItemNo(rs.getInt("ITEM_NO"));
				notice.setShopNo(rs.getInt("SHOP_NO"));
				notice.setMemberNo(rs.getInt("MEMBER_NO"));
				notice.setReplyMemberNo(rs.getInt("REPLY_MEMBER_NO"));
				notice.setItemName(rs.getString("ITEM_NM"));
				
				noticeList.add(notice);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return noticeList;
	}

	/** 댓글 삽입시 알림 테이블 삽입
	 * @param notice
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int insertNotice(Notice notice, Connection conn) throws Exception{
		int result = 0; 
		
		try {
			String sql = prop.getProperty("insertNotice");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, notice.getNoticeContent());
			pstmt.setInt(2, notice.getItemNo());
			pstmt.setInt(3, notice.getShopNo());
			pstmt.setInt(4, notice.getMemberNo());
			pstmt.setInt(5, notice.getReplyMemberNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	
	
	
	
	
	
	
	
	
}
