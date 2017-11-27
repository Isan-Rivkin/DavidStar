package equations;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Bank 
{
	protected List<Float> bank;
	
	public Bank(Float... bank_nums) 
	{
		bank = new LinkedList<>();
		List<Float> ll = Arrays.asList(bank_nums);
		ll.forEach(n->{
			bank.add(n);
		});
	}
	public Bank(List<Float> bank_nums) 
	{
		bank = new LinkedList<>();
		bank_nums.forEach(n->{
			bank.add(new Float(n));
		});
	}
	public Bank remove(Float val)
	{
		if(bank.contains(val))
		{
			bank.remove(val);
		}
		return this;
	}
	public void removeAll(List<Float> other_bank)
	{
		bank.removeAll(other_bank);
	}
	public Bank removeAll(Bank other_bank)
	{
		bank.removeAll(other_bank.getValues());
		return this;
	}
	public List<Float> getValues()
	{
		return bank;
	}
	public void removeIf(Predicate<Float> predicate) 
	{
		bank.removeIf(predicate);
	}
	public Bank clone()
	{
		Bank b = new Bank(bank);
		return b;
	}
	@Override
	public String toString() {
		return bank.toString();
	}
	public Bank getCompleteBank(Bank mainBank)
	{
		Bank complete = mainBank.clone();
		complete.removeAll(this);
		return complete;
	}
	public Float sumBank()
	{
		Optional<Float> sum = bank.stream().reduce((n1,n2)->{
			return n1+n2;
		});
		return sum.get();
	}
	@Override
	public boolean equals(Object obj) {
		Bank other = (Bank)obj;
		if(other.getValues().size() != bank.size())
			return false;
		for(int i=0; i<bank.size();++i)
		{
			if(!bank.contains(other.getValues().get(i)) || !bank.contains(bank.get(i)))
			{
				return false;
			}
		}
		return true;
	}
}
