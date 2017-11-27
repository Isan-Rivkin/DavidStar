package equations;

import java.util.List;

public interface IEquation 
{
	public void setValue(String param,Float value);
	public Float getValue(String param);
	public void setAll(List<String> params,List<Float> values);
	public Float getTarget();
	public void setTarget(Float target);
	public boolean isTargetReached();
	public Float sum();
	public boolean isCalculatable();
	public String printParamsOnly();
	
}
