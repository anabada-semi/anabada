package anabada.semi.reply.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import anabada.semi.item.model.service.ItemSelectService;
import anabada.semi.item.model.vo.Reply;
import anabada.semi.member.model.vo.Member;
import anabada.semi.notice.model.service.NoticeService;
import anabada.semi.notice.model.vo.Notice;

@WebServlet("/reply/*")
public class ReplyController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getMethod();
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring( (contextPath + "/reply/").length() );
		
		ItemSelectService service = new ItemSelectService();
		
		HttpSession session = req.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		try {
			
			// 댓글 조회
			if(command.equals("select")) {
				
				int itemNo = Integer.parseInt(req.getParameter("itemNo"));
				
				List<Reply> rList = service.selectReplyList(itemNo);
				
				new Gson().toJson(rList, resp.getWriter());	// 연결된 스트림을 이용하여 ajax로 값 전달
				
			}
			
			// 댓글 삽입
			else if(command.equals("insert")) {
				
				Reply reply = new Reply();

				int memberNo = Integer.parseInt(req.getParameter("memberNo"));
				int itemNo = Integer.parseInt(req.getParameter("itemNo"));
				String replyContent = req.getParameter("replyContent");
				int itemMemberNo = Integer.parseInt(req.getParameter("itemMemberNo"));
				
				if(req.getParameter("secret").equals("true")) {
					reply.setReplySecret(1);	// 비밀O
				} else {
					reply.setReplySecret(2);	// 비밀X
				}
				
				reply.setMemberNo(memberNo);
				reply.setItemNo(itemNo);
				reply.setReplyContent(replyContent);
				
				int result = service.insertReply(reply);
				
				Notice notice = new Notice();
				
				notice.setNoticeContent(1);
				notice.setItemNo(itemNo);
				notice.setShopNo(itemMemberNo);	//판매자
				notice.setMemberNo(memberNo);
				notice.setReplyMemberNo(0);
				notice.setPostSCriptNo(0);	// 후기를 달았으면 후기 번호
				
				// 댓글이 db에 삽입되었을때 && 댓글 단 사람(로그인 한 사람) != 판매자
				if(result > 0 && memberNo != itemMemberNo) {
					new NoticeService().insertNotice(notice);
				}
				
				resp.getWriter().print(result);
			}
			
			// 댓글 수정
			else if(command.equals("update")) {
				
				int replyNo = Integer.parseInt(req.getParameter("replyNo"));
				String replyContent = req.getParameter("replyContent");
				
				resp.getWriter().print(service.updateReply(replyNo, replyContent));
			}
			
			// 댓글 삭제
			else if(command.equals("delete")) {
				
				int replyNo = Integer.parseInt(req.getParameter("replyNo"));

				resp.getWriter().print(service.deleteReply(replyNo));
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
