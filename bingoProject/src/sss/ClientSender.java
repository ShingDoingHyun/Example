package sss;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.Scanner;
//Ŭ���̾�Ʈ���� ������ �����°�
public class ClientSender extends Thread {
	Socket socket;
	DataOutputStream out;
	
	byte[] msg = new byte[512];
	
	DatagramPacket outPacket = null;
	DatagramSocket inPacket = null;
	String name;	//������ ����

	Scanner scanner = new Scanner(System.in);
	
	ClientSender(Socket socket) {
		this.socket = socket;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			outPacket = new DatagramPacket(msg, 1, msg.length, socket.getInetAddress(), socket.getPort());
			inPacket = new DatagramSocket(socket.getLocalSocketAddress());
//			this.name = name;
		} catch (Exception e) {
		}
	}

	@Override
	public void run() {
	
		try {
			if (out != null) {
				
				out.writeUTF("�̸�!");
			}

			while (out != null) {
				out.writeUTF("[" + Thread.currentThread().getName() + "]" + scanner.nextLine());
			}
		} catch (IOException e) {
		}
	} // run() {
}
