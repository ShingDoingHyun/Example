package sss;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
//������ ���� Ŭ���̾�Ʈ�� �޴°�
public class ClientReceiver extends Thread{
	Socket socket;
	DataInputStream in;

	ClientReceiver(Socket socket) {//������ 
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
		}
	}

	@Override
	public void run() {
		while (in != null) {
			try {
				System.out.println(in.readUTF());//�о�� ���� �ֿܼ� ���
			} catch (IOException e) {
			}
		}
	} // run
}
