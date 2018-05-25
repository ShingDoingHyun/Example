package sss;

import java.net.ConnectException;
import java.net.Socket;
//클라이언트 사이드
public class ClientA {
	public static void main(String args[]) {
		try {
			String serverIp = "10.10.10.141"; // 소켓을 생성하여 연결을 요청한다.
			Socket socket = new Socket(serverIp, 7777);	//~아이피의 포트로 소켓만듬
			System.out.println("서버에 연결되었습니다.");
			Thread sender = new Thread(new ClientSender(socket));	
			Thread receiver = new Thread(new ClientReceiver(socket));
			sender.start();	//센더 리시버 스래스 실행
			receiver.start();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (Exception e) {
		}
	} // main
}
