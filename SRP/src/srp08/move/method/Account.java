/*
 * SMELL: Feature Envy
 *   -- A method is used more in another class than in its own class.
 * 
 * TREATMENT: Move Method
 *   -- Create a new method in the class that uses the method the most,   
 *      then move code from the old method to there. 
 *   -- Turn the code of the original method into a reference to the 
 *   	new method in the other class or else remove it entirely.
  */
package srp08.move.method;

public class Account
{
	// ...
	/* Say, there will be several new account types, and each account type 
	 * will have different rules for how to calculate overdraft fees, 
	 * when the bank's customer attempts to spend more money than is available.
	 */
	private AccountType type;

	// Moving the daysOverdrawn field would not make sense either,
	// since its value will be different in every other account.
	private int daysOverdrawn;

	public double overdraftCharge()
	{
		if (type.isPremium())
		{
			double result = 10;
			if (daysOverdrawn > 7)
			{
				result += (daysOverdrawn - 7) * 0.85;
			}
			return result;
		} else
		{
			return daysOverdrawn * 1.75;
		}
	}

	public double bankCharge()
	{
		double result = 4.5;
		if (daysOverdrawn > 0)
		{
			result += overdraftCharge();
		}
		return result;
	}
}

class AccountType
{
	// ...
	boolean isPremium()
	{
		return true;
	}
}
