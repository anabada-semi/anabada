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

	public List<Notice> selectNotice(int loginMemberNo, Connection conn) throws Exception{
		
		List<Notice> noticeList = new ArrayList<Notice>(); 
		
		try {
			String sql = prop.getProperty("selectNotice");
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Notice notice = new Notice();
				
				
				
				
				
				
			}
			
		} finally {
			// TODO: handle finally clause
		}
		
		
		return noticeList;
	}

	public int insertNotice(Notice notice, Connection conn) throws Exception{
		int result = 0; 
		
		try {
			String sql = prop.getProperty("insertNotice");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, notice.getNoticeContent());
			pstmt.setInt(2, notice.getItemNo());
			pstmt.setInt(3, notice.getShopNo());
			pstmt.setInt(3, notice.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	
	
	
	
	
	
	
	
	
}
