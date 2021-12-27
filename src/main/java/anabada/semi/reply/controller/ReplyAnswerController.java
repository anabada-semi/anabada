package anabada.semi.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anabada.semi.item.model.service.ItemSelectService;
import anabada.semi.item.model.vo.Reply;
import anabada.semi.notice.model.service.NoticeService;
import anabada.semi.notice.model.vo.Notice;

@WebServlet("/answer/*")
public class ReplyAnswerController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String method = req.getMethod();
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring( (contextPath + "/answer/").length() );
		
		ItemSelectService service = new ItemSelectService();
		
		try {
		
			// 대댓글 삽입
			if(command.equals("insert")) {
				
				Reply reply = new Reply();

				int memberNo = Integer.parseInt(req.getParameter("memberNo"));
				int itemNo = Integer.parseInt(req.getParameter("itemNo"));
				int replyNo = Integer.parseInt(req.getParameter("replyNo"));
				int itemMemberNo = Integer.parseInt(req.getParameter("itemMemberNo"));
				int replyAnswerNo = Integer.parseInt(req.getParameter("replyAnswerNo"));
				
				String replyContent = req.getParameter("replyContent");
				
				reply.setMemberNo(memberNo);
				reply.setItemNo(itemNo);
				reply.setReplyNo(replyNo);
				reply.setReplyContent(replyContent);

				int result = service.insertReplyAnswer(reply);
				
				if(result > 0) {
					Notice notice = new Notice();
					notice.setNoticeContent(2);
					notice.setItemNo(itemNo);
					notice.setShopNo(itemMemberNo);	// 판매자
					notice.setMemberNo(memberNo);	// 대댓글 작성자 == 로그인 한 사람
					notice.setReplyMemberNo(replyAnswerNo);	// 대댓글 단 사람 번호
					notice.setPostSCriptNo(0);	// 후기를 달았으면 후기 번호
					
					new NoticeService().insertNotice(notice);
				}
				resp.getWriter().print(result);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
