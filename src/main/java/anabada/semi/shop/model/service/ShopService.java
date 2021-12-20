package anabada.semi.shop.model.service;

import static anabada.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import anabada.semi.item.model.vo.Item;
import anabada.semi.shop.model.dao.ShopDAO;
import anabada.semi.shop.model.vo.Shop;

public class ShopService {
	private ShopDAO dao = new ShopDAO();

	public int updateShopName(String inputName, int memberNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updateShopName(inputName, memberNo, conn);
		
		if(result > 0)	{
			commit(conn);
			new Shop().setShopName(inputName);
		}
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int updateShopContent(String inputContent, int memberNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updateShopContent(inputContent, memberNo, conn);
		
		if(result > 0) {
			commit(conn);
			new Shop().setShopIntroduce(inputContent);
		}
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public List<Item> selectItem(int memberNo) throws Exception {
		Connection conn = getConnection();
		
		List<Item> itemList = dao.selectItem(memberNo, conn);
		
		close(conn);
		
		return itemList;
	}
}
