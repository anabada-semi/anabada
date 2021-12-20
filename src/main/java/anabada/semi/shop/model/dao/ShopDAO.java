package anabada.semi.shop.model.dao;

import static anabada.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import anabada.semi.item.model.vo.Item;
import anabada.semi.item.model.vo.Time;

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

	public List<Item> selectItem(int memberNo, Connection conn) throws Exception {
		List<Item> itemList = new ArrayList<Item>();
		
		try {
			String sql = prop.getProperty("selectItem");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Item item = new Item();
				item.setItemNo(rs.getInt(1));
				item.setItemName(rs.getString(2));
				item.setItemPrice(rs.getString(3));
				item.setItemInfo(rs.getString(4));
				item.setItemDate(rs.getTimestamp(5));
				item.setCategoryCode(rs.getInt(6));
				item.setItemStatusCode(rs.getInt(7));
				item.setMemberNo(rs.getInt(8));
				item.setReadCount(rs.getInt(9));
				
				item.setUploadDate(new Time().calculateTime(item.getItemDate()));
				itemList.add(item);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return itemList;
	}
}
