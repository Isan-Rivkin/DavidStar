package equations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Equation implements IEquation 
{
	private HashMap<String, Float> equation;
	private Float target;
	
	public Equation(Float target,String ...params) 
	{
		equation = new HashMap<>();
		List<String> p = Arrays.asList(params);
		p.forEach((par)->{
			equation.put(par, null);
		});
		this.target = target;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String,Float> entry: equation.entrySet())
		{
			if(entry.getValue() != null)
			{
				sb.append(entry.getValue()+"");
			}
			else
			{
				sb.append(entry.getKey());
			}
			sb.append(" + ");
		}
		int idx = sb.lastIndexOf(" + ");
		sb.replace(idx, idx+3, " = ");
		sb.append(target+"");
		return sb.toString();
	}
	@Override
	public String printParamsOnly() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String,Float> entry: equation.entrySet())
		{
			sb.append(entry.getKey());
			sb.append(" + ");
		}
		int idx = sb.lastIndexOf(" + ");
		sb.replace(idx, idx+3, " = ");
		sb.append(target+"");
		return sb.toString();
	}
	@Override
	public void setValue(String param, Float value) 
	{
		if(equation.containsKey(param))
		{
			equation.put(param,value);
		}
	}

	@Override
	public Float getValue(String param)
	{
		if(equation.containsKey(param))
		{
			return equation.get(param);
		}
		return null;
	}

	@Override
	public void setAll(List<String> params, List<Float> values)
	{
		if(params.size() != values.size())
			throw new Error("Cannot set Equation params.size() != values.size()");
		int index = 0;
		for(String p : params)
		{
			equation.put(p,values.get(index));
			index++;
		}
	}

	@Override
	public Float getTarget()
	{
		return target;
	}

	@Override
	public void setTarget(Float target)
	{
		this.target=target;
	}

	@Override
	public boolean isTargetReached() 
	{
		if(isCalculatable())
		{
			if(sum().floatValue() == target.floatValue())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}

	@Override
	public Float sum() 
	{	
		float final_sum = 0;
		for(Map.Entry<String ,Float> entry : equation.entrySet())
		{
			if(entry.getValue() != null)
				final_sum += entry.getValue();
		}
		return new Float(final_sum);
	}
	@Override
	public boolean isCalculatable() 
	{
		for(Map.Entry<String ,Float> entry : equation.entrySet())
		{
			if(entry.getValue() == null)
				return false;
		}
		return true;
	}

}
