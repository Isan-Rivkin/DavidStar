package equations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import logics.Combination;

public class Validator implements IValidator
{
	private List<IEquation> equations;
	private List<String> params_order;
	private HashMap<String,Float> map_value;
	private boolean allTargets;
	
	public Validator(List<String> params_order,IEquation... equations)
	{
		this.equations = Arrays.asList(equations);
		this.params_order = params_order;
	}
	@Override
	public boolean validate(Combination a, Combination b) 
	{
		mapVals(a,b);
		map_value.forEach((param,value)->{
			equations.forEach((equation)->{
				equation.setValue(param, value);
			});
		});
		allTargets = true;
		equations.forEach((eq)->{
			if(!eq.isTargetReached())
				{
					allTargets=false;
				}
		});
//		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//		System.out.println("good? " + allTargets);
//		printEquations();
//		System.out.println("-----------------------------");
		return allTargets;
	}

	private void mapVals(Combination a, Combination b) 
	{
		this.map_value = new HashMap<>();
		List<Float> all = new ArrayList<>();
		all.addAll(a.getValues());
		all.addAll(b.getValues());
		for(int i=0;i<all.size();++i)
		{	
			map_value.put(params_order.get(i),all.get(i));
		}
	}
	@Override
	public void setEquations(Equation... equations) 
	{
		this.equations = Arrays.asList(equations);
	}
	public void printEquations()
	{
		equations.forEach((eq)->{
			System.out.println("sum= "+eq.sum() + " -> " + eq.printParamsOnly());
			//System.out.println("sum= "+eq.sum() + " -> " + eq);
		});
	}
	@Override
	public List<IEquation> printAll() {
		System.out.println("raw equations:");
		equations.forEach((e)->{
			System.out.println(e.printParamsOnly());
		});
		System.out.println("filled equations:");
		equations.forEach((e)->{
			System.out.println(e);
		});
		return equations;
	}
}
