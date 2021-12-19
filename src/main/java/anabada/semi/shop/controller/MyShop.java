package anabada.semi.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myShop/*")
public class MyShop extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		
		String command = uri.substring((contextPath + "/myShop/").length());
//		System.out.println(contextPath);
		
		String path = null;
		
		try {
			
			if(command.equals("itemList")) {
				if(method.equals("GET")) {
					path = "/WEB-INF/views/myShop/itemList.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
				}else {
					
				}
				
			}else if(command.equals("wishList")) {
				if(method.equals("GET")) {
					path = "/WEB-INF/views/myShop/wishList.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
				}else {
					
				}
				
			}else if(command.equals("postScript")) {
				if(method.equals("GET")) {
					path = "/WEB-INF/views/myShop/postScript.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
				}else {
					
				}
				
			}else if(command.equals("buyList")) {
				if(method.equals("GET")) {
					path = "/WEB-INF/views/myShop/buyList.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
				}else {
					
				}
				
			}else if(command.equals("sellList")) {
				if(method.equals("GET")) {
					path = "/WEB-INF/views/myShop/sellList.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
				}else {
					
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
