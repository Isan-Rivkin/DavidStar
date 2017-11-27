package equations;

import java.util.List;

import logics.Combination;

public interface IValidator 
{
	public boolean validate(Combination a , Combination b);
	public void setEquations(Equation ...equations);
}
