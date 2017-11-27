package logics;

import java.util.List;

import equations.Bank;

public class Combination extends Bank
{
	public Combination(Float... nums) 
	{
	super(nums);
	}
	public Combination(List<Float> nums) 
	{
		super(nums);
	}
	
	@Override
	public boolean equals(Object obj) {
		Combination other = (Combination)obj;
		if(other.getValues().size() != bank.size())
		{
			return false;
		}
		for(int i=0;i<bank.size();++i)
		{
			if(other.getValues().get(i).floatValue() != bank.get(i).floatValue() )
				return false;
		}
		return true;
	}
	public Combination chainCombination(Combination c)
	{
		for(Float v : c.getValues())
			bank.add(v);
		return this;
	}
}
