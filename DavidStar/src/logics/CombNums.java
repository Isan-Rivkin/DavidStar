package logics;

import java.util.ArrayList;
import java.util.List;

public class CombNums 
{
	private List<String> combinations;
	
	public List<String> noOrderPermutation(String str) { 
		combinations = new ArrayList<>();
		notOrderdpermutation("", str); 
		return combinations;
	}

	private void notOrderdpermutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) 
	    {
	    	combinations.add(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++)
	        	notOrderdpermutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	public static void combinations(int n, int[] arr, List<int[]> list) {
	    // Calculate the number of arrays we should create
	    int numArrays = (int)Math.pow(arr.length, n);
	    // Create each array
	    for(int i = 0; i < numArrays; i++) {
	        list.add(new int[n]);
	    }
	    // Fill up the arrays
	    for(int j = 0; j < n; j++) {
	        // This is the period with which this position changes, i.e.
	        // a period of 5 means the value changes every 5th array
	        int period = (int) Math.pow(arr.length, n - j - 1);
	        for(int i = 0; i < numArrays; i++) {
	            int[] current = list.get(i);
	            // Get the correct item and set it
	            int index = i / period % arr.length;
	            current[j] = arr[index];
	        }
	    }
	}
}
