package anabada.semi.apipratice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("sendKey")
public class SendKeyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession mailCheck = req.getSession();
		int key = (int)mailCheck.getAttribute("ran");
		
		int inputKey = Integer.parseInt(req.getParameter("inputKey"));
		
		String path = "";
		
		if(key == inputKey) {
			path = "/WEB-INF/views/member/updatePwPage.jsp";
			
		}else {
			path = "/WEB-INF/views/member/referencePage.jsp";
			req.setAttribute("message", "인증에 실패하였습니다.");
			
		}
		
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
}
