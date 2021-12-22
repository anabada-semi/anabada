package anabada.semi.shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import anabada.semi.common.MyRenamePolicy;
import anabada.semi.common.XSS;
import anabada.semi.item.model.vo.Item;
import anabada.semi.member.model.service.MemberService;
import anabada.semi.member.model.vo.Member;
import anabada.semi.shop.model.service.ShopService;
import anabada.semi.shop.model.vo.PostScript;
import anabada.semi.shop.model.vo.Purchase;
import anabada.semi.shop.model.vo.Shop;
import anabada.semi.shop.model.vo.Wish;

@WebServlet("/myShop/*")
public class MyShopController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		
		String command = uri.substring((contextPath + "/myShop/").length());
//		System.out.println(contextPath);
		
		String path = null;
		
		ShopService service = new ShopService();
		HttpSession session = req.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		Shop locationShop = (Shop)session.getAttribute("locationShop");
		
		Shop shop = null;
		
		try {
			
			if(command.equals("itemList")) {
				if(method.equals("GET")) {
					
					path = "/WEB-INF/views/myShop/itemList.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
					
				}
				
			}else if(command.equals("wishList")) {
				if(method.equals("GET")) {
					
					path = "/WEB-INF/views/myShop/wishList.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
				}
				
			}else if(command.equals("postScript")) {
				if(method.equals("GET")) {
					
					path = "/WEB-INF/views/myShop/postScript.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
				}
				
			}else if(command.equals("buyList")) {
				if(method.equals("GET")) {
					
					path = "/WEB-INF/views/myShop/buyList.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
				}
				
			}else if(command.equals("sellList")) {
				if(method.equals("GET")) {
					
					path = "/WEB-INF/views/myShop/sellList.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
				}
				
			}else if(command.equals("imgInsert")) {
				if(method.equals("GET")) {
					
					int maxSize = 1024 * 1024 * 100;
					
					// 프로젝트의 webapp폴더의 컴퓨상 실제 절대 경로
					String root = session.getServletContext().getRealPath("/");
					
					// 나머지 파일 경로 (DB에 저장되어 주소 경로로 사용할 예정)
					String filePath = "/resources/images/myShop/profile/";
					
					// 실제 경로
					String realPath = root + filePath;
					
					MultipartRequest mReq = new MultipartRequest(req, realPath, maxSize, "UTF-8", new MyRenamePolicy());     
					
					
					Enumeration<String> files = mReq.getFileNames();
					
					path = "/WEB-INF/views/myShop/myShop.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
				}
				
			}else if(command.equals("shopNameCng")) {
				if(method.equals("GET")) {
					
					String inputName = new XSS().replaceParameter(req.getParameter("inputName"));
					int memberNo = Integer.parseInt( req.getParameter("memberNo") );
					
					int result = service.updateShopName(inputName, memberNo);
					
					if(result > 0) {
						
						shop =  new MemberService().selectShop(loginMember.getMemberNo());
						session.setAttribute("locationShop", shop);
					}
					
					resp.getWriter().print(result);
				}
				
			}else if(command.equals("shopContentCng")) {
				if(method.equals("GET")) {
					
					String inputContent = new XSS().replaceParameter(req.getParameter("inputContent"));
					int memberNo = Integer.parseInt( req.getParameter("memberNo") );
					
					resp.getWriter().print(service.updateShopContent(inputContent, memberNo));
				}
				
			}else if(command.equals("myShop")) {
				if(method.equals("GET")) {
					
					int shopNo = Integer.parseInt(req.getParameter("no"));
					
					if(shopNo != loginMember.getMemberNo()) 
						shop = new MemberService().selectShop(shopNo);
					
					req.setAttribute("locationShop", shop);
					session.setAttribute("shopNo", shopNo);
					
					req.getRequestDispatcher("/WEB-INF/views/myShop/myShop.jsp").forward(req, resp);
				}
				
			}else if(command.equals("insertPostScript")) {
				if(method.equals("GET")) {
					
					String postScript = req.getParameter("postScript");
					int shopNo = (int)session.getAttribute("shopNo");
					
					resp.getWriter().print(service.insertPostScript(shopNo, loginMember.getMemberNo(), postScript));
					
				}
				
			}else if(command.equals("updatePostScript")) {
				if(method.equals("GET")) {
					
					int postNo = Integer.parseInt(req.getParameter("postNo"));
					String postScript = req.getParameter("postScript");
					
					resp.getWriter().print(service.updatePostScript(postNo, postScript));
				}
				
			}else if(command.equals("deletePostScript")) {
				if(method.equals("GET")) {
					
					int postNo = Integer.parseInt(req.getParameter("postNo"));
					
					resp.getWriter().print(service.deletePostScript(postNo));
				}
				
			}else if(command.equals("selectPostScript")) {
				if(method.equals("GET")) {
					
					int memberNo = Integer.parseInt(req.getParameter("memberNo"));
					int shopNo = (int)session.getAttribute("shopNo");
					
					List<PostScript> pList = service.selectPostList(shopNo, memberNo);

					new Gson().toJson(pList, resp.getWriter());
					
				}
				
			}else if(command.equals("selectItemList")) {
				if(method.equals("GET")) {
					
					int shopNo = (int)session.getAttribute("shopNo");
					
					List<Item> iList = service.selectItem(shopNo);
					
					req.setAttribute("itemList", iList);
					
					new Gson().toJson(iList, resp.getWriter());
				}
				
			}else if(command.equals("wishItemList")) {
				if(method.equals("GET")) {
					
					int shopNo = (int)session.getAttribute("shopNo");
					
					List<Wish> wList = service.selectWsih(shopNo);
					
					req.setAttribute("wishList", wList);
					
					new Gson().toJson(wList, resp.getWriter());
				}
				
			}else if(command.equals("deleteWish")) {
				if(method.equals("GET")) {
					
					int itemNo = Integer.parseInt(req.getParameter("itemNo"));
//					int shopNo = Integer.parseInt(req.getParameter("shopNo"));
					int shopNo = (int)session.getAttribute("shopNo");
					
					resp.getWriter().print( service.deleteWish(itemNo, shopNo) );
				}
				
			}else if(command.equals("buyItemList")) {
				if(method.equals("GET")) {
					
//					int shopNo = Integer.parseInt(req.getParameter("shopNo"));
					int shopNo = (int)session.getAttribute("shopNo");
					
					List<Purchase> pList = service.selectBuyItem(shopNo);
					
					new Gson().toJson(pList, resp.getWriter());
					
				}
				
			}else if(command.equals("sellItemList")) {
				if(method.equals("GET")) {
					
//					int shopNo = Integer.parseInt(req.getParameter("shopNo"));
					int shopNo = (int)session.getAttribute("shopNo");
					
					List<Item> sList = service.selectSellItem(shopNo);
					
					new Gson().toJson(sList, resp.getWriter());
				}
				
			}else if(command.equals("soldOut")) {
				if(method.equals("GET")) {
					
					int shopNo = Integer.parseInt(req.getParameter("shopNo"));
					int itemNo = Integer.parseInt(req.getParameter("itemNo"));
					
					resp.getWriter().print( service.soldOutItem(shopNo, itemNo) );
					
				}
				
			}else if(command.equals("onSale")) {
				if(method.equals("GET")) {
					
					int shopNo = Integer.parseInt(req.getParameter("shopNo"));
					int itemNo = Integer.parseInt(req.getParameter("itemNo"));
					
					resp.getWriter().print( service.onSaleItem(shopNo, itemNo) );
					
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
