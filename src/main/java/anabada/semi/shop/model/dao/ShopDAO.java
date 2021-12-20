package anabada.semi.shop.model.dao;

import static anabada.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ShopDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ShopDAO() {                           
		String filePath = ShopDAO.class.getResource("/anabada/semi/sql/shop-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int updateShopName(String inputName, int memberNo, Connection conn) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("updateShopName");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputName);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateShopContent(String inputContent, int memberNo, Connection conn) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("updateShopContent");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputContent);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}
}
