package it.java.filter;

import org.openxava.filters.FilterException;
import org.openxava.filters.IFilter;
import org.openxava.util.Users;

/**
 * 
 * @author MBONAFE
 *
 */

public class StudentUserFilter implements IFilter {
	public Object filter(Object o) throws FilterException {
		Object[] r = new Object[1];
		r[0] = Users.getCurrent().trim();
		//if(Users.getCurrent().contains("[A-Z]")) 
		//	r[1] = "ALL";
		return r;
	}
}
