package Exercise6_4;

public class Student {

	public String name;
	public int ban;
	public int no;
	public int kor;
	public int eng;
	public int math;
	
	public int getTotal() {
		// TODO Auto-generated method stub
		return kor+eng+math;
	}
	public float getAverage() {
		// TODO Auto-generated method stub
		return (kor+eng+math)/(float)3;
	}

}
