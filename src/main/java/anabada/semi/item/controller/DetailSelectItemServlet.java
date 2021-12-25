package anabada.semi.item.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import anabada.semi.item.model.service.ItemSelectService;
import anabada.semi.item.model.vo.Item;
import anabada.semi.item.model.vo.ItemImg;
import anabada.semi.item.model.vo.Reply;
import anabada.semi.item.model.vo.Time;
import anabada.semi.member.model.vo.Member;
import anabada.semi.shop.model.vo.PostScript;
import anabada.semi.shop.model.vo.Shop;

@WebServlet("/detail/*")
public class DetailSelectItemServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getMethod();
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring( (contextPath + "/detail/").length() );
		
		// 세션
		HttpSession session = req.getSession();
		
		ItemSelectService service = new ItemSelectService();
		String path = null;
		try {
			if(command.equals("select")) {
				
				// 카테고리 옵션 목록
				// 카테고리 목록 불러오기
				List<Item> categoryList = service.selectCategory();
				
				req.setAttribute("categoryList", categoryList);
				
				int itemNo = Integer.parseInt(req.getParameter("no"));
				
				// 선택한 아이템 조회
				Item item = service.selectItem(itemNo);
				
				String date = Time.calculateTime(item.getItemDate());
				
				req.setAttribute("item", item);	// 상품
				req.setAttribute("date", date);	// 상품 등록 날짜
				
				// 상품 이미지 조회
				List<ItemImg> itemImg = service.selectItemImg(itemNo);
				
				req.setAttribute("itemImg", itemImg);	// 상품 이미지
				
				// 로그인한 회원의 세션 정보 얻어오기
				Member loginMember = (Member)req.getSession().getAttribute("loginMember"); 
				
				 int memberNo = 0;
				
				if(loginMember != null) {
					
					memberNo = loginMember.getMemberNo();

				}
				
				// 최근 본 상품 세션에 올리기
				List<ItemImg> recentItemList = null;
				int recentCount = 1; // 박스 개수 체크용 변수
				boolean recentCheck = true; // 중복 체크용 변수
				
				
				if(session.getAttribute("recentItemList") == null) {
					recentItemList = new ArrayList<ItemImg>();
					
				}else {
					recentItemList = (List<ItemImg>)session.getAttribute("recentItemList");
					
					// 중복 방지
					for(ItemImg i : recentItemList) {

						if(itemNo == i.getItemNo()) {
							System.out.println(i.getItemNo() + "중복");
							recentCheck = false;
							--recentCount;
							System.out.println("중복빼기" + recentCount + "개");
						}
						// 중복이 아니면 박스 1 추가
						++recentCount;
						System.out.println(recentCount + "개");							
					
					}

				}
				System.out.println(recentItemList);
				
				if(recentCheck) {
					recentItemList.add(itemImg.get(0));		
					//Set<ItemImg> set = new HashSet<ItemImg>(recentItemList); // SET은 중복허용이 안된다고 아는데 흠..
					//List<ItemImg> tran = new ArrayList<ItemImg>(set); // 
					//recentItemList = tran;
					System.out.println(recentItemList);
					session.setAttribute("recentItemList", recentItemList);
					
					// 공간이 5개 초과하면 
					if(recentCount > 5) {
						recentItemList.remove(0); // 0번 인덱스 ItemImg 삭제
					}
					


				}
				
				
				
				
				// 댓글 조회하기
				List<Reply> rList = service.selectReplyList(itemNo);
				List<Reply> answer = service.selectReplyListReverse(itemNo);
				
				req.setAttribute("rList", rList);	// 댓글 목록
				req.setAttribute("answer", answer);	// 댓글 역순 목록
				
				// 상점 정보 조회
				Shop shop = service.selectShop(itemNo);
				
				req.setAttribute("shop", shop);	// 상점 정보
				
				// 상점 후기 조회
				List<PostScript> postScriptList = service.selectPostScript(shop.getMemberNo());
				
				req.setAttribute("postScriptList", postScriptList);	// 상점 정보
				
				
				path = "/WEB-INF/views/detailSelectItem.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
			}
			// 조회수 증가
			else if(command.equals("view")) {
				
				int itemNo = Integer.parseInt(req.getParameter("itemNo"));
				
				service.updateView(itemNo);
				
				int view = service.selectView(itemNo);
				
				new Gson().toJson(view, resp.getWriter());
				
			}
			// 카테고리 조회
			else if(command.equals("category")) {
				
				// 카테고리 옵션 목록
				// 카테고리 목록 불러오기
				List<Item> categoryList = service.selectCategory();
				
				new Gson().toJson(categoryList, resp.getWriter());
				
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
