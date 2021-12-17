package anabada.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anabada.semi.member.model.vo.Member;

@WebServlet("/member/signUp")
public class SignUpServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "/WEB-INF/views/member/signUpPage.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String memberId = req.getParameter("memberId");
		String memberNm = req.getParameter("memberNm");
		String memberPw = req.getParameter("memberPw");
		String memberEmail = req.getParameter("memberEmail");
		String memberPhone = req.getParameter("memberPhone");
		
		Member member = new Member(memberId, memberPw, memberNm, memberEmail, memberPhone);

		System.out.println(member);
		
	}
	
}
