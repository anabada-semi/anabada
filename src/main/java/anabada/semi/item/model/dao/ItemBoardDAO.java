package anabada.semi.item.model.dao;

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
import anabada.semi.item.model.vo.ItemImg;
import anabada.semi.item.model.vo.Pagination;
import anabada.semi.item.model.vo.Time;

public class ItemBoardDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public ItemBoardDAO () {
		String filePath = ItemDAO.class.getResource("/anabada/semi/sql/itemBoard-query.xml").getPath();

		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	/** 전체 글 수
	 * @param conn
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn) throws Exception{
		
		int listCount = 0;
		
		try {
			
			String sql = prop.getProperty("listCount");
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
		
	}



	/** 글 목록 조회
	 * @param pagination
	 * @param conn
	 * @return itemList
	 * @throws Exception
	 */
	public List<Item> itemList(Pagination pagination, Connection conn) throws Exception{

		List<Item> itemList = new ArrayList<Item>();
		
		try {
			
			String sql = prop.getProperty("itemList");
			
			int startRow = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int endRow = startRow + pagination.getLimit() - 1;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Item item = new Item();
				
				item.setItemNo(rs.getInt("ITEM_NO"));
				item.setItemName(rs.getString("ITEM_NM"));
				item.setItemPrice(rs.getString("ITEM_PRICE"));
				item.setMemberNo(rs.getInt("MEMBER_NO"));
				item.setAddress(rs.getString("ADDRESS"));
				item.setItemDate(rs.getTimestamp("ITEM_DATE"));
				item.setCategoryCode(rs.getInt("CATEGORY_CD"));
				item.setItemStatusCode(rs.getInt("ITEM_STATUS_CD"));
				
				itemList.add(item);
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return itemList;
	}



	/** 글 썸네일 이미지 조회
	 * @param itemNo
	 * @param conn
	 * @return imgList
	 * @throws Exception
	 */
	public List<ItemImg> imageList(int itemNo, Connection conn) throws Exception {

		List<ItemImg> imgList = new ArrayList<ItemImg>();
		
		try {
			
			String sql = prop.getProperty("imgList");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, itemNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ItemImg img = new ItemImg();
				
				img.setImgNo(rs.getInt("IMG_NO"));
				img.setImgPath(rs.getString("IMG_PATH"));
				img.setImgName(rs.getString("IMG_NM"));
				img.setImgOriginal(rs.getString("IMG_ORIGINAL"));
				img.setImgLevel(rs.getInt("IMG_LEVEL"));
				img.setItemNo(itemNo);
				
				imgList.add(img);
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return imgList;
	}



	/** 카테고리 글 수
	 * @param categoryTag
	 * @param conn
	 * @return listCount
	 * @throws Exception
	 */
	public int categoryGetListCount(int categoryTag, Connection conn) throws Exception {
		int listCount = 0;
		
		try {
			
			String sql = prop.getProperty("categoryListCount");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryTag);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}



	
	public List<Item> categoryItemList(Pagination pagination, int categoryTag, Connection conn) throws Exception{
		
		List<Item> itemList = new ArrayList<Item>();
		
		try {
			
			String sql = prop.getProperty("categoryItemList");
			
			int startRow = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int endRow = startRow + pagination.getLimit() - 1;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryTag);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Item item = new Item();
				
				item.setItemNo(rs.getInt("ITEM_NO"));
				item.setItemName(rs.getString("ITEM_NM"));
				item.setItemPrice(rs.getString("ITEM_PRICE"));
				item.setMemberNo(rs.getInt("MEMBER_NO"));
				item.setAddress(rs.getString("ADDRESS"));
				item.setItemDate(rs.getTimestamp("ITEM_DATE"));
				item.setCategoryCode(rs.getInt("CATEGORY_CD"));
				item.setItemStatusCode(rs.getInt("ITEM_STATUS_CD"));
				
				itemList.add(item);
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return itemList;
	}




	
	
}
