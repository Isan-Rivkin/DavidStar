package logics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import equations.Bank;

public class CombinationsCreator 	
{
	private CombNums combinator = new CombNums();
	private HashMap<String,Float> ids_map;
	
	public List<Combination> generate(Bank bank)
	{
		int size = bank.getValues().size();
		mapValues(bank);
		String str_comb = idsToString();
		List<String> str_combinations = combinator.noOrderPermutation(str_comb);
		return decodeCombinations(str_combinations);
	}
	private List<Combination> decodeCombinations(List<String> str_combinations) 
	{
		List<Combination> result = new ArrayList<>();
		for(String combo: str_combinations)
		{
			result.add(new Combination(decodeCombination(combo)));
		}
		return result;
	}
	private List<Float> decodeCombination(String combo) 
	{
		List<Float> result = new LinkedList<>();
		char ids[] = combo.toCharArray();
		for(int i=0;i<ids.length;++i)
		{
			result.add(ids_map.get(ids[i]+""));
		}
		return result;
	}
	private void mapValues(Bank bank) 
	{
		ids_map = new HashMap<>();
		List<Float> values = bank.getValues();
		int size = values.size();
		for(int i=0;i<size;++i)
		{
			ids_map.put(""+i,values.get(i));
		}
	}
	private String idsToString()
	{
		StringBuilder sb = new StringBuilder();
		for(String s :ids_map.keySet()) 
		{
			sb.append(s);
		}
		return sb.toString();
	}
}
