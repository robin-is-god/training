package com.spdb.training.log;

import java.io.PrintWriter;
import java.io.StringWriter;

public class GetStackTrace {
	public StringWriter sWriter;
	public PrintWriter pWriter;
	
	
	
	public GetStackTrace() {
		// TODO Auto-generated constructor stub
	}



	public StringWriter getsWriter() {
		return sWriter;
	}



	public void setsWriter(StringWriter sWriter) {
		this.sWriter = sWriter;
	}



	public PrintWriter getpWriter() {
		return pWriter;
	}



	public void setpWriter(PrintWriter pWriter) {
		this.pWriter = pWriter;
	}



	public String getStackTrace(Throwable throwable) {
		sWriter = new StringWriter();
		pWriter = new PrintWriter(sWriter);
		try {
			throwable.printStackTrace(pWriter);
			pWriter.flush();
			sWriter.flush();
			return sWriter.toString();
		} finally {
			// TODO: handle finally clause
			pWriter.close();
		}
	}
}
