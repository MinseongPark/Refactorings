/*
 * SMELL: Literal (or Magic Number)
 *   -- You have a literal number with a particular meaning.
 *   -- Magic numbers are really nasty when you need to reference 
 *      the same logical number in more than one place 
 *      ==> cause Shotgun Surgery smell
 * 
 * TREATMENT: Replace Magic Number with Symbolic Constant
 *   -- Replace the literal with a constant with meaningful name
 *   
  */
package scp05.replace.magicnumber.with.constant.after;

public class Demo {

	static final double GRAVITATIONAL_CONSTANT = 9.81;

	double potentialEnergy(double mass, double height) {
	  return mass * height * GRAVITATIONAL_CONSTANT;
	}
}
