package anabada.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		
		req.setCharacterEncoding("UTF-8");
		
		String memberId = req.getParameter("id");
		String memberPw = req.getParameter("pw");
		
		MemberService service = new MemberService();
		
		try {
			
			Member loginMember = service.login(memberId, memberPw);
			
			System.out.println(loginMember);
			
			HttpSession session = req.getSession();
			
			if(loginMember != null) {
				System.out.println("로그인 성공");
				session.setAttribute("loginMember", loginMember);
				session.setMaxInactiveInterval(3600);
				
				resp.sendRedirect(req.getContextPath());
			}else {
				System.out.println("없는 회원");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
