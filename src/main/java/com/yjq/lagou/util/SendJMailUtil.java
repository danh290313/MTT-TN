package com.yjq.lagou.util;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;


public class SendJMailUtil {
	
		@Value("${yjq.sender.email.username}")
		private static String username;
		
		@Value("${yjq.sender.email.password}")
		private static String password;
	
	
		public static boolean sendMail(String email, String emailMsg,String title) {
		
		String from = "danhtestotp@gmail.com"; 				// Địa chỉ email của người gửi email
		String to = email; 										// Địa chỉ thư của người nhận thư
	//	final String username = "15989566325@163.com";  	//Tài khoản email của nhà phát hành
	//	final String password = "gyfitedu";   					//Mật khẩu email của người gửi


		//Xác định đối tượng thuộc tính và đặt thông tin môi trường
		Properties props = System.getProperties();

		//Đặt địa chỉ của máy chủ thư
		props.setProperty("mail.smtp.host", "smtp.163.com"); // Chỉ định máy chủ SMTP
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");//Đặt giao thức để gửi email
		//Tạo đối tượng phiên, đối tượng phiên biểu thị thông tin môi trường của toàn bộ thư
		Session session = Session.getInstance(props);
		//Đặt thông tin gỡ lỗi đầu ra
		session.setDebug(true);
		try {
			//MessageCác đối tượng ví dụ cho biết một email điện tử
			MimeMessage message = new MimeMessage(session);
			//Đặt địa chỉ của người gửi
			message.setFrom(new InternetAddress(from));
			//Đặt chủ đề
			message.setSubject(title);
			//Đặt nội dung văn bản của thư
			//message.setText("Welcome to JavaMail World!");
			message.setContent((emailMsg),"text/html;charset=utf-8");
			
			//Đặt phụ lục
			//message.setDataHandler(dh);
			
			//Nhận đối tượng gửi email từ môi trường phiên
			Transport transport=session.getTransport();
			//Kết nối máy chủ email
			transport.connect("smtp.163.com",25, username, password);
			//Đặt địa chỉ người nhận và gửi tin nhắn
			transport.sendMessage(message,new Address[]{new InternetAddress(to)});
			transport.close();
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
}
