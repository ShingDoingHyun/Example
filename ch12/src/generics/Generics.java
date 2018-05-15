package generics;

class Gene<T>{
	T value;
	
	Gene(T value){
		this.value = value;
	}
	
	public String  toString(){
		return (String)value;
	}
	
}

public class Generics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gene<String> ge1 = new Gene<String>("123");
		System.out.println(ge1);

	}

}
