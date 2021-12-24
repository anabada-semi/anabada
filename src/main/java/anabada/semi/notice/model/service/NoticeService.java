package anabada.semi.notice.model.service;

import static anabada.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import anabada.semi.item.model.vo.Reply;
import anabada.semi.notice.model.dao.NoticeDAO;
import anabada.semi.notice.model.vo.Notice;

public class NoticeService {
	
	private NoticeDAO dao = new NoticeDAO();

	public List<Notice> selectNotice(int loginMemberNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Notice> noticeList = dao.selectNotice(loginMemberNo, conn);
		
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
	
	
	
	
}
