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
		//중복제거후 역정렬출력
		list.stream()
			.distinct()//중복제거
			.sorted((i1,i2)-> i2.compareTo(i1))//역정렬
			.map(i->i*10)//10곱
			.map(i->i+",")//,추가
			.forEach(System.out::print);//출력
		
		System.out.println();
		//로또번호 뽑기
		Stream
			.generate(()->(int)(Math.random()*45)+1)//1~45랜덤
			.distinct()//중복제거
			.limit(6)//갯수제한
			.sorted((i1,i2)-> i1.compareTo(i2))//정렬
			.map(i->i+",")//,붙이기
			.forEach(System.out::print);//출력
		
		System.out.println();
		

		String tmp = Stream
			.generate(()->(int)(Math.random()*45)+1)//1~45랜덤
			.distinct()//중복제거
			.limit(6)//갯수제한
			.sorted((i1,i2)-> i1.compareTo(i2))//정렬
			.map(i->i+"")//,붙이기
			.collect(Collectors.joining(","));
		System.out.println(tmp);
	
	System.out.println();
	}
	



}

