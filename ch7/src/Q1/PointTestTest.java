package Q1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTestTest {

	@Test
	public void test1() {
		assertTrue(mid(1, 2, 3) == 2);
	}

	@Test
	public void test2() {
		assertTrue(mid(1, 1, 1) == 1);
	}

	@Test
	public void test3() {
		assertTrue(mid(1, 2, 2) == 2);
	}

	@Test
	public void test4() {
		assertTrue(mid(2, 2, 3) == 2);
	}

	@Test
	public void test5() {
		assertTrue(mid(3, 3, 3) == 3);
	}

	@Test
	public void test6() {
		assertTrue(mid(22, 17, 0) == 17);
	}

	@Test
	public void test7() {
		assertTrue(mid(-1, 0, 1) == 0);
	}

	@Test
	public void test8() {
		assertTrue(mid(-1, -99, -21) == -21);
	}

	private int mid(int i, int j, int k) {
		
		if ((i >= j && i <= k) || (i <= j && i >= k))
			return  i;
		else if ((j <= k && j >= i) || (j >= k && j <= i))
			return  j;
		else
			return  k;
		
	}
}
