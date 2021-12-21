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
import anabada.semi.shop.model.vo.PostScript;
import anabada.semi.shop.model.vo.Shop;

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
				item.setItemPath(rs.getString(10));
				item.setItemImgName(rs.getString(11));
				
				item.setUploadDate(new Time().calculateTime(item.getItemDate()));
				itemList.add(item);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return itemList;
	}

	public List<PostScript> selectPostList(int shopNo, int memberNo, Connection conn) throws Exception {
		List<PostScript> pList = new ArrayList<PostScript>();
		try {
			String sql = prop.getProperty("selectPostList");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, shopNo);
//			pstmt.setInt(2, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostScript ps = new PostScript();
				ps.setPostScriptNo(rs.getInt(1));
				ps.setPostScriptCheck(rs.getString(2));
				ps.setShopNo(rs.getInt(3));
				ps.setMemberNo(rs.getInt(4));
				ps.setShopName(rs.getString(5));
				
				pList.add(ps);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return pList;
	}

	public int insertPostScript(int shopNo, int memberNo, String postScript, Connection conn) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("insertPostScript");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, postScript);
			pstmt.setInt(2, shopNo);// 어디에
			pstmt.setInt(3, memberNo);// 누가
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updatePostScript(int postNo, String postScript, Connection conn) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("updatePostScript");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, postScript);
			pstmt.setInt(2, postNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deletePostScript(int postNo, Connection conn) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("deletePostScript");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
}
