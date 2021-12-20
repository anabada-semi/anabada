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

import anabada.semi.item.model.vo.Category;
import anabada.semi.item.model.vo.Item;
import anabada.semi.item.model.vo.ItemImg;

public class ItemDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public ItemDAO() {
		String filePath = ItemDAO.class.getResource("/anabada/semi/sql/item-query.xml").getPath();

		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 카테고리 조회
	 * @param conn 
	 * @return category
	 * @throws Exception
	 */
	public List<Category> selectCategory(Connection conn) throws Exception {
		
		List<Category> category = new ArrayList<Category>();
		
		try {
			String sql = prop.getProperty("selectCategory");
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Category c = new Category();
				c.setCategoryCode(rs.getInt(1));
				c.setCategoryName(rs.getString(2));
				
				category.add(c);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return category;
	}

	/** 다음 아이템 번호 조회
	 * @param conn
	 * @return itemNo
	 * @throws Exception
	 */
	public int nextItemNo(Connection conn) throws Exception {
		
		int itemNo = 0;
		
		try {
			String sql = prop.getProperty("nextItemNo");
			
			pstmt = conn.prepareStatement(sql);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				itemNo = rs.getInt(1);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return itemNo;
	}

	
	/** 아이템 입력
	 * @param item
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int insertItem(Item item, Connection conn) throws Exception {

		int result = 0;
		
		try {
			String sql = prop.getProperty("insertItem");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, item.getItemNo());
			pstmt.setString(2, item.getItemName());
			pstmt.setString(3, item.getItemPrice());
			pstmt.setString(4, item.getItemInfo());
			pstmt.setInt(5, item.getCategoryCode());
			pstmt.setInt(6, item.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 아이템 이미지 삽입
	 * @param img
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int insertItemImg(ItemImg img, Connection conn) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertItemImg");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, img.getImgPath());
			pstmt.setString(2, img.getImgName());
			pstmt.setString(3, img.getImgOriginal());
			pstmt.setInt(4, img.getImgLevel());
			pstmt.setInt(5, img.getItemNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	
}
