package anabada.semi.item.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import anabada.semi.item.model.service.ItemSelectService;
import anabada.semi.item.model.vo.Reply;

@WebServlet("/reply/*")
public class ReplyController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getMethod();
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring( (contextPath + "/reply/").length() );
		
		ItemSelectService service = new ItemSelectService();
		
		try {
			
			// 댓글 조회
			if(command.equals("select")) {
				
				int itemNo = Integer.parseInt(req.getParameter("itemNo"));
				
				List<Reply> rList = service.selectReplyList(itemNo);
				
				System.out.println("뭔데? "+ rList);
				
				new Gson().toJson(rList, resp.getWriter());	// 연결된 스트림을 이용하여 ajax로 값 전달
				
			}
			
			// 댓글 삽입
			else if(command.equals("insert")) {
				
				Reply reply = new Reply();

				int memberNo = Integer.parseInt(req.getParameter("memberNo"));
				int itemNo = Integer.parseInt(req.getParameter("itemNo"));
				String replyContent = req.getParameter("replyContent");
				
				if(req.getParameter("secret").equals("true")) {
					reply.setReplySecret(1);	// 비밀O
				} else {
					reply.setReplySecret(2);	// 비밀X
				}
				
				System.out.println("secret:"+reply.getReplySecret());
				
				reply.setMemberNo(memberNo);
				reply.setItemNo(itemNo);
				reply.setReplyContent(replyContent);
				
				int result = service.insertReply(reply);
				
//				System.out.println("result: " + result);
				
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
			
			
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
