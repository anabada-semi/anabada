package anabada.semi.item.model.dao;

import static anabada.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import anabada.semi.item.model.vo.Item;
import anabada.semi.item.model.vo.ItemImg;
import anabada.semi.item.model.vo.Reply;
import anabada.semi.shop.model.vo.PostScript;
import anabada.semi.shop.model.vo.Shop;

public class ItemSelectDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ItemSelectDAO() {
		String filePath = ItemSelectDAO.class.getResource("/anabada/semi/sql/detailSelectItem-query.xml").getPath();

		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	/** 카테고리 조회
	 * @param conn
	 * @return categoryList
	 * @throws Exception
	 */
	public List<Item> selectCategory(Connection conn) throws Exception{
		
		List<Item> categoryList = new ArrayList<Item>();
		
		try {
			String sql = prop.getProperty("selectCategory");
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Item category = new Item();
				
				category.setCategoryCode(rs.getInt("CATEGORY_CD"));
				category.setCategoryName(rs.getString("CATEGORY_NM"));
				
				categoryList.add(category);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return categoryList;
	}


	/** 상품 조회
	 * @param itemNo
	 * @param conn
	 * @return item
	 * @throws Exception
	 */
	public Item selectItem(int itemNo, Connection conn) throws Exception{

		Item item = null;
		
		try {
			String sql = prop.getProperty("selectItem");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, itemNo);
			pstmt.setInt(2, itemNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				item = new Item();
				
				item.setItemNo(rs.getInt("ITEM_NO"));
				item.setItemName(rs.getString("ITEM_NM"));
				item.setItemInfo(rs.getString("ITEM_INFO"));
				item.setItemDate(rs.getTimestamp("ITEM_DATE"));
				item.setCategoryCode(rs.getInt("CATEGORY_CD"));
				item.setItemStatusCode(rs.getInt("ITEM_STATUS_CD"));
				item.setMemberNo(rs.getInt("MEMBER_NO"));
				item.setReadCount(rs.getInt("READ_COUNT"));
				item.setCategoryName(rs.getString("CATEGORY_NM"));
				item.setWish(rs.getInt("WISH"));
				
				item.setItemPrice(rs.getString("ITEM_PRICE"));
			}
			
		} finally {
			close(rs); 
			close(pstmt);
		}
		return item;
	}

