package ArrTest;

public class ArrTest {
	public static void main(String[] args) {
		
		int[] arr = {1,3,7,5,6,1,2,3,4,8,8,2};
		
		printArr(arr);
		System.out.println("max="+max(arr));
		//sort(arr);
		//printArr(arr);
		distinctArr(arr);
		sort2(arr);
		printArr(arr);
		
	}
	
	

	private static void sort2(int[] arr) {
		int[] counter = new int[arr.length];

		int count =0;
		for(int i = 0; i< arr.length ;i++){
			counter[arr[i]]++;
		}
		for(int i=0;i<counter.length; i++) {
		
			for(int j=0; j<counter[i];j++) {
				arr[count] = i;	
				count++;
			}
		}


	}



	private static void distinctArr(int[] arr) {
		
		int[] counter = new int[arr.length];		
		for(int i = 0; i< arr.length ;i++){
			counter[arr[i]]++;
		}
		for(int i=0;i<counter.length; i++) {
			if(counter[i]>0)
				System.out.print(i +",");

		}	
		System.out.println("");
	
	}



//	private static void sort(int[] arr) {	//int[]참조형 매캐변수라 수정이됨
//		String tmp = "[";
//		boolean changed;
//		for(int i=0; i< arr.length-1;i++) {
//			changed=false;
//			for(int j =0; j< arr.length-1-i;j++) {
//				if(arr[j] > arr[j+1]) {
//					int tmp2 = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = tmp2;
//					changed= true;
//				}
//			}
//			if(!changed) break;
//			
//		}
//
//		
//	}




	private static int max(int[] arr) {
		int max = 0;
		for(int i=0; i< arr.length;i++) {
			if(arr[i] > max)
				max = arr[i];
		}
		
		return max;	
	}




	private static void printArr(int[] arr) {
		String tmp = "[";
		for(int i=0; i< arr.length;i++) {
			tmp += arr[i]+",";
		}
		
		System.out.println(tmp+"]");
		
		
	}
}
