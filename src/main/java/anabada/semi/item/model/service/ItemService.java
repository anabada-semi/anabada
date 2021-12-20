package anabada.semi.item.model.service;

import static anabada.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import anabada.semi.common.XSS;
import anabada.semi.item.model.dao.ItemDAO;
import anabada.semi.item.model.vo.Category;
import anabada.semi.item.model.vo.Item;
import anabada.semi.item.model.vo.ItemImg;

public class ItemService {
	
	private ItemDAO dao = new ItemDAO();

	
	/** 카테고리 조회
	 * @return category
	 * @throws Exception
	 */
	public List<Category> selectCategory() throws Exception {
		Connection conn = getConnection();
		
		List<Category> category = dao.selectCategory(conn);
		
		close(conn);
		
		return category;
	}


	/** 아이템 입력 + 아이템 이미지 입력 
	 * @param item
	 * @param imgList
	 * @return result
	 * @throws Exception
	 */
	public int insertItem(Item item, List<ItemImg> imgList) throws Exception {
		Connection conn = getConnection();
		
		int itemNo = dao.nextItemNo(conn);
		item.setItemNo(itemNo);
		
		item.setItemName(XSS.replaceParameter( item.getItemName() ) );
		item.setItemInfo(XSS.replaceParameter( item.getItemInfo() ) );
		
		String content = item.getItemInfo().replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		item.setItemInfo(content);
		
		int result = dao.insertItem(item, conn);
		
		if(result > 0) {
			
			for(ItemImg img : imgList) {
				img.setItemNo(itemNo);
				
				result = dao.insertItemImg(img, conn);
				
				if(result == 0) {
					rollback(conn);
					break;
				}
			}
			
			if(result > 0) {
				commit(conn);
				result = itemNo;
			}
			else 		   rollback(conn);
		}else { 
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	

}
