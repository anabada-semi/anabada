package anabada.semi.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import anabada.semi.member.model.vo.Member;
import anabada.semi.member.model.service.MemberService;

@WebServlet("/member/signUp")
public class SignUpServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "/WEB-INF/views/member/signUpPage.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		String memberNm = req.getParameter("memberNm");
		String memberEmail = req.getParameter("memberEmail");
		String[] phone = req.getParameterValues("memberPhone");
		String[] address = req.getParameterValues("address");
		String memberPhone = String.join("-", phone);

		String memberAddress = null;
		
		if(!address[0].equals("")) {
			memberAddress = String.join(",,", address);
			memberAddress = replaceParameter(memberAddress);
		}
		
		
		Member member = new Member(memberId, memberPw, memberNm, memberEmail, memberPhone, memberAddress);

		try {
			
			MemberService service = new MemberService();
			
			int result = service.signUp(member);
			
			String message = null;
			
			if(result > 0 ) {
				message = "회원 가입 성공!";
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			resp.sendRedirect(req.getContextPath());
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		

	}
	
	private String replaceParameter(String param) {

		String result = param;
		
		if(result != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
					
		}
		
		return result;
		
	}
	
}
