package inheritance;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindNthSmallest {
	
	public static void main(String[] args) {
		
		int n = 0;
		
		Integer[] numbers={3,1,5,8,92,2};
		
		List<Integer> list = Arrays.asList(numbers);
		
		Collections.sort(list);
		
		System.out.println("Nth Smallest is "+list.get(n-1));
	}

	
	

}
