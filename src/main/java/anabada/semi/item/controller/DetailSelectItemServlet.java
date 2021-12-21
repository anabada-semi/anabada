package anabada.semi.item.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

@WebServlet("/detail/*")
public class DetailSelectItemServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ItemSelectService service = new ItemSelectService();
		
		try {
			
			// 카테고리 옵션 목록
			// 카테고리 목록 불러오기
			List<Item> categoryList = service.selectCategory();
			
			req.setAttribute("categoryList", categoryList);
			int itemNo = 3;
			
			// 선택한 아이템 조회
			Item item = service.selectItem(itemNo);
			
			String date = Time.calculateTime(item.getItemDate());
			
			req.setAttribute("item", item);	// 상품
			req.setAttribute("date", date);	// 상품 등록 날짜
			
			// 상품 이미지 조회
			List<ItemImg> itemImg = service.selectItemImg(itemNo);
			
//			System.out.println("ItemImg: " + ItemImg);
			
			req.setAttribute("itemImg", itemImg);	// 상품 이미지
			
			// 로그인한 회원의 세션 정보 얻어오기
			Member loginMember = (Member)req.getSession().getAttribute("loginMember"); 
			
			int memberNo = 0;
			
			if(loginMember != null) {
				memberNo = loginMember.getMemberNo();
			}
			
			// 댓글 조회하기
			List<Reply> rList = service.selectReplyList(itemNo);
			
			for(Reply dateItem : rList) {
				
				SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		        
				String dateString = sdf.format(dateItem.getReplyDate());
				
			}
			
			req.setAttribute("rList", rList);	// 댓글 목록
			
//			System.out.println(rList);
			
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
