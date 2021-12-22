package anabada.semi.apipratice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import anabada.semi.member.model.service.MemberService;
import anabada.semi.member.model.vo.Member;

@WebServlet("/sendKey")
public class SendKeyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 세션에서 인증키를 얻어와서
		HttpSession mailCheck = req.getSession();
		
		int key = (int)mailCheck.getAttribute("ran");
		System.out.println(key);
		
		int inputKey = Integer.parseInt(req.getParameter("inputKey"));
		System.out.println(inputKey);
		
		String path = "";
		
		// 입력한 번호가 인증키와 같다면
		if(key == inputKey) {
		
			try {
				
				// 입력한 이메일을 세션에서 불러와
				String inputEmail = (String)mailCheck.getAttribute("inputEmail");
				System.out.println(inputEmail);
				
				MemberService service = new MemberService();
				
				// 회원정보 불러오기
				Member member = service.searchMember(inputEmail); 
				System.out.println(member);
				
				if(member != null) {
				
					mailCheck.setAttribute("searchMember", member);
					
					path = "/WEB-INF/views/member/updatePwPage.jsp";
					
				}else {
					System.out.println("?");
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else {
			path = "/WEB-INF/views/mainPage.jsp";
			mailCheck.setAttribute("message", "인증에 실패하였습니다.");
			
		}
		
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
}
