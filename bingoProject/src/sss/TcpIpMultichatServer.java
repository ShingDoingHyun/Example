package sss;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpMultichatServer {
    HashMap clients;
    
    TcpIpMultichatServer() {
        clients = new HashMap();
        Collections.synchronizedMap(clients);
    }
    
    public void start() {	//시작시 호줄됨
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 시작되었습니다.");
            while (true) {	//반복하며 누군가 접속했는지 체크.
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + ":"
                        + socket.getPort() + "]" + "에서 접속하였습니다.");
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();	//서버리시버시작
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // start()
    
    void sendToAll(String msg) {

        Iterator it = clients.keySet().iterator();
        while (it.hasNext()) {
            try {
                DataOutputStream out = (DataOutputStream) clients
                        .get(it.next());
                out.writeUTF(msg);
            } catch (IOException e) {
            }
        } // while
    } // sendToAll
    
    public static void main(String args[]) {
        new TcpIpMultichatServer().start();
    }
    
    class ServerReceiver extends Thread {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;
        ServerReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
            	
            }
        }
        public void run() {
            String name = "";
            try {
                name = in.readUTF();
                sendToAll("#" + name + "님이 들어오셨습니다.");
                clients.put(name, out);
                System.out.println("현재 서버접속자 수는 " 
                        + clients.size() + "입니다.");

                while (in != null) {
                	System.out.println(in.readUTF());
                    sendToAll(in.readUTF());
                }
            } 
            catch (IOException e) {
            	  System.out.println("입셉션에러");
            } finally {
                sendToAll("#" + name + "님이 나가셨습니다.");
                clients.remove(name);
                System.out.println("[" + socket.getInetAddress() + ":"
                        + socket.getPort() + "]" 
                        + "에서 접속을 종료하였습니다.");
                System.out.println("현재 서버접속자 수는 " 
                        + clients.size() + "입니다.");
            } // try
        } // run
    } // ReceiverThread

}