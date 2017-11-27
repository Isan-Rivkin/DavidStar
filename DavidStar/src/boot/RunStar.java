package boot;

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
import logics.CombNums;
import logics.Combination;
import logics.CombinationsCreator;
import logics.Permutation;
import logics.PermutationsCreator;

public class RunStar 
{
	public static void main(String[] args) 
	{
		List<Float> bank_numbers = new ArrayList<>();
	    List<String> params_order = new ArrayList<>();
		Float target = new Float(26);
		int bankSize = 12;
		int a_len = 6;
		// initialize a bank of numbers
		for(int i=0;i<bankSize;++i)
		{
			bank_numbers.add(new Float(i+1));
		}
		Bank bank = new Bank(bank_numbers);
		// set the equations
		IEquation e0 = new Equation(target, "A","B","C","D","E","F");
		IEquation e1 = new Equation(target, "A","b","c","C");
		IEquation e2 = new Equation(target, "A","a","f","E");
		IEquation e3 = new Equation(target, "B","a","b","F");
		IEquation e4 = new Equation(target, "B","c","d","D");
		IEquation e5 = new Equation(target, "C","e","d","E");
		IEquation e6 = new Equation(target, "D","e","f","F");
		// define an order for the combinations to be submitted -> used inside the Validator
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
	    // the equations validator
	    IValidator validator = new Validator(params_order,e0,e1,e2,e3,e4,e5,e6);
	    /**
	     * The algorithm 
	     */
	    ALG decipher = new Decipher();
	    /**
	     * validator - validates a set of equations and targets
	     * CombinationsCreator - creates all possible combinations from a given set
	     * PermutationsCreator - creates unique-no order permutaion from a given set 
	     */
	    decipher.init(validator, new CombinationsCreator(), new PermutationsCreator());
	    // inserting heuristic callback to define stage A
	    Combination result = decipher.decipher((permutation)->{
	    	Optional<Float> sum = permutation.stream().reduce((f1,f2)->{
	    		return f1+f2;
	    	});
	    	if(sum.get().floatValue() == target)
	    			return true;
	    	return false;
	    },bank, a_len);
	    /**
	     * print the result
	     * params_order[index] = result[index]
	     */
	    System.out.println("Equations Result:");
	    validator.printAll();
	    System.out.println("The combination:");
	    System.out.println(params_order.toString());
	    System.out.println(result);
	}
}
