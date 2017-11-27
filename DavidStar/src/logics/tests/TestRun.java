package logics.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import alg.ALG;
import alg.Decipher;
import equations.Bank;
import equations.Equation;
import equations.IEquation;
import equations.IValidator;
import equations.Validator;
import logics.Combination;
import logics.CombinationsCreator;
import logics.PermutationsCreator;

public class TestRun {
	public static void main(String[] args) {
		Float target = new Float(26);
		int bankSize = 12;
		int a_len = 6;
		List<Float> bank_numbers = new ArrayList<>();
		for(int i=0;i<bankSize;++i)
		{
			bank_numbers.add(new Float(i+1));
		}
		Bank bank = new Bank(bank_numbers);
		
		Equation baseEquation = new Equation(target, "A","B","C","D","E","F");
		IEquation e1 = new Equation(target, "A","b","c","C");
		IEquation e2 = new Equation(target, "A","a","f","E");
		IEquation e3 = new Equation(target, "B","a","b","F");
		IEquation e4 = new Equation(target, "B","c","d","D");
		IEquation e5 = new Equation(target, "C","e","d","E");
		IEquation e6 = new Equation(target, "D","e","f","F");

	    List<String> params_order = new ArrayList<>();
	    params_order.add("A");
	    params_order.add("B");
	    params_order.add("C");
	    params_order.add("D");
	    params_order.add("E");
	    params_order.add("F");
	    params_order.add("a");
	    params_order.add("b");
	    params_order.add("c");
	    params_order.add("d");
	    params_order.add("e");
	    params_order.add("f");
	    IValidator validator = new Validator(params_order,baseEquation,e1,e2,e3,e4,e5,e6);
	    ALG decipher = new Decipher();
	    decipher.init(validator, new CombinationsCreator(), new PermutationsCreator());
	    Combination result = decipher.decipher((permutation)->{
	    	Optional<Float> sum = permutation.stream().reduce((f1,f2)->{
	    		return f1+f2;
	    	});
	    	if(sum.get().floatValue() == target)
	    		{
	    			return true;
	    		}
	    	return false;
	    },bank, a_len);
	    System.out.println(result);
	}
}
