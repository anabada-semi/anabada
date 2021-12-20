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
import anabada.semi.item.model.vo.ItemImg;
import anabada.semi.item.model.vo.Time;

@WebServlet("/detail")
public class DetailSelectItemServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			// 카테고리 옵션 목록
			ItemSelectService service = new ItemSelectService();
			
			// 카테고리 목록 불러오기
			List<Item> categoryList = service.selectCategory();
			
//			System.out.println("categoryList : " + categoryList);
//			System.out.println("categoryList : " + categoryList);
			
			req.setAttribute("categoryList", categoryList);
			System.out.println("item 전");
			int itemNo = 3;
			
			// 선택한 아이템 조회
			Item item = service.selectItem(itemNo);
			System.out.println("item 후");
			
			String date = Time.calculateTime(item.getItemDate());
			
			req.setAttribute("item", item);
			req.setAttribute("date", date);
			
			List<ItemImg> itemImg = service.selectItemImg(itemNo);
			
//			System.out.println("ItemImg: " + ItemImg);
			
			req.setAttribute("itemImg", itemImg);
			
			String path = "/WEB-INF/views/detailSelectItem.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		} catch (Exception e) {

		
		
		}
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
