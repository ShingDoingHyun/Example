package sss;

import java.net.ConnectException;
import java.net.Socket;
//Ŭ���̾�Ʈ ���̵�
public class ClientA {
	public static void main(String args[]) {
		try {
			String serverIp = "10.10.10.141"; // ������ �����Ͽ� ������ ��û�Ѵ�.
			Socket socket = new Socket(serverIp, 7777);	//~�������� ��Ʈ�� ���ϸ���
			System.out.println("������ ����Ǿ����ϴ�.");
			Thread sender = new Thread(new ClientSender(socket));	
			Thread receiver = new Thread(new ClientReceiver(socket));
			sender.start();	//���� ���ù� ������ ����
			receiver.start();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (Exception e) {
		}
	} // main
}
