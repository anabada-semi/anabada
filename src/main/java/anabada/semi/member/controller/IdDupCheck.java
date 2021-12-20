package anabada.semi.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anabada.semi.member.model.service.MemberService;

@WebServlet("/member/idDupCheck")
public class IdDupCheck extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String inputId = req.getParameter("inputId");
		
		try {
			
			MemberService service = new MemberService();
			
			int result = service.idDupCheck(inputId);
			
			PrintWriter out = resp.getWriter();
			
			out.print(result);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
