package anabada.semi.item.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import anabada.semi.item.model.service.ItemBoardService;
import anabada.semi.member.model.vo.Member;

@WebServlet("/sideBar/*")
public class SideBarServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String method = req.getMethod();
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring( (contextPath + "/sideBAR/").length() );
		
		String path = null;
		RequestDispatcher dispatcher = null;
		String message = null;
			
		ItemBoardService service = new ItemBoardService();
		
		// 찜 카운트 ajax
		if(command.equals("wish")){
		
			try {
				
				HttpSession session = req.getSession();
				
				int memberNo = 0;
				
				Member loginMember = (Member)session.getAttribute("loginMember");
				
				if(loginMember != null) {
					memberNo = loginMember.getMemberNo();
				};
				
				int result = service.wishCount(memberNo);
				
				PrintWriter out = resp.getWriter();
				out.print(result);
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}			
			
		}
		
		else if(command.equals("recently")){
			
			try {
				
				
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
