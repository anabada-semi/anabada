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
import anabada.semi.shop.model.vo.Shop;

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
				Shop shop = service.selectShop(loginMember.getMemberNo());
				
				if(shop == null) {// 상점이 없을 시
					if(service.createShop(loginMember.getMemberNo(), loginMember.getMemberNm()) > 0 ) {// 상점 생성
						shop = service.selectShop(loginMember.getMemberNo()); // 생성 후 다시 조회
					}
				}
					
				session.setAttribute("loginMember", loginMember);
				session.setAttribute("locationShop", shop);

				session.setMaxInactiveInterval(600);

			}else {
				session.setAttribute("message", "아이디 또는 비밀번호를 확인해주세요!");
				
			}
			
			resp.sendRedirect(req.getContextPath());

		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMessage", "로그인 과정에서 문제 발생");
			req.getRequestDispatcher("/WEB-INF/views/errorPage.jsp").forward(req, resp);
			
		}
		
	}
	
}
		
		
	

