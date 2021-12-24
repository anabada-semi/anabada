package anabada.semi.item.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anabada.semi.item.model.service.ItemBoardService;
import anabada.semi.item.model.service.ItemSelectService;
import anabada.semi.item.model.vo.Item;
import anabada.semi.item.model.vo.Pagination;
import anabada.semi.item.model.vo.Time;

@WebServlet("/categoryItem/*")
public class ItemBoardServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getMethod();
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring( (contextPath + "/categoryItem/").length() );
		
		String path = null;
		RequestDispatcher dispatcher = null;
		String message = null;
			
		ItemBoardService service = new ItemBoardService();

		// 카테고리에 따른 상품 조회
		if(command.equals("list")){
			
			try {
				
				int categoryTag = Integer.parseInt(req.getParameter("category-tag"));
				
				int cp = req.getParameter("cp") == null ? 1 : Integer.parseInt(req.getParameter("cp"));
				
				Pagination pagination = service.getCategoryPagination(cp, categoryTag);
				
				// 글 목록 조회
				List<Item> itemList = service.categoryItemList(pagination, categoryTag);
				
				for(Item item : itemList) {
					item.setDate(Time.calculateTime(item.getItemDate()));
				}
				
				// 카테고리 목록 조회
				List<Item> categoryList = new ItemSelectService().selectCategory();
				
				req.setAttribute("categoryTag", categoryTag);
				req.setAttribute("categoryList", categoryList);
				req.setAttribute("pagination", pagination);
				req.setAttribute("itemList", itemList);
				
				path = "/WEB-INF/views/itemPage.jsp";
				dispatcher = req.getRequestDispatcher(path);
				dispatcher.forward(req, resp);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		// 검색에 따른 상품 조회
		else if(command.equals("search")) {
			
			String searchInput = req.getParameter("search_input");
			
			int cp = req.getParameter("cp") == null ? 1 : Integer.parseInt(req.getParameter("cp"));
			
			try {
				Pagination pagination = service.getSearchPagination(cp, searchInput);
				
				// 글 목록 조회
				List<Item> itemList = service.searchItemList(pagination, searchInput);
				
				for(Item item : itemList) {
					item.setDate(Time.calculateTime(item.getItemDate()));
				}
				
				req.setAttribute("searchInput", searchInput);
				req.setAttribute("pagination", pagination);
				req.setAttribute("itemList", itemList);
				
				path = "/WEB-INF/views/itemSearchPage.jsp";
				dispatcher = req.getRequestDispatcher(path);
				dispatcher.forward(req, resp);
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
			
			
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}