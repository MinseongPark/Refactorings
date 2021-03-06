/*
 * SMELL: Error Code
 *   -- A method returns a special value that indicates an error.
 *      (Unix tradition)
 * 
 * TREATMENT: Replace Error Code with Exception 
 *   -- Throw an exception instead.
 *   -- Exceptions clearly separate normal processing from error processing 
 *      which makes programs easier to understand.
 */
package scp08.replace.errorcode.with.exception.after;

public class Demo {

	private int balance;
	
	void withdraw(int amount) {
		if (amount > balance) {
			throw new BalanceException("Withdraw amount exceed balance");
		}
		else {
			balance -= amount;
		}
	}
}

@SuppressWarnings("serial")
class BalanceException extends RuntimeException {
	public BalanceException(String message) {
		super(message);
	}
}