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

public class ItemSelectDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ItemSelectDAO() {
		String filePath = ItemSelectDAO.class.getResource("/anabada/semi/sql/detailSelectItem-query.xml").getPath();

		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public List<Item> selectCategory(Connection conn) throws Exception{
		
		List<Item> categoryList = new ArrayList<Item>();
		
		try {
			String sql = prop.getProperty("selectCategory");
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Item category = new Item();
				
				category.setCategoryCode(rs.getInt("CATEGORY_CD"));
				category.setCategoryName(rs.getString("CATEGORY_NM"));
				
				categoryList.add(category);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return categoryList;
	}



	/** 상품 조회
	 * @param itemNo
	 * @param conn
	 * @return item
	 * @throws Exception
	 */
	public Item selectItem(int itemNo, Connection conn) throws Exception{

		Item item = null;
		
		try {
			
			String sql = prop.getProperty("selectItem");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, itemNo);
			pstmt.setInt(2, itemNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				item = new Item();
				
				item.setItemNo(rs.getInt("ITEM_NO"));
				item.setItemName(rs.getString("ITEM_NM"));
				item.setItemInfo(rs.getString("ITEM_INFO"));
				item.setItemDate(rs.getString("ITEM_DATE"));
				item.setCategoryCode(rs.getInt("CATEGORY_CD"));
				item.setItemStatusCode(rs.getInt("ITEM_STATUS_CD"));
				item.setMemberNo(rs.getInt("MEMBER_NO"));
				item.setReadCount(rs.getInt("READ_COUNT"));
				item.setWish(rs.getInt("WISH"));

				item.setItemPrice(rs.getString("ITEM_PRICE"));
			}
			
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return item;
	}
}
