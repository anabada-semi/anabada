package anabada.semi.item.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anabada.semi.item.model.service.ItemService;

@WebServlet("/item/*")
public class ItemController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getMethod();
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring( (contextPath + "/item/").length() );
		
		try {
			
			ItemService service = new ItemService();
			
			if(command.equals("insert")) {
				
				String path = "/WEB-INF/views/salePage.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
				
			}
			
			else if(command.equals("update")) {
				String path = "/WEB-INF/views/saleUpdatePage.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
				
				
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	
	}
	
}
