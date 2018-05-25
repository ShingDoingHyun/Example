package bingoProject;

import java.awt.*; 
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import ch16_12.BingoEx3; 

class BingoEx3 extends Frame implements Runnable{ 

      final int SIZE = 5;  // �������� ũ��
      int bingoCnt = 0;  // �ϼ��� ������ ��
      
      Button[] btnArr = null; 
      boolean[][] bArr = new boolean[SIZE][SIZE]; // ������ üũ���� Ȯ���� ���� �迭

       // ������ ��ư�� ����� ���ڿ�, �������� ũ�⿡ ���� �̵��� �Ϻθ� ���� �� �ִ�.
      String[] values = { 
            "�۽�","��η�","��â��","��õ��ǥ","���", 
            "���ü�","������","�аԺ���","�׶��ָ�","�ٹ�", 
            "��Ŭ����","�鰳","�𺧷�","����","���", 
            "��������","������","����û��","��õ��","���", 
            "���Ƿ�","������","��","����","����", 
            "���ȣ","�����","������","���̽�","����", 
            "���̳���","����Ŭ��","���ִ�","�������","������", 
            "������","����","����","ī��","Ĳ��", 
            "�¿�","��Ƽ��","�丣�Ҹ�","��ǳ","�ͺ�����", 
            "��ũ�Ҵ�","�ϴ���","�Ϸ�","�Ѱ���","�淹����", 
            "ȭ����","���" 
      }; 
      
	  BufferedReader in;
	
	  OutputStream out;

      BingoEx3(Socket socket) { 
            this("Bingo Game Ver1.0", socket); 
      } 

      BingoEx3(String title, Socket socket) { 
    	  
            super(title); 

            setLayout(new GridLayout(SIZE, SIZE)); 

            MyEventHandler handler = new MyEventHandler(); 
            addWindowListener(handler); 

            btnArr = new Button[SIZE*SIZE]; 

            shuffle(); 
            

            // Frame�� ��ư�� �߰��Ѵ�. 
            for(int i=0; i < SIZE*SIZE;i++) { 
            	
                  btnArr[i] = new Button(values[i]);  // ���ڿ��迭 values�� ���� ��ư�� Label�� �Ѵ�.
                  add(btnArr[i]); 
                  btnArr[i].addActionListener(handler); 
            } 

            setBounds(500, 200, 300, 300); 
            setVisible(true); 
            
            try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
			
            new Thread(this).start();
            }catch (Exception e) {
			}
        
      } 

      void shuffle() { 
            for(int i=0;i < values.length * 2;i++) { 
                  int r1 = (int)(Math.random()* values.length); 
                  int r2 = (int)(Math.random()* values.length); 

                  String tmp = values[r1]; 
                  values[r1] = values[r2]; 
                  values[r2] = tmp; 
            } 
      } 
      
      @SuppressWarnings("deprecation")
	public static void main(String args[]) { 
            BingoEx3 win = new BingoEx3("Bingo Game Ver1.0"); 
            win.show(); 
      } 

      void print() { // �迭 bArr�� ����Ѵ�.
            for(int i=0;i < bArr.length; i++) { 
                  for(int j=0;j < bArr.length; j++) { 
                        System.out.print(bArr[i][j] ? "O" : "X"); 
                  } 
                  System.out.println(); 
            } 
            System.out.println("----------------"); 
//             System.out.println(bingoCnt); 
      } 

      boolean checkBingo() { // ���� �ϼ��Ǿ������� Ȯ���Ѵ�. 
            bingoCnt = 0; 
            int garoCnt = 0; 
            int seroCnt = 0; 
            int crossCnt1 = 0; 
            int crossCnt2 = 0; 

            for(int i=0; i < SIZE; i++) { 
                  for(int j=0; j < SIZE; j++) { 
                        if(i+j==SIZE-1 && bArr[i][j]) 
                              crossCnt2++; 
                        if(i==j && bArr[i][j]) 
                              crossCnt1++; 
                        if(bArr[i][j]) 
                              garoCnt++;                         
                        if(bArr[j][i]) 
                              seroCnt++;       
                  } 

                  if(garoCnt==SIZE) bingoCnt++; 
                  if(seroCnt==SIZE) bingoCnt++; 

//                   if(bingoCnt>=SIZE) return true; 
                  garoCnt = 0; 
                  seroCnt = 0; 
            } 
            
            if(crossCnt1==SIZE) bingoCnt++; 
            if(crossCnt2==SIZE) bingoCnt++; 

         //  System.out.println(bingoCnt); 
            return bingoCnt >= SIZE; 
      } 

      class MyEventHandler extends WindowAdapter implements ActionListener { 
            public void actionPerformed(ActionEvent ae) { 
                  Button btn = (Button)ae.getSource();      
                //  System.out.println(btn.getLabel()); // ������ ��ư�� Label�� �ֿܼ� ����Ѵ�.
               
                  try {
                	  out.write(("300|"+btn.getLabel()+ "\n").getBytes());
                  } catch (IOException e) {
                	  e.printStackTrace();
                  }
                  
                  
                  for(int i=0; i < btnArr.length; i++) { 
                        if(btnArr[i]==btn) { 
                              bArr[i/SIZE][i%SIZE] = true; 
                              break; 
                        } 
                  } 

   
                  
                  
                  btn.setBackground(Color.RED); 
                  //print(); 
                  if(checkBingo()) { 
                        System.out.println("Bingo~!!!"); 
                  } 
            } 

            public void windowClosing(WindowEvent e) { 
                  e.getWindow().setVisible(false); 
                  e.getWindow().dispose(); 
                  System.exit(0); 
            }
            
            
            void bingoCheck(String bing) {
            	int getVal=0;
                for(int i=0; i < btnArr.length; i++) { 
                    if(btnArr[i].getLabel().equals(bing)) { 
                    	getVal = i;
                          bArr[i/SIZE][i%SIZE] = true; 
                          break; 
                    } 
                } 


		         System.out.println(btnArr[getVal].getLabel());
		         btnArr[getVal].setBackground(Color.RED); 
		         //print(); 
	             if(checkBingo()) { 
	                 System.out.println("Bingo~!!!"); 
	             } 
            }
      } 
      
      public void run() {
    	
  		try {

			while (true) {
				String msg = in.readLine();// msg: ������ ���� �޽���

				
				// msg==> "300|�ȳ��ϼ���" "160|�ڹٹ�--1,����Ŭ��--1,JDBC��--1"

				String msgs[] = msg.split("\\|");

				String protocol = msgs[0];

				switch (protocol) {

				case "300":
					String msgs2[] = msg.split("\\�� ");
					System.out.println(msgs2[1]);
					break;
				default :
					break;
					
					
				}
			}
  		}catch (Exception e) {
  			System.out.println(e.getMessage());
		}
      }
}



