package ReferenceReturnEx;

public class ReferenceReturnEx {

	public static void main(String[] args) {
		Data d = new Data();
		d.x =10;
		
		Data d2 = copy(d);
		System.out.println("d.x="+d.x);
		System.out.println("d2.x="+d2.x);
		
		
		
		String test="?";
		
		System.out.println("test="+test);
		copy1(test);
		System.out.println("test="+test);

	}

	private static Data copy(Data d) {
		Data tmp = new Data();
		tmp.x = d.x;
		return tmp;
	}
	private static void copy1(String test) {	//얘도 참조형인데 안되네
		test="???";

	}
	

}
class Data{
	int x;
}