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
		
		int memberNo = ((Member)mailCheck.getAttribute("searchMember")).getMemberNo();
		
	}
	
}
