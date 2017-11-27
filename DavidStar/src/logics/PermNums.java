package logics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class PermNums 
{
	private List<List<Float> > permutations;
	private Func currentValidator;
	
public void combinationUtil(float arr[], float data[], int start,
                         int end, int index, int r)
{
 // Current combination is ready to be printed, print it
 if (index == r)
 {
	 List<Float> perm = new ArrayList<>();
     for (int j=0; j<r; j++)
         perm.add(new Float(data[j]));
     if(currentValidator.isValidPermutation(perm))
    	 permutations.add(perm);
     return;
 }
 for (int i=start; i<=end && end-i+1 >= r-index; i++)
 {
     data[index] = arr[i];
     combinationUtil(arr, data, i+1, end, index+1, r);
 }
}

public List<List<Float> > calcCombination(float arr[], int n, int r)
{
	permutations = new LinkedList<>();
	float data[]=new float[r];
 	combinationUtil(arr, data, 0, n-1, 0, r);
 	return permutations;
}
public List<List<Float> > calcCombination(Func validator, float arr[], int n, int r)
{
	currentValidator = validator;
	permutations = new LinkedList<>();
	float data[]=new float[r];
 	combinationUtil(arr, data, 0, n-1, 0, r);
 	return permutations;
}
}
