package anabada.semi.shop.model.service;

import static anabada.semi.common.JDBCTemplate.*;

import java.sql.Connection;

import anabada.semi.shop.model.dao.ShopDAO;

public class ShopService {
	private ShopDAO dao = new ShopDAO();

	public int updateShopName(String inputName, int memberNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updateShopName(inputName, memberNo, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int updateShopContent(String inputContent, int memberNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updateShopContent(inputContent, memberNo, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}
}
