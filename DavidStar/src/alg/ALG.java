package alg;

import java.util.List;

import equations.Bank;
import equations.IValidator;
import logics.Combination;
import logics.CombinationsCreator;
import logics.Func;
import logics.PermutationsCreator;

public interface ALG 
{
	public void init(IValidator validator, CombinationsCreator combinator, PermutationsCreator permutator);
	public Combination decipher(Func a_predicate,Bank initial_bank,int a_len);
}
