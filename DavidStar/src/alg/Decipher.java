package alg;

import java.util.LinkedList;
import java.util.List;

import equations.Bank;
import equations.IValidator;
import logics.Combination;
import logics.CombinationsCreator;
import logics.Func;
import logics.Permutation;
import logics.PermutationsCreator;

public class Decipher implements ALG
{

	private IValidator validator;
	private CombinationsCreator combinator;
	private PermutationsCreator permutator;
	private Bank initialBank;
	private boolean searchAll = false;
	@Override
	public void init(IValidator validator, CombinationsCreator combinator, PermutationsCreator permutator) 
	{
		this.validator = validator;
		this.combinator = combinator;
		this.permutator = permutator;
	}

	@Override
	public Combination decipher(Func a_predicate,Bank initial_bank,int a_len) 
	{
		List<Combination> result = new LinkedList<>();
		boolean found = false;
		this.initialBank = initial_bank.clone();
		// create Base permutations A 
		List<Permutation> a_permutations = permutator.generate(a_predicate, initialBank.clone(), a_len);
		while(!found)
		{
			for(Permutation a_perm : a_permutations) // traverse through all A permutations
			{
				// create complete permutation b
				Bank b_permutation = a_perm.getCompleteBank(initialBank);
				 // create all A combinations
				List<Combination> a_combinations = combinator.generate(a_perm);
				// create all B combinations
				List<Combination> b_combinations = combinator.generate(b_permutation);
				// evaludate equations
				for(Combination a : a_combinations)
				{
					for(Combination b: b_combinations)
					{
						found = validator.validate(a, b);
						if(found) 
							return a.chainCombination(b);
					}
				}
			}
			// not found combinations at all
			if(!found)
				break;
		}
		return null;
	}
	
}
