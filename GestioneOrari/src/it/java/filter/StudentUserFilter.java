package it.java.filter;


import org.openxava.filters.IFilter;
import org.openxava.util.Users;

/**
 * 
 * @author MBONAFE
 *
 */

public class StudentUserFilter implements IFilter {
	public Object filter(Object o){
		Object[] r = new Object[1];
		r[0] = Users.getCurrent().trim();
		return r;
	}
}
