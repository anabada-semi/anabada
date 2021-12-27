package anabada.semi.item.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import anabada.semi.common.MyRenamePolicy;
import anabada.semi.item.model.service.ItemService;
import anabada.semi.item.model.vo.Category;
import anabada.semi.item.model.vo.Item;
import anabada.semi.item.model.vo.ItemImg;
import anabada.semi.member.model.vo.Member;

@WebServlet("/item/*")
public class ItemController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getMethod();
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring( (contextPath + "/item/").length() );
		
		String path = null;
		RequestDispatcher dispatcher = null;
		String message = null;
		HttpSession session = req.getSession();
		try {
			
			ItemService service = new ItemService();
			
			if(command.equals("insert")) {
				
				if(method.equals("GET")){
					
					List<Category> category = service.selectCategory();
					
					req.setAttribute("category", category);
					
					path = "/WEB-INF/views/salePage.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
					
					// 최소 사진 카운트
					int count = 0;
					req.setAttribute("ms", count);
					
				}
				
				else {
					
					int maxSize = 1024 * 1024 * 100;
					
					//HttpSession session = req.getSession();
					
					String root = session.getServletContext().getRealPath("/");
					String filePath = "/resources/images/item/";
					
					String realPath = root + filePath;
					
					MultipartRequest mReq = new MultipartRequest(req, realPath, maxSize, "UTF-8", new MyRenamePolicy());
					
					String itemName = mReq.getParameter("itemName");
					int categoryCode = Integer.parseInt( mReq.getParameter("categoryCode"));
					String itemPrice = mReq.getParameter("itemPrice");
					String itemInfo = mReq.getParameter("itemInfo");
					
					int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
					
					Item item = new Item();
					item.setItemName(itemName);
					item.setCategoryCode(categoryCode);
					item.setItemPrice(itemPrice);
					item.setItemInfo(itemInfo);
					item.setMemberNo(memberNo);
					
					
					Enumeration<String> files = mReq.getFileNames();
					
					List<ItemImg> imgList = new ArrayList<ItemImg>();
					

					
					int level = 0;
					
					while(files.hasMoreElements()){
						
						String name = files.nextElement(); 
						
						if(mReq.getFilesystemName(name) != null) {
							
							ItemImg temp = new ItemImg();
							
							temp.setImgName(mReq.getFilesystemName(name));
							temp.setImgOriginal(mReq.getOriginalFileName(name));
							temp.setImgPath(filePath);
							temp.setImgLevel( level );
							
							imgList.add(temp);
							
							level++;
						}
						
					}
					
					int result = service.insertItem(item, imgList);
					
					if(result > 0) {
						message = "게시글이 등록 되었습니다.";
						path = "/anabada/detail/select?no="+result;
					}else {
						message = "게시글 등록 실패!";
						path = "insert";
					}

					// session.setAttribute("uid2", "제발요 되주세요");
					session.setAttribute("message", message);
					resp.sendRedirect(path);
					
				}
				
				
			}
			
			else if(command.equals("updateForm")) {
				
				int itemNo = Integer.parseInt(req.getParameter("no"));
				
				Item item = service.updateView(itemNo);
				
				List<Category> category = service.selectCategory();
				
				req.setAttribute("item", item);
				req.setAttribute("category", category);
				
				// 최소 사진 카운트
				//System.out.println("시이작" + item);
				//System.out.println("이미지" + item.getImgList());
				int count = 0;
				for(ItemImg i : item.getImgList()) {
					count++;
					System.out.println(count);
				}
				req.setAttribute("ms", count);
				
				path = "/WEB-INF/views/saleUpdatePage.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
				
				
			}else if(command.equals("update")) {
				
				int maxSize = 1024 * 1024 * 100;
				
				//HttpSession session = req.getSession();
				
				String root = session.getServletContext().getRealPath("/");
				String filePath = "/resources/images/item/";
				
				String realPath = root + filePath;
				
				MultipartRequest mReq = new MultipartRequest(req, realPath, maxSize, "UTF-8", new MyRenamePolicy());
				
				String itemName = mReq.getParameter("itemName");
				int categoryCode = Integer.parseInt( mReq.getParameter("categoryCode"));
				String itemPrice = mReq.getParameter("itemPrice").replace(",","");
				String itemInfo = mReq.getParameter("itemInfo");
				
				int itemNo = Integer.parseInt( mReq.getParameter("no"));
				
				int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
				
				System.out.print(Arrays.toString(mReq.getParameterValues("deleteNo")));
				
			
				List<String> deleteNo = new ArrayList<String>();
				int dn = 0;
				if(mReq.getParameterValues("deleteNo") !=null ) {
					
					deleteNo = Arrays.asList(mReq.getParameterValues("deleteNo"));
					
				} else { 
				    
				    deleteNo.add("3");
				}
				
				
				Item item = new Item();
				item.setItemName(itemName);
				item.setCategoryCode(categoryCode);
				item.setItemPrice(itemPrice);
				item.setItemInfo(itemInfo);
				item.setMemberNo(memberNo);
				item.setItemNo(itemNo);
				
				Enumeration<String> files = mReq.getFileNames();
				
				List<ItemImg> imgList = new ArrayList<ItemImg>();
				
				int level = 0;
				
				while(files.hasMoreElements()){
					
					String name = files.nextElement(); 
					
					if(mReq.getFilesystemName(name) != null) {
						
						ItemImg temp = new ItemImg();
						
						temp.setImgName(mReq.getFilesystemName(name));
						temp.setImgOriginal(mReq.getOriginalFileName(name));
						temp.setImgPath(filePath);
						temp.setImgLevel( level );
						temp.setItemNo(itemNo);
						
						imgList.add(temp);
						level++;
					}
						
				}
				
				int result = service.updateItem(item, imgList, deleteNo);
				
				if(result > 0) {
					message = "게시글이 수정되었습니다.";
					path = "/anabada/detail/select?no="+itemNo;
				}else {
					message = "게시글 수정 실패!";
					path = req.getHeader("referer") + "?no=" + itemNo;
				}
				session.setAttribute("message", message);
				resp.sendRedirect(path);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	
	}
	
}
