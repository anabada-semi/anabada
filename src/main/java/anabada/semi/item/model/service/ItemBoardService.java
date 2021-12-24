package anabada.semi.item.model.service;

import static anabada.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import anabada.semi.item.model.dao.ItemBoardDAO;
import anabada.semi.item.model.vo.Item;
import anabada.semi.item.model.vo.ItemImg;
import anabada.semi.item.model.vo.Pagination;

public class ItemBoardService {

	private ItemBoardDAO dao = new ItemBoardDAO();
	
	/** 전체 글 수
	 * @param cp
	 * @return listCount
	 * @throws Exception
	 */
	public Pagination getPagination(int cp) throws Exception{
		
		Connection conn = getConnection();
		
		int listCount = dao.getListCount(conn);
		
		close(conn);
		
		return new Pagination (listCount, cp);
	}

	
	/** 글 목록 조회
	 * @param pagination
	 * @return itemList
	 * @throws Exception
	 */
	public List<Item> itemList(Pagination pagination) throws Exception {
		
		Connection conn = getConnection();
		
		List<Item> itemList = dao.itemList(pagination, conn);
		
		// 글 썸네일 조회
		for(Item temp : itemList) {
			List<ItemImg> imgList = dao.imageList(temp.getItemNo(), conn);
			
			temp.setImgList(imgList);
		}
		
		close(conn);
		
		return itemList;
	}


	
	/** 카테고리 별 글 수
	 * @param cp
	 * @param categoryTag
	 * @return listCount
	 * @throws Exception
	 */
	public Pagination getCategoryPagination(int cp, int categoryTag) throws Exception{
		Connection conn = getConnection();
		
		int listCount = dao.categoryGetListCount(categoryTag, conn);
		
		close(conn);
		
		return new Pagination (listCount, cp);
	}


	
	/** 카테고리별 글 목록 조회
	 * @param pagination
	 * @param categoryTag 
	 * @return itemList
	 * @throws Exception
	 */
	public List<Item> categoryItemList(Pagination pagination, int categoryTag) throws Exception {
		
		Connection conn = getConnection();
		
		List<Item> itemList = dao.categoryItemList(pagination, categoryTag, conn);
		
		// 글 썸네일 조회
		for(Item temp : itemList) {
			List<ItemImg> imgList = dao.imageList(temp.getItemNo(), conn);
			
			temp.setImgList(imgList);
		}
		
		close(conn);
		
		return itemList;
	}


	/** 찜 개수 조회
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int wishCount(int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.wishCount(memberNo, conn);
		
		close(conn);
		
		return result;
	}


	
	/** 검색된 글 수
	 * @param cp
	 * @param searchInput
	 * @return listCount
	 * @throws Exception
	 */
	public Pagination getSearchPagination(int cp, String searchInput) throws Exception {
		Connection conn = getConnection();
		
		searchInput = searchInput + "%";
		String searchInput2 = "%" + searchInput + "%";
		
		int listCount = dao.getSearchPagination(searchInput, searchInput2, conn);
		
		close(conn);
		
		return new Pagination (listCount, cp);
	}


	/** 검색된 글 목록 조회
	 * @param pagination
	 * @param searchInput
	 * @return itemList
	 * @throws Exception
	 */
	public List<Item> searchItemList(Pagination pagination, String searchInput) throws Exception{
		
		Connection conn = getConnection();
		
		searchInput = searchInput + "%";
		String searchInput2 = "%" + searchInput + "%";
		
		List<Item> itemList = dao.searchItemList(pagination, searchInput, searchInput2, conn);
		
		// 글 썸네일 조회
		for(Item temp : itemList) {
			List<ItemImg> imgList = dao.imageList(temp.getItemNo(), conn);
			
			temp.setImgList(imgList);
		}
		
		close(conn);
		
		return itemList;
	}
	
	
	

}
