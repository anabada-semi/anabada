package anabada.semi.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import anabada.semi.member.model.service.MemberService;
import anabada.semi.member.model.vo.Member;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/loginPage.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		
		MemberService service = new MemberService();
		
		try {
			
			Member loginMember = service.login(memberId, memberPw);
			
			HttpSession session = req.getSession();

			if(loginMember != null) {
					
					session.setAttribute("loginMember", loginMember);

					session.setMaxInactiveInterval(600);

			}else {
				
				session.setAttribute("message", "아이디 또는 비밀번호가 틀렸습니다!");
				
			}
			
			System.out.println(loginMember);
			
			resp.sendRedirect(req.getContextPath());

		}catch(Exception e) {
			
		}
		
	}
	
}
		
		
	

