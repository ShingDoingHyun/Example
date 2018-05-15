package fruitBox;

import java.util.ArrayList;

class Fruit{ public String toString() { return "Fruit";}}
class Apple extends Fruit{ public String toString() { return "Apple";}}
class Grape extends Fruit{ public String toString() { return "Grape";}}
class Toy{ public String toString() { return "Toy";}}


public class FruitBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Apple> appleBox = new Box<Apple>();
		Box<Toy> toyBox = new Box<Toy>();
//		Box<Grape> grapeBox = new Box<Apple>(); // 타입 불일치
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());	//Apple이 Fruit을 상속받음
//		fruitBox.add(new Toy());	//Toy는 Fruit을 상속받지않음
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
	}

}


class Box<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item);}	//T객체를 ArrayList배열에 담음
	public String toString() { return list.toString();}
}