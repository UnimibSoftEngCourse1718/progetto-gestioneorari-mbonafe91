package it.java.calculator;

import org.openxava.calculators.ICalculator;
import org.openxava.util.Users;

public class CurrentUser implements ICalculator{

	@Override
	public Object calculate() throws Exception {
		return Users.getCurrent().trim();
	}
}
