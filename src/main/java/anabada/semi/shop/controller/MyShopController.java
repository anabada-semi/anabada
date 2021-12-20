package anabada.semi.shop.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import anabada.semi.common.MyRenamePolicy;
import anabada.semi.common.XSS;
import anabada.semi.shop.model.service.ShopService;

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
				
			}else if(command.equals("imgInsert")) {
				if(method.equals("GET")) {
					
					int maxSize = 1024 * 1024 * 100;
					HttpSession session = req.getSession();
					
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
				}else {
					
				}
			}else if(command.equals("shopNameCng")) {
				if(method.equals("GET")) {
					String inputName = new XSS().replaceParameter(req.getParameter("inputName"));
					int memberNo = Integer.parseInt( req.getParameter("memberNo") );
					
					resp.getWriter().print(service.updateShopName(inputName, memberNo));
				}
			}else if(command.equals("shopContentCng")) {
				if(method.equals("GET")) {
					String inputContent = new XSS().replaceParameter(req.getParameter("inputContent"));
					int memberNo = Integer.parseInt( req.getParameter("memberNo") );
					
					resp.getWriter().print(service.updateShopContent(inputContent, memberNo));
				}
			}else if(command.equals("myShop")) {
				if(method.equals("GET")) {
					req.getRequestDispatcher("/WEB-INF/views/myShop/myShop.jsp").forward(req, resp);
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
