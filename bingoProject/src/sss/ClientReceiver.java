package sss;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
//서버를 통해 클라이언트가 받는것
public class ClientReceiver extends Thread{
	Socket socket;
	DataInputStream in;

	ClientReceiver(Socket socket) {//생성자 
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
				System.out.println(in.readUTF());//읽어온 값을 콘솔에 출력
			} catch (IOException e) {
			}
		}
	} // run
}
