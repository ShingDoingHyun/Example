package collectionsEx;

import java.util.*;
import static java.util.Collections.*;	//Ŭ������ ���� �޼��� ���� ������ import���

public class CollectionsEx {

	public static void main(String[] args) {
		List list = new ArrayList();
		System.out.println(list);
		
		addAll(list,1,2,3,4,5);//��� ��ü����
		System.out.println(list);
		
		rotate(list,2);	//����ŭ �̵�
		System.out.println(list);
		
		swap(list,0,2);	//������ ��ġ ����
		System.out.println(list);
		
		shuffle(list);	//����
		System.out.println(list);
		
		sort(list);	//�⺻����
		System.out.println(list);
		
		sort(list, reverseOrder());	//������ ������� ����
		System.out.println(list);
		
		int idx = binarySearch(list,3);
		System.out.println("index of 3 = "+ idx);	//�ش� �ε����� ��
		
		System.out.println("max="+max(list));
		System.out.println("min="+min(list));
		System.out.println("min="+max(list, reverseOrder()));
		
		fill(list,9);	//������ ä���
		System.out.println("list="+list);
		
		List newList = nCopies(list.size(), 2);// �տ�Ҹ�ŭ �޿���� ���� ����
		System.out.println("newList="+newList);
		
		System.out.println(disjoint(list,newList));
		
		copy(list,newList);	//����
		System.out.println("newList="+newList);	
		System.out.println("list="+list);
		
		replaceAll(list,2,1);
		
		Enumeration e = enumeration(list);
		ArrayList list2 = list(e);
		
		System.out.println("list2="+list);
		
	}

}