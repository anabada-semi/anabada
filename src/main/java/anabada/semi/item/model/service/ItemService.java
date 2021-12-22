package anabada.semi.item.model.service;

import static anabada.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import anabada.semi.common.XSS;
import anabada.semi.item.model.dao.ItemDAO;
import anabada.semi.item.model.dao.ItemSelectDAO;
import anabada.semi.item.model.vo.Category;
import anabada.semi.item.model.vo.Item;
import anabada.semi.item.model.vo.ItemImg;

public class ItemService {
	
	private ItemDAO dao = new ItemDAO();
	private ItemSelectDAO selDao = new ItemSelectDAO();

	
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

	

	/** 수정화면 전환
	 * @param itemNo
	 * @return item
	 * @throws Exception
	 */
	public Item updateView(int itemNo)throws Exception {

		Connection conn = getConnection();
		
		Item item = selDao.selectItem(itemNo, conn);
		
		List<ItemImg> imgList = selDao.selectItemImg(itemNo, conn);
		
		item.setImgList(imgList);
		
		item.setItemInfo(item.getItemInfo().replaceAll("<br>", "\r\n") );
		
		close(conn);
		
		return item;
	}


	/** 게시글 수정
	 * @param item
	 * @param imgList
	 * @return result
	 * @throws Exception
	 */
	public int updateItem(Item item, List<ItemImg> imgList) throws Exception{
		
		Connection conn = getConnection();
		
		item.setItemName(XSS.replaceParameter( item.getItemName() ) );
		item.setItemInfo(XSS.replaceParameter( item.getItemInfo() ) );
		
		String content = item.getItemInfo().replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		item.setItemInfo(content);
		
		int result = dao.updateItem(item, conn);
		
		if(result > 0) {
			
			for(ItemImg img : imgList) {
				
				result = dao.updateItemImg(img, conn);
				
				if(result == 0) {
					result = dao.insertItemImg(img, conn);
				}
			}
			
			if(result > 0) commit(conn);
			else 		  rollback(conn);
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	

}
