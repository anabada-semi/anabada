package anabada.semi.item.model.service;

import static anabada.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import anabada.semi.common.XSS;
import anabada.semi.item.model.dao.ItemSelectDAO;
import anabada.semi.item.model.vo.Item;
import anabada.semi.item.model.vo.ItemImg;
import anabada.semi.item.model.vo.Reply;

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
	
}