	public List<ItemImg> selectItemImg(int itemNo, Connection conn)  throws Exception{

		List<ItemImg> itemImg = new ArrayList<ItemImg>();
		
		try {
			String sql = prop.getProperty("selectItemImg");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, itemNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ItemImg img = new ItemImg();
				
				img.setImgName(rs.getString("IMG_NM"));
				img.setImgPath(rs.getString("IMG_PATH"));
				img.setImgLevel(rs.getInt("IMG_LEVEL"));
				
				itemImg.add(img);
			}
			
		} finally {
			close(rs); 
			close(pstmt);
		}
		return itemImg;
	}

	/** 댓글 조회
	 * @param itemNo
	 * @param conn
	 * @return replyList
	 * @throws Exception
	 */
	public List<Reply> selectReplyList(int itemNo, Connection conn) throws Exception{
		
		List<Reply> replyList = new ArrayList<Reply>();
		try {
			String sql = prop.getProperty("selectReplyList");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, itemNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Reply reply = new Reply();
				
				reply.setReplyNo(rs.getInt("REPLY_NO"));
				reply.setReplyContent(rs.getString("REPLY_CONTENT"));
				reply.setReplyDate(rs.getTimestamp("REPLY_DT"));
				reply.setReplySecret(rs.getInt("REPLY_SECRET"));
				reply.setMemberNo(rs.getInt("MEMBER_NO"));
				reply.setReplyStatusCode(rs.getInt("REPLY_STATUS_CD"));
				reply.setMemberName(rs.getString("MEMBER_NM"));
				reply.setReplyNestedCode(rs.getInt("REPLY_NESTED_CD"));
				reply.setReplyNestedNo(rs.getInt("REPLY_NESTED_NO"));
				
				replyList.add(reply);
			}
			
		} finally {
			close(rs); 
			close(pstmt);
		}
		return replyList;
	}
	
	/** 댓글 역순 조회
	 * @param itemNo
	 * @param conn
	 * @return replyList
	 * @throws Exception
	 */
	public List<Reply> selectReplyListReverse(int itemNo, Connection conn) throws Exception{
		
		List<Reply> replyList = new ArrayList<Reply>();
		try {
			String sql = prop.getProperty("selectReplyListReverse");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, itemNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Reply reply = new Reply();
				
				reply.setReplyNo(rs.getInt("REPLY_NO"));
				reply.setReplyContent(rs.getString("REPLY_CONTENT"));
				reply.setReplyDate(rs.getTimestamp("REPLY_DT"));
				reply.setReplySecret(rs.getInt("REPLY_SECRET"));
				reply.setMemberNo(rs.getInt("MEMBER_NO"));
				reply.setReplyStatusCode(rs.getInt("REPLY_STATUS_CD"));
				reply.setMemberName(rs.getString("MEMBER_NM"));
				reply.setReplyNestedCode(rs.getInt("REPLY_NESTED_CD"));
				reply.setReplyNestedNo(rs.getInt("REPLY_NESTED_NO"));
				
				replyList.add(reply);
			}
			
		} finally {
			close(rs); 
			close(pstmt);
		}
		return replyList;
	}

	/** 댓글 삽입
	 * @param reply
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Reply reply, Connection conn) throws Exception{
		
		int result = 0;
		try {
			String sql = prop.getProperty("insertReply");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getReplySecret());
			pstmt.setInt(3, reply.getMemberNo());
			pstmt.setInt(4, reply.getItemNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 댓글 수정
	 * @param replyNo
	 * @param replyContent
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int updateReply(int replyNo, String replyContent, Connection conn) throws Exception{

		int result = 0;
		try {
			String sql = prop.getProperty("updateReply");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyContent);
			pstmt.setInt(2, replyNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 댓글 삭제
	 * @param replyNo
	 * @param conn
	 * @return 
	 * @throws Exception
	 */
	public int deleteReply(int replyNo, Connection conn) throws Exception{
		
		int result = 0;
		try {
			String sql = prop.getProperty("deleteReply");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 대댓글 삽입
	 * @param reply
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int insertReplyAnswer(Reply reply, Connection conn)  throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("insertReplyAnswer");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getMemberNo());
			pstmt.setInt(3, reply.getItemNo());
			pstmt.setInt(4, reply.getReplyNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}



	/** 상점 조회
	 * @param itemNo
	 * @param conn
	 * @return shop (조회X : null)
	 * @throws Exception
	 */
	public Shop selectShop(int itemNo, Connection conn) throws Exception{

		Shop shop = new Shop();
		
		try {
			String sql = prop.getProperty("selectShop");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, itemNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				shop.setMemberNo(rs.getInt("MEMBER_NO"));
				shop.setShopIntroduce(rs.getString("SHOP_INTRODUCE"));
				shop.setShopName(rs.getString("SHOP_NM"));
			}
			
		} finally {
			close(rs); 
			close(pstmt);
		}
		return shop;
	}



	/**
	 * @param memberNo
	 * @param conn
	 * @return postScriptList
	 * @throws Exception
	 */
	public List<PostScript> selectPostScript(int memberNo, Connection conn) throws Exception{
		
		List<PostScript> postScriptList = new ArrayList<PostScript>();
		
		try {
			String sql = prop.getProperty("selectPostScript");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostScript postScript = new PostScript();
				
				postScript.setPostScriptNo(rs.getInt("POSTSCRIPT_NO"));
				postScript.setPostScriptCheck(rs.getString("POSTSCRIPT_CHECK"));
				postScript.setShopNo(rs.getInt("SHOP_NO"));
				postScript.setMemberNo(rs.getInt("MEMBER_NO"));
				postScript.setMemberName(rs.getString("MEMBER_NM"));
				
				postScriptList.add(postScript);
			}
			
		} finally {
			close(rs); 
			close(pstmt);
		}
		return postScriptList;
	}


	/** 찜목록 조회
	 * @param itemNo
	 * @param memberNo
	 * @param conn
	 * @return result (0: 없음 , 1:있음, 2: 삭제됨)
	 * @throws Exception
	 */
	public int wishSelect(int itemNo, int memberNo, Connection conn) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("wishSelect");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, itemNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}



	/** 찜 목록 삽입(insert)
	 * @param itemNo
	 * @param memberNo
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int wishInsert(int itemNo, int memberNo, Connection conn) throws Exception{
		
		int result = 0;
		try {
			String sql = prop.getProperty("wishInsert");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, itemNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	/** 찜 목록 삽입(update)
	 * @param itemNo
	 * @param memberNo
	 * @param i 
	 * @param conn 
	 * @return result
	 * @throws Exception
	 */
	public int wishUpdate(int itemNo, int memberNo, int i, Connection conn) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("wishUpdate");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, i);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, itemNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}



	/** 찜 개수 조회
	 * @param itemNo
	 * @param conn
	 * @return count
	 * @throws Exception
	 */
	public int wishCount(int itemNo, Connection conn) throws Exception{
		
		int count = 0;
		
		try {
			String sql = prop.getProperty("wishCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, itemNo);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return count;
	}

	/** 조회수 증가
	 * @param itemNo
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int wishUpdate(int itemNo, Connection conn) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("updateView");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, itemNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}



	/** 조회수 조회
	 * @param itemNo
	 * @param conn
	 * @return view
	 * @throws Exception
	 */
	public int selectView(int itemNo, Connection conn) throws Exception{
		int view = 0;
		try {
			String sql = prop.getProperty("selectView");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, itemNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				view = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return view;
	}




}
