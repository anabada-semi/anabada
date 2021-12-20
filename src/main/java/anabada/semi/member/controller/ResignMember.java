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

@WebServlet("/member/resignMember")
public class ResignMember extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/resignMember.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberPw = req.getParameter("memberPw");
		HttpSession session = req.getSession();
		
		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		
		MemberService service = new MemberService();
		
		try {
			int result = service.resignMember(memberPw, memberNo);
			
			if(result > 0) {
				session.setAttribute("message", "회원이 탈퇴되었습니다.");
				session.invalidate();
				resp.sendRedirect(req.getContextPath());
				
			}else {
				session.setAttribute("message", "비밀번호가 일치하지 않습니다.");
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMessage", "회원 탈퇴 과정에서 문제 발생");
			req.getRequestDispatcher("/WEB-INF/views/errorPage.jsp").forward(req, resp);
		}
		
	}

}
