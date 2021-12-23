package anabada.semi.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anabada.semi.item.model.service.ItemSelectService;
import anabada.semi.item.model.vo.Reply;

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
				
				String replyContent = req.getParameter("replyContent");
				
				reply.setMemberNo(memberNo);
				reply.setItemNo(itemNo);
				reply.setReplyNo(replyNo);
				reply.setReplyContent(replyContent);
				
//				System.out.println("result 전");

				int result = service.insertReplyAnswer(reply);
				 
//				System.out.println("result: " + result);
				
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
