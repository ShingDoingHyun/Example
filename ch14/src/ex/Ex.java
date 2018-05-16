package ex;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,5,5,9,3,4,5,4,4,1,1,8,6,7,8,9,10);
		
		list.forEach(i->System.out.print(i));
		System.out.println();
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		
		System.out.println();
		//�ߺ������� ���������
		list.stream()
			.distinct()//�ߺ�����
			.sorted((i1,i2)-> i2.compareTo(i1))//������
			.map(i->i*10)//10��
			.map(i->i+",")//,�߰�
			.forEach(System.out::print);//���
		
		System.out.println();
		//�ζǹ�ȣ �̱�
		Stream
			.generate(()->(int)(Math.random()*45)+1)//1~45����
			.distinct()//�ߺ�����
			.limit(6)//��������
			.sorted((i1,i2)-> i1.compareTo(i2))//����
			.map(i->i+",")//,���̱�
			.forEach(System.out::print);//���
		
		System.out.println();
		

		String tmp = Stream
			.generate(()->(int)(Math.random()*45)+1)//1~45����
			.distinct()//�ߺ�����
			.limit(6)//��������
			.sorted((i1,i2)-> i1.compareTo(i2))//����
			.map(i->i+"")//,���̱�
			.collect(Collectors.joining(","));
		System.out.println(tmp);
	
	System.out.println();
	}
	



}

