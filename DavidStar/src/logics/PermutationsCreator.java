package logics;

import java.util.ArrayList;
import java.util.List;

import equations.Bank;

public class PermutationsCreator
{
	private PermNums permutator = new PermNums();
	public List<Permutation> generate(Func predicate,Bank bank,int permutation_len)
	{
		float arr[] = new float[bank.getValues().size()];
		for(int i=0;i<arr.length;++i)
		{
			arr[i] = bank.getValues().get(i);
		}
		List<List<Float> > perms_list = permutator.calcCombination(predicate,arr, bank.getValues().size(), permutation_len);
		List<Permutation> result = new ArrayList<>();
		perms_list.forEach((per)->{
			result.add(new Permutation(per));
		});
		return result;
	}
}
