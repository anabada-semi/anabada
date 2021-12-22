package anabada.semi.item.model.service;

import static anabada.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import anabada.semi.common.XSS;
import anabada.semi.item.model.dao.ItemSelectDAO;
import anabada.semi.item.model.vo.Item;
import anabada.semi.item.model.vo.ItemImg;
import anabada.semi.item.model.vo.Reply;
import anabada.semi.shop.model.vo.PostScript;
import anabada.semi.shop.model.vo.Shop;

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
		
		List<ItemImg> img = dao.selectItemImg(itemNo, conn);
		
		close(conn);
		
		return item;
	}
	
	/** 상품 이미지 조회
	 * @param itemNo 
	 * @return item
	 * @throws Exception
	 */
	public List<ItemImg> selectItemImg(int itemNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<ItemImg> ItmeImg = dao.selectItemImg(itemNo, conn);
		
		close(conn);
		
		return ItmeImg;
	}


	/** 댓글 조회
	 * @param itemNo
	 * @return replyList
	 * @throws Exception
	 */
	public List<Reply> selectReplyList(int itemNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Reply> replyList = dao.selectReplyList(itemNo, conn);
		
		close(conn);
		
		return replyList;
	}
	
	/** 댓글 역순 조회
	 * @param itemNo
	 * @return replyList
	 * @throws Exception
	 */
	public List<Reply> selectReplyListReverse(int itemNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Reply> replyList = dao.selectReplyListReverse(itemNo, conn);
		
		close(conn);
		
		return replyList;
	}


	/** 댓글 삽입
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Reply reply) throws Exception{
		
		Connection conn = getConnection();
		
		reply.setReplyContent(XSS.replaceParameter(reply.getReplyContent()));
		
		reply.setReplyContent( reply.getReplyContent().replaceAll("(\r\n|\r|\n|\n\r)", "<br>") );
		
		int result = dao.insertReply(reply, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 댓글 수정
	 * @param replyNo
	 * @param replyContent
	 * @return result
	 * @throws Exception
	 */
	public int updateReply(int replyNo, String replyContent) throws Exception{
		
		Connection conn = getConnection();
		
		replyContent = XSS.replaceParameter(replyContent);
		
		replyContent = replyContent.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		
		int result = dao.updateReply(replyNo, replyContent, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 댓글 삭제
	 * @param replyNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteReply(int replyNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.deleteReply(replyNo, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 대댓글 삽입
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int insertReplyAnswer(Reply reply) throws Exception{

		Connection conn = getConnection();
		
		reply.setReplyContent(XSS.replaceParameter(reply.getReplyContent()));
		
		reply.setReplyContent( reply.getReplyContent().replaceAll("(\r\n|\r|\n|\n\r)", "<br>") );
		
		int result = dao.insertReplyAnswer(reply, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 상점 조회
	 * @param itemNo
	 * @return shop
	 * @throws Exception
	 */
	public Shop selectShop(int itemNo) throws Exception{

		Connection conn = getConnection();
		
		Shop shop = dao.selectShop(itemNo, conn);
		
		close(conn);
		
		return shop;
	}


	/** 상점 후기 조회
	 * @param memberNo
	 * @return postScriptList
	 * @throws Exception
	 */
	public List<PostScript> selectPostScript(int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<PostScript> postScriptList = dao.selectPostScript(memberNo, conn);
		
		close(conn);
		
		return postScriptList;
	}


	/** 찜 하기
	 * @param itemNo
	 * @param memberNo
	 * @return result(1: 삽입됨, -1: 있음, -2: 삭제됨)
	 * @throws Exception
	 */
	public int wishSelect(int itemNo, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		int result = 0;
		
		// select (0: 없음 , 1:있음, 2: 삭제됨)
		int select = dao.wishSelect(itemNo, memberNo, conn);
		
		if(select == 0) {
			// 삽입함 (0: 삽입 실패, 1: 삽입 성공)
			result = dao.wishInsert(itemNo, memberNo, conn);
			
		} else if(select == 2){	// 찜 내역에 있었지만 삭제된 경우
			result = -2;
			
		} else if(select == 1){	// 이미 찜한 경우
			result = -1;
		}
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 찜 추가(update)
	 * @param itemNo
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int wishUpdate(int itemNo, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.wishUpdate(itemNo, memberNo, 1, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 찜 목록 삭제
	 * @param itemNo
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int wishDelete(int itemNo, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.wishUpdate(itemNo, memberNo, 2, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 찜 개수 조회
	 * @param itemNo
	 * @return count
	 * @throws Exception
	 */
	public int wishCount(int itemNo) throws Exception{
		
		Connection conn = getConnection();
		
		int count = dao.wishCount(itemNo, conn);
		
		close(conn);
		
		return count;
	}


	/** 조회수 증가
	 * @param itemNo
	 * @return
	 * @throws Exception
	 */
	public int updateView(int itemNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.wishUpdate(itemNo, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 조회수 조회
	 * @param itemNo
	 * @return view
	 * @throws Exception
	 */
	public int selectView(int itemNo) throws Exception{
		Connection conn = getConnection();
		
		int view = dao.selectView(itemNo, conn);
		
		close(conn);
		
		return view;
	}
	
}
