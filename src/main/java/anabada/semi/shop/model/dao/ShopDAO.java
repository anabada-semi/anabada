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
import anabada.semi.shop.model.vo.Purchase;
import anabada.semi.shop.model.vo.Shop;
import anabada.semi.shop.model.vo.Wish;

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

	public List<Wish> selectWsih(int shopNo, Connection conn) throws Exception {
		List<Wish> wList = new ArrayList<Wish>();
		try {
			String sql = prop.getProperty("selectWsih");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shopNo);
			
			rs = pstmt.executeQuery();
			// W.ITEM_NO, I.ITEM_NM, I.ITEM_PRICE, I.ITEM_DATE, E.IMG_PATH, IMG_NM
			while(rs.next()) {
				Wish w = new Wish();
				
				w.setItemNo(rs.getInt(1));
				w.setItemName(rs.getString(2));
				w.setItemPrice(rs.getString(3));
				w.setItemDate(rs.getTimestamp(4));
				w.setImgPath(rs.getString(5));
				w.setImgName(rs.getString(6));
				
				w.setUploadDate(new Time().calculateTime(w.getItemDate()));
				
				wList.add(w);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return wList;
	}

	public int deleteWish(int itemNo, int shopNo, Connection conn) throws Exception {
		int r = 0;
		try {
			String sql = prop.getProperty("deleteWish");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shopNo);
			pstmt.setInt(2, itemNo);
			
			r = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return r;
	}

	public List<Purchase> selectBuyItem(int shopNo, Connection conn) throws Exception {
		List<Purchase> pList = new ArrayList<Purchase>();
		
		try {
			String sql = prop.getProperty("selectBuyItem");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shopNo);
			
			rs = pstmt.executeQuery();
			
//			SELECT P.SHOP_NO PURCHASER, I.MEMBER_NO SELLER, P.ITEM_NO, P.ITEM_STATUS_CD, 
//		    I.ITEM_NM, I.ITEM_PRICE, I.ITEM_DATE, E.IMG_PATH, E.IMG_NM
			
			while(rs.next()) {
				Purchase p = new Purchase();
				
				p.setPurchaser(rs.getInt(1));
				p.setSeller(rs.getInt(2));
				p.setItemNo(rs.getInt(3));
				p.setItemStatusCode(rs.getInt(4));
				p.setItemName(rs.getString(5));
				p.setItemPrice(rs.getString(6));
				p.setItemDate(rs.getTimestamp(7));
				p.setItemImgPath(rs.getString(8));
				p.setItemImgName(rs.getString(9));
				
				p.setUploadDate(new Time().calculateTime(p.getItemDate()));
				
				pList.add(p);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return pList;
	}

	public List<Item> selectSellItem(int shopNo, Connection conn) throws Exception {
		List<Item> sList = new ArrayList<Item>();
		try {
			String sql = prop.getProperty("selectSellItem");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shopNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
//				ITEM_NO, ITEM_NM, ITEM_PRICE, ITEM_DATE, ITEM_STATUS_CD, IMG_PATH, IMG_NM
				Item i = new Item();
				i.setItemNo(rs.getInt(1));
				i.setItemName(rs.getString(2));
				i.setItemPrice(rs.getString(3));
				i.setItemDate(rs.getTimestamp(4));
				i.setItemStatusCode(rs.getInt(5));
				i.setItemPath(rs.getString(6));
				i.setItemImgName(rs.getString(7));
				
				i.setUploadDate(new Time().calculateTime(i.getItemDate()));
				
				sList.add(i);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return sList;
	}
	
	
}
