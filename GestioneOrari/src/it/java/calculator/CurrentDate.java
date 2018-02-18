package it.java.calculator;

import java.util.Calendar;

import org.openxava.calculators.ICalculator;

public class CurrentDate implements ICalculator{

	@Override
	public Object calculate() throws Exception {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
	

}
