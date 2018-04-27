package Q1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCaseTestTestTest {

	@Test
	public void test1() {
		int[][] arr = {
				{1,1,1,1,1},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}
		};
		
		assertTrue(bingoCheck(arr)==1); 
	}
	
	@Test
	public void test11() {
		int[][] arr = {
				{1,0,0,0,0},
				{1,0,0,0,0},
				{1,0,0,0,0},
				{1,0,0,0,0},
				{1,0,0,0,0}
		};
		
		assertTrue(bingoCheck(arr)==1); 
	}
	
	@Test
	public void test2() {
		int[][] arr = {
				{1,1,1,1,1},
				{1,0,0,0,0},
				{1,0,0,0,0},
				{1,0,0,0,0},
				{1,0,0,0,0}
		};
		
		assertTrue(bingoCheck(arr)==2); 
	}

	@Test
	public void test3() {
		int[][] arr = {
				{1,1,1,1,1},
				{1,1,0,0,0},
				{1,0,1,0,0},
				{1,0,0,1,0},
				{1,0,0,0,1}
		};
		
		assertTrue(bingoCheck(arr)==3); 
	}
	
	@Test
	public void test4() {
		int[][] arr = {
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1}
		};
		
		assertTrue(bingoCheck(arr)==12); 
	}
	
	int bingoCheck(int[][] arr) {
		int bingoCnt=0;
		
		int cross1=0;
		int cross2=0;

		
		for(int i=0; i<5;i++) {	
			int garoCnt=0;
			int seroCnt=0;

			for(int j =0; j<5;j++) {
				if(arr[i][j]==1) garoCnt++;
				if(arr[j][i]==1) seroCnt++;
				if(i==j && arr[i][j]==1)cross1++;
				if(i+j==4 && arr[i][j]==1)cross2++;
				
			}
			if(garoCnt==5)bingoCnt++;	
			if(seroCnt==5)bingoCnt++;	
			
		}
		if(cross1==5)bingoCnt++;	
		if(cross2==5)bingoCnt++;	
		
	
		return bingoCnt;
	}
}
