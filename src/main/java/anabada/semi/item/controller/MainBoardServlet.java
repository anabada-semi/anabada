package anabada.semi.item.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anabada.semi.item.model.service.ItemBoardService;
import anabada.semi.item.model.vo.Item;
import anabada.semi.item.model.vo.Pagination;
import anabada.semi.item.model.vo.Time;

@WebServlet("/mainItem")
public class MainBoardServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = null;
		RequestDispatcher dispatcher = null;
		String message = null;
				
		try {
			
			ItemBoardService service = new ItemBoardService();
			
			int cp = req.getParameter("cp") == null ? 1 : Integer.parseInt(req.getParameter("cp"));
			
			Pagination pagination = service.getPagination(cp);
			
			// 글 목록 조회
			List<Item> itemList = service.itemList(pagination);
			
			// 가격 천 단위 소수점 표기
			DecimalFormat df = new DecimalFormat("###,###");
			
			for(Item item : itemList) {
				// 시간 변환
				item.setDate(Time.calculateTime(item.getItemDate()));
				
				// 소수점 변환
				int dfnum = Integer.parseInt(item.getItemPrice());
				String price = df.format(dfnum);
				item.setItemPrice(price);
			}
			
			req.setAttribute("pagination", pagination);
			req.setAttribute("itemList", itemList);
			
			path = "/WEB-INF/views/mainPage.jsp";
			dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
