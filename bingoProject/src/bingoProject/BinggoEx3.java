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

      final int SIZE = 5;  // 빙고판의 크기
      int bingoCnt = 0;  // 완성된 라인의 수
      
      Button[] btnArr = null; 
      boolean[][] bArr = new boolean[SIZE][SIZE]; // 빙고판 체크여부 확인을 위한 배열

       // 빙고판 버튼에 사용할 문자열, 빙고판의 크기에 따라 이들의 일부만 사용될 수 있다.
      String[] values = { 
            "글쎄","기로로","김창우","김천대표","까꿍", 
            "남궁성","낭군이","넓게보기","네라주리","다밀", 
            "더클레오","들개","디벨로","레몬","루션", 
            "루이지노","무색이","문학청년","사천사","상상", 
            "세피룸","스쿨쥐","쌩","쏭양","씨드", 
            "양수호","에노야","에비츄","에이스","엔즈", 
            "오이날다","오케클릭","용주니","우기파파","잠탱이", 
            "제러스","조땜","지냔","카라","캉스", 
            "태연","파티쉐","페르소마","폭풍","핏빛노을", 
            "핑크팬더","하늘이","하루","한경훈","헐레벌떡", 
            "화염병","흑빛" 
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
            

            // Frame에 버튼을 추가한다. 
            for(int i=0; i < SIZE*SIZE;i++) { 
            	
                  btnArr[i] = new Button(values[i]);  // 문자열배열 values의 값을 버튼의 Label로 한다.
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

      void print() { // 배열 bArr을 출력한다.
            for(int i=0;i < bArr.length; i++) { 
                  for(int j=0;j < bArr.length; j++) { 
                        System.out.print(bArr[i][j] ? "O" : "X"); 
                  } 
                  System.out.println(); 
            } 
            System.out.println("----------------"); 
//             System.out.println(bingoCnt); 
      } 

      boolean checkBingo() { // 빙고가 완성되었는지를 확인한다. 
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
                //  System.out.println(btn.getLabel()); // 눌러진 버튼의 Label을 콘솔에 출력한다.
               
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
				String msg = in.readLine();// msg: 서버가 보낸 메시지

				
				// msg==> "300|안녕하세요" "160|자바방--1,오라클방--1,JDBC방--1"

				String msgs[] = msg.split("\\|");

				String protocol = msgs[0];

				switch (protocol) {

				case "300":
					String msgs2[] = msg.split("\\▶ ");
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



