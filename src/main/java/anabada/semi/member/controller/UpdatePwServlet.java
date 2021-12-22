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

@WebServlet("/member/updatePw")
public class UpdatePwServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession mailCheck = req.getSession();
		
		String memberPw = req.getParameter("memberPw");
		int memberNo = ((Member)mailCheck.getAttribute("searchMember")).getMemberNo();
		System.out.println(memberNo);
		
		try {
			
			MemberService service = new MemberService();
			
			int result = service.updatePw(memberNo, memberPw);
			
			
			if( result > 0 ) {
				
				mailCheck.setAttribute("message", "비밀번호 변경 성공!");
				
			}else {
				mailCheck.setAttribute("message", "비밀번호 변경 실패");
			}
			
			resp.sendRedirect(req.getContextPath());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
