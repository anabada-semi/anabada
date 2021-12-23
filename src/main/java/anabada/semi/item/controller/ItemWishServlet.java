package anabada.semi.item.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import anabada.semi.item.model.service.ItemSelectService;
import anabada.semi.item.model.vo.Item;
import anabada.semi.item.model.vo.ItemImg;
import anabada.semi.item.model.vo.Reply;
import anabada.semi.item.model.vo.Time;
import anabada.semi.member.model.vo.Member;
import anabada.semi.shop.model.vo.PostScript;
import anabada.semi.shop.model.vo.Shop;

@WebServlet("/wish/*")
public class ItemWishServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getMethod();
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring( (contextPath + "/wish/").length() );
		
		ItemSelectService service = new ItemSelectService();
		
		String path = null;
		
		try {
			// 찜 목록 조회
			if(command.equals("select")) {
				
				int itemNo = Integer.parseInt(req.getParameter("itemNo"));
				int memberNo = Integer.parseInt(req.getParameter("memberNo"));
				
				// (0: 삽입 실패, 1: 삽입됨, -1: 있음, -2: 삭제됨)
				int result = service.wishSelect(itemNo, memberNo);
				
				new Gson().toJson(result, resp.getWriter());
				
			}
			// 찜 목록 삽입
			else if(command.equals("update")) {
				
				int itemNo = Integer.parseInt(req.getParameter("itemNo"));
				int memberNo = Integer.parseInt(req.getParameter("memberNo"));
				
				// (0: 삽입 실패, 1: 삽입됨, -1: 있음, -2: 삭제됨)
				int result = service.wishUpdate(itemNo, memberNo);
				
				
				new Gson().toJson(result, resp.getWriter());
				
			}
			
			// 찜 목록 삭제
			else if(command.equals("delete")) {
				
				int itemNo = Integer.parseInt(req.getParameter("itemNo"));
				int memberNo = Integer.parseInt(req.getParameter("memberNo"));
				
				// (0: 삽입 실패, 1: 삽입됨, -1: 있음, -2: 삭제됨)
				int result = service.wishDelete(itemNo, memberNo);
				
				new Gson().toJson(result, resp.getWriter());
				
			}
			
			// 찜 개수 조회
			if(command.equals("count")) {
				
				int itemNo = Integer.parseInt(req.getParameter("itemNo"));
				
				int count = service.wishCount(itemNo);
				
				new Gson().toJson(count, resp.getWriter());
				
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
