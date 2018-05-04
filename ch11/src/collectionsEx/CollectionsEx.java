package collectionsEx;

import java.util.*;
import static java.util.Collections.*;	//클래스명 없이 메서드 접근 가능한 import방식

public class CollectionsEx {

	public static void main(String[] args) {
		List list = new ArrayList();
		System.out.println(list);
		
		addAll(list,1,2,3,4,5);//모든 객체삽입
		System.out.println(list);
		
		rotate(list,2);	//값만큼 이동
		System.out.println(list);
		
		swap(list,0,2);	//값들의 위치 변경
		System.out.println(list);
		
		shuffle(list);	//셔플
		System.out.println(list);
		
		sort(list);	//기본정력
		System.out.println(list);
		
		sort(list, reverseOrder());	//정해진 방식으로 정렬
		System.out.println(list);
		
		int idx = binarySearch(list,3);
		System.out.println("index of 3 = "+ idx);	//해당 인덱스의 값
		
		System.out.println("max="+max(list));
		System.out.println("min="+min(list));
		System.out.println("min="+max(list, reverseOrder()));
		
		fill(list,9);	//값으로 채운다
		System.out.println("list="+list);
		
		List newList = nCopies(list.size(), 2);// 앞요소만큼 뒷요소의 값을 저장
		System.out.println("newList="+newList);
		
		System.out.println(disjoint(list,newList));
		
		copy(list,newList);	//복사
		System.out.println("newList="+newList);	
		System.out.println("list="+list);
		
		replaceAll(list,2,1);
		
		Enumeration e = enumeration(list);
		ArrayList list2 = list(e);
		
		System.out.println("list2="+list);
		
	}

}
