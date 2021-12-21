package anabada.semi.shop.model.service;

import static anabada.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import anabada.semi.item.model.vo.Item;
import anabada.semi.shop.model.dao.ShopDAO;
import anabada.semi.shop.model.vo.PostScript;
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

	public List<Item> selectItem(int shopNo) throws Exception {
		Connection conn = getConnection();
		
		List<Item> itemList = dao.selectItem(shopNo, conn);
		
		close(conn);
		
		return itemList;
	}

	public List<PostScript> selectPostList(int shopNo, int memberNo) throws Exception {
		Connection conn = getConnection();
		
		List<PostScript> pList = dao.selectPostList(shopNo, memberNo, conn);
		
		close(conn);
		
		return pList;
	}

	public int insertPostScript(int shopNo, int memberNo, String postScript) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.insertPostScript(shopNo, memberNo, postScript, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int updatePostScript(int postNo, String postScript) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updatePostScript(postNo, postScript, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int deletePostScript(int postNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.deletePostScript(postNo, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
}
