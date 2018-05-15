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
//		Box<Grape> grapeBox = new Box<Apple>(); // Ÿ�� ����ġ
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());	//Apple�� Fruit�� ��ӹ���
//		fruitBox.add(new Toy());	//Toy�� Fruit�� ��ӹ�������
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
	}

}


class Box<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item);}	//T��ü�� ArrayList�迭�� ����
	public String toString() { return list.toString();}
}