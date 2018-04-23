package Exercise6_5;

public class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;

	}

	public String info() {
		int total = kor + eng + math;
		String avg = String.format("%.1f", total / (float) 3);

		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + total + "," + avg;
	}

}
