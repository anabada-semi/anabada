package anabada.semi.notice.model.service;

import static anabada.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import anabada.semi.item.model.vo.Reply;
import anabada.semi.notice.model.dao.NoticeDAO;
import anabada.semi.notice.model.vo.Notice;

public class NoticeService {
	
	private NoticeDAO dao = new NoticeDAO();

	
	
	/** 알림조회
	 * @param loginMemberNo
	 * @return noticeList
	 * @throws Exception
	 */
	public List<Notice> selectNotice(int loginMemberNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Notice> noticeList = dao.selectNotice(loginMemberNo, conn);
		
		close(conn);
		
		return noticeList;
	}
	
	/** 알림조회2
	 * @param loginMemberNo
	 * @return noticeList
	 * @throws Exception
	 */
	public List<Notice> selectNotice2(int loginMemberNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Notice> noticeList = dao.selectNotice2(loginMemberNo, conn);
		
		close(conn);
		
		return noticeList;
	}

	/** 알림 테이블에 삽입
	 * @param notice
	 * @return result
	 * @throws Exception
	 */
	public int insertNotice(Notice notice) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.insertNotice(notice, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		close(conn);
		
		return result;
	}

	
	/** 후기 번호 조회
	 * @param shopNo
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int selectPostScriptNo(int shopNo, int memberNo) throws Exception{

		Connection conn = getConnection();
		
		int result = dao.selectPostScriptNo(shopNo, memberNo, conn);
		
		close(conn);
		
		return result;
	}

	/** 알림 삭제(후기)
	 * @param postNo
	 * @return result 
	 * @throws Exception
	 */
	public int deleteNotice(int postNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.deleteNotice(postNo, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 읽음 업데이트
	 * @param noticeNo
	 * @return result
	 * @throws Exception
	 */
	public int updateNotice(int noticeNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.updateNotice(noticeNo, conn);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}
	

	/** 봄 업데이트
	 * @param noticeList
	 * @return result
	 * @throws Exception
	 */

	public int updateView(List<Notice> noticeList) throws Exception{
		
		int result = 0;
		
		Connection conn = getConnection();
		
		for(Notice notice : noticeList) {
			
			result = dao.updateView(notice, conn);
			if(result == 0) rollback(conn);
		}
		
		if(result > 0)	commit(conn);
		
		close(conn);
		
		return result;
	}


	
	
	
	
}
