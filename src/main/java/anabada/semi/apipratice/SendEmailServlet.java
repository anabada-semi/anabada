package anabada.semi.apipratice;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sendEmail")
public class SendEmailServlet extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      // 입력 받은 이메일
      String inputEmail = req.getParameter("inputEmail");
      
         // 메일 인코딩
       final String bodyEncoding = "UTF-8"; //콘텐츠 인코딩
       
       String subject = "중고장터 아나바다 인증 메일입니다.";		//"이메일 제목";
       String fromEmail = "kohyungsuck@gmail.com";		//"보내는 사람 이메일";
       String fromUsername = "코형석";		//"보내는 사람";
       String toEmail = inputEmail; 	// 콤마(,)로 여러개 나열
       
       final String username = "kohyeongsuck@gmail.com";		//"구글 이메일";         
       final String password = "kohyungsuck1!";		//"발급받은 비밀번호";
       
       int ran = (int)(Math.random() * 999999) + 100000;
       
       // 세션에 인증번호 담기
       HttpSession mailcheck = req.getSession();
       mailcheck.setAttribute("ran", ran);
       mailcheck.setMaxInactiveInterval(600);
       
       // 메일에 출력할 텍스트
       StringBuffer sb = new StringBuffer();
       sb.append("안녕하세요.\n");
       sb.append("아나바다 비밀번호 찾기 인증메일 입니다.\n"); 
       sb.append("하단의 인증번호를 입력해주세요.\n"); 
       sb.append("<h1>" + ran + "</h1>\n"); 
       String html = sb.toString();
       
       // 메일 옵션 설정
       Properties props = new Properties();    
       props.put("mail.transport.protocol", "smtp");
       props.put("mail.smtp.host", "smtp.gmail.com");
       props.put("mail.smtp.port", "587");
       props.put("mail.smtp.auth", "true");
    
       props.put("mail.smtp.quitwait", "false");
       props.put("mail.smtp.socketFactory.port", "587");
       props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
       props.put("mail.smtp.socketFactory.fallback", "true");
       props.put("mail.smtp.starttls.enable","true");
       
       try {
         // 메일 서버  인증 계정 설정
         Authenticator auth = new Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(username, password);
           }
         };
         
         // 메일 세션 생성
         //Session session = Session.getInstance(props, auth);
         Session session = Session.getDefaultInstance(props);
         
         // 메일 송/수신 옵션 설정
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(fromEmail, fromUsername));
         message.setRecipients(RecipientType.TO, InternetAddress.parse(toEmail, false));
         message.setSubject(subject);
         message.setSentDate(new Date());
         
         // 메일 콘텐츠 설정
         Multipart mParts = new MimeMultipart();
         MimeBodyPart mTextPart = new MimeBodyPart();
         MimeBodyPart mFilePart = null;
    
         // 메일 콘텐츠 - 내용
         mTextPart.setText(html, bodyEncoding, "html");
         mParts.addBodyPart(mTextPart);
               
         // 메일 콘텐츠 설정
         message.setContent(mParts);
         
         // MIME 타입 설정
         MailcapCommandMap MailcapCmdMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
         MailcapCmdMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
         MailcapCmdMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
         MailcapCmdMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
         MailcapCmdMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
         MailcapCmdMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
         CommandMap.setDefaultCommandMap(MailcapCmdMap);
    
         // 메일 발송
         Transport t = session.getTransport("smtp");
         t.connect(username, password);   
         t.sendMessage(message, message.getAllRecipients());
         t.close();
         
         //Transport.send( message );
         
         // resp.getWriter().print(true);
         // req.getRequestDispatcher("/WEB-INF/views/member/searchPage.jsp").forward(req, resp);
         // resp.sendRedirect("/sendEmail");
         req.setAttribute("message", "전송 완료. 5분 이내로 인증해주세요.");
         
       } catch ( Exception e ) {
         e.printStackTrace();
       }
   }
}