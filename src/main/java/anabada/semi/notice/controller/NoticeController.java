package anabada.semi.notice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import anabada.semi.member.model.vo.Member;
import anabada.semi.notice.model.service.NoticeService;
import anabada.semi.notice.model.vo.Notice;

@WebServlet("/notice/*")
public class NoticeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String method = req.getMethod();
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring( (contextPath + "/notice/").length() );
		
		String path = null; 

		HttpSession session = req.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		NoticeService service = new NoticeService();
		
		try {
			if(command.equals("select")) {
				
				if(loginMember != null) {
					
					List<Notice> noticeList = service.selectNotice(loginMember.getMemberNo());
					
					List<Notice> noticeList2 = service.selectNotice2(loginMember.getMemberNo());
					
					noticeList.addAll(noticeList2);
					
					new Gson().toJson(noticeList, resp.getWriter());
				}
				
			}
			
			else if(command.equals("update")) {
				
				int noticeNo = Integer.parseInt(req.getParameter("noticeNo"));
				
				int result = service.updateNotice(noticeNo);
				
				new Gson().toJson(result, resp.getWriter());
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
