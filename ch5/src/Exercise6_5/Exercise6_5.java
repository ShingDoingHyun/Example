package Exercise6_5;

public class Exercise6_5 {
	public static void main(String args[]) {
		Student s = new Student("ȫ�浿", 1, 1, 100, 60, 76);
		System.out.println(s.info());
	}
}

class Student{
	String name;
	int i;
	int j;
	int num1;
	int num2;
	int num3;
	int total;
	float avg;
	Student(String name, int i, int j, int num1, int num2, int num3){
		this.name = name;
		this.i = i;
		this.j = j;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 =num3;
		total = num1+num2+num3;
		avg = (num1+num2+num3)/(float)3;
	}
	public String info() {

		return name+","+i+","+j+","+num1+","+num2+","+num3+","+total+","+String.format("%.1f", avg);
	}
	
}