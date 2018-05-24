package tcpIpClient5;

import java.io.*;
import java.net.*;


public class TcpIpClient5 {
	public static void main(String args[]) {
		try {
			String serverIp = "10.10.10.140";
            
			// ������ �����Ͽ� ������ ��û�Ѵ�.
			Socket socket = new Socket(serverIp, 7777); 

			System.out.println("������ ����Ǿ����ϴ�.");
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);

			sender.start();
			receiver.start();
		} catch(ConnectException ce) {
			ce.printStackTrace();
		} catch(IOException ie) {  
			ie.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();  
		}  
	} // main
} // class