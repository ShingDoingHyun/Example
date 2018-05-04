package treeMapEx1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



public class TreeMapEx1 {

	public static void main(String[] args) {
		String[] data = {"A","K","A","K","D","K","A","K","K","K","Z","D"};//배열로 문자열을 저장
		TreeMap map = new TreeMap();	//트리맵 생성
		
		for(int i=0; i< data.length; i++) {	//배열크기만큼 반복
			if(map.containsKey(data[i])) {	//트리맵에 지정된 key(data(i))가 있는지 체크
				Integer value = (Integer)map.get(data[i]);	//key의 값을 정수형 객체로 반환
				map.put(data[i], new Integer(value.intValue()+1));	//키값에 현재 값에 1을 더해 정수형 객체로 저장
			}else {
				map.put(data[i], new Integer(1));	//만약 같은 키가 없으면 키값에 1을 저장
			}
		}

		
		Iterator it = map.entrySet().iterator();	//map은 key와 value로 값을 저장하고 있기 때문에 entrySet keySet등 set을 통해서 값을 얻을 수 있다.
		
		System.out.println("= 기본정렬 =");
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();	//Emtry혈태 (key,value)로 얻기 위해 이렇게 받음 다형성, 형변환
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
		System.out.println();
		
		Set set = map.entrySet();
		List list = new ArrayList<>(set);
		
		Collections.sort(list, new ValueComparator());// 정렬을  만들기
		
		it = list.iterator();
		
		System.out.println("= 값의 크기가 큰 순서로 정렬 =");
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
			
		}
		
		
	}

	private static String printBar(char ch, int value) {
		char[] bar = new char[value];
		
		for(int i=0; i< bar.length;i++) {
			bar[i]=ch;		
			}
		return new String(bar);
	}

	static class ValueComparator implements Comparator{	//사용자 정의 정렬을 위해 상속!

		@Override
		public int compare(Object o1, Object o2) {
			if(o1 instanceof Map.Entry && o2 instanceof Map.Entry ) {	//유효성체크
				Map.Entry e1 = (Map.Entry)o1;
				Map.Entry e2 = (Map.Entry)o2;
				
				int v1 = ((Integer)e1.getValue()).intValue();
				int v2 = ((Integer)e2.getValue()).intValue();
				
				return v2 - v1;	//둘중 v2가 크면 양수 적으면 음수
			}
			return -1;
		}
		
	}
}
