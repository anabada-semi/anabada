package anabada.semi.item.model.service;

import static anabada.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import anabada.semi.item.model.dao.ItemSelectDAO;
import anabada.semi.item.model.vo.Item;

public class ItemSelectService {

	private ItemSelectDAO dao = new ItemSelectDAO();

	
	/** 카테고리 조회
	 * @return categoryList
	 * @throws Exception
	 */
	public List<Item> selectCategory() throws Exception{
		
		Connection conn = getConnection();
		
		List<Item> categoryList = dao.selectCategory(conn);
		
		close(conn);
		
		return categoryList;
	}


	/** 상품 조회
	 * @param itemNo 
	 * @return item
	 * @throws Exception
	 */
	public Item selectItem(int itemNo) throws Exception{
		
		Connection conn = getConnection();
		
		Item item = dao.selectItem(itemNo, conn);
		
		close(conn);
		
		return item;
	}
	
}
