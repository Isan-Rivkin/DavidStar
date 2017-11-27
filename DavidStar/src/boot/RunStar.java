package boot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import equations.Bank;
import equations.Equation;
import equations.IEquation;
import logics.CombNums;
import logics.Permutation;
import logics.PermutationsCreator;

public class RunStar {

	public static void main(String[] args) 
	{
		Float target = new Float(26);
		int bankSize = 12;
		Equation baseEquation = new Equation(target, "A","B","C","D","E","F");
		IEquation e1 = new Equation(target, "A","b","c","C");
		IEquation e2 = new Equation(target, "A","a","f","E");
		IEquation e3 = new Equation(target, "B","a","b","F");
		IEquation e4 = new Equation(target, "B","c","d","D");
		IEquation e5 = new Equation(target, "C","e","d","E");
		IEquation e6 = new Equation(target, "D","e","f","F");

		List<Float> list_bank = new ArrayList<>();
		for(int i=0;i<bankSize;++i)
		{
			list_bank.add(new Float(i+1));
		}
		Bank bank = new Bank(list_bank);
		System.out.println(bank);
		
		Bank cloned_bank = bank.clone();
		cloned_bank.removeIf((num)->{
			if(num>5)
				return true;
			return false;
		});
		Bank complete = cloned_bank.getCompleteBank(bank);
		System.out.println(complete);
		System.out.println(bank.sumBank());
		// calculate all permutations 
		System.out.println("the bank: " + bank);
		PermutationsCreator permutator = new PermutationsCreator();
		
		List<Permutation> perms = permutator.generate((per)->{
			Optional<Float> sum = per.stream().reduce((f1,f2)->{
				return f1+f2;
			});
			if(sum.get().floatValue() == new Float(26).floatValue())
				return true;
			return false;
		}, bank.clone(), 6);
		for(Permutation pp : perms)
		{
			System.out.println(pp);
		}
		System.out.println("the bank: " + bank);
		// calculate all combinations 
		CombNums combs = new CombNums();
		combs.noOrderPermutation("123456");
	}
}
