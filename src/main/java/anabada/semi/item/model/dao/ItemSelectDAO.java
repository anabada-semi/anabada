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
}
