package coreservlets.filters;

import java.io.*;
import javax.servlet.*;

/**
 * Helper class for StringWrapper.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, Spring,
 * Hibernate, JPA, and Java</a>.
 */

public class StringOutputStream extends ServletOutputStream {
	private StringWriter stringWriter;

	public StringOutputStream(StringWriter stringWriter) {
		this.stringWriter = stringWriter;
	}

	@Override
	public void write(int c) {
		stringWriter.write(c);
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setWriteListener(WriteListener arg0) {
		// TODO Auto-generated method stub

	}
}
