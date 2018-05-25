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
    
    public void start() {	//���۽� ȣ�ٵ�
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("������ ���۵Ǿ����ϴ�.");
            while (true) {	//�ݺ��ϸ� ������ �����ߴ��� üũ.
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + ":"
                        + socket.getPort() + "]" + "���� �����Ͽ����ϴ�.");
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();	//�������ù�����
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
                sendToAll("#" + name + "���� �����̽��ϴ�.");
                clients.put(name, out);
                System.out.println("���� ���������� ���� " 
                        + clients.size() + "�Դϴ�.");

                while (in != null) {
                	System.out.println(in.readUTF());
                    sendToAll(in.readUTF());
                }
            } 
            catch (IOException e) {
            	  System.out.println("�Լ��ǿ���");
            } finally {
                sendToAll("#" + name + "���� �����̽��ϴ�.");
                clients.remove(name);
                System.out.println("[" + socket.getInetAddress() + ":"
                        + socket.getPort() + "]" 
                        + "���� ������ �����Ͽ����ϴ�.");
                System.out.println("���� ���������� ���� " 
                        + clients.size() + "�Դϴ�.");
            } // try
        } // run
    } // ReceiverThread

}