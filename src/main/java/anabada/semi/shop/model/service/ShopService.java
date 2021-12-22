package anabada.semi.shop.model.service;

import static anabada.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import anabada.semi.item.model.vo.Item;
import anabada.semi.shop.model.dao.ShopDAO;
import anabada.semi.shop.model.vo.PostScript;
import anabada.semi.shop.model.vo.Purchase;
import anabada.semi.shop.model.vo.Shop;
import anabada.semi.shop.model.vo.Wish;

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

	public List<Wish> selectWsih(int shopNo) throws Exception {
		Connection conn = getConnection();
		
		List<Wish> wList = dao.selectWsih(shopNo, conn);
		
		close(conn);
		
		return wList;
	}

	public int deleteWish(int itemNo, int shopNo) throws Exception {
		Connection conn = getConnection();
		
		int r = dao.deleteWish(itemNo, shopNo, conn);
		
		if(r > 0)	commit(conn);
		else		rollback(conn);
		
		close(conn);
		
		return r;
	}

	public List<Purchase> selectBuyItem(int shopNo) throws Exception {
		Connection conn = getConnection();
		
		List<Purchase> pList = dao.selectBuyItem(shopNo, conn);
		
		close(conn);
		
		return pList;
	}

	public List<Item> selectSellItem(int shopNo) throws Exception {
		Connection conn = getConnection();
		
		List<Item> sList = dao.selectSellItem(shopNo, conn);
		
		close(conn);
		
		return sList;
	}

	public int soldOutItem(int shopNo, int itemNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.soldOutItem(shopNo, itemNo, conn);
		
		if(result > 0)	commit(conn);
		else		rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int onSaleItem(int shopNo, int itemNo) throws Exception  {
		Connection conn = getConnection();
		
		int result = dao.onSaleItem(shopNo, itemNo, conn);
		
		if(result > 0)	commit(conn);
		else		rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
}
