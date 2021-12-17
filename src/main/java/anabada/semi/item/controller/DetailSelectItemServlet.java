package anabada.semi.item.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anabada.semi.item.model.service.ItemSelectService;
import anabada.semi.item.model.vo.Item;

@WebServlet("/detail")
public class DetailSelectItemServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			ItemSelectService service = new ItemSelectService();
			
			String path = "/WEB-INF/views/detailSelectItem.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			List<Item> categoryList = service.selectCategory();
			
			
			
			
			
			
		} catch (Exception e) {

		
		
		}
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
