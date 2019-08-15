package com.spdb.training.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleLogger implements ILog {
	
	public SimpleLogger(Class<?> clazz){
		this.clazz = clazz;
	}
	
	/**
	 * 使用日志记录的class
	 */
	private Class<?> clazz;
	
	/**
	 * 日志写入文件路径
	 */
	private static final String LOG_FILE_PATH = System.getProperty("user.dir") + "\\resources\\log.txt";
	
	/**
	 * 获取异常堆栈信息
	 */
	private static GetStackTrace getStackTrace = new GetStackTrace();
	
	/**
	 * 日志文本
	 * @param logType
	 * @param msg
	 * @return
	 */
	private String getLogText(LogEnum logType,String msg){
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS ");
		StringBuffer logSB = new StringBuffer();
		logSB.append(dFormat.format(new Date()));
		logSB.append((clazz==null?"":clazz.getName()+":"));
		logSB.append(logType.getPreLogText()).append("-").append(msg);
		return logSB.toString();
	}
	
	/**
	 * 根据格式消息获取完整消息内容
	 * 例如：getMsg("证件号：{} 不存在 ","001002") -> "证件号：001002 不存在"
	 * @param msg
	 * @param args
	 * @return
	 */
	private String getMsg(String msg, Object... args){
		for (Object object : args) {
			msg = msg.replaceFirst("\\{\\}", object==null?"null":object.toString());
		}
		return msg;
	}
	
	@Override
	public void info(String msg) {
		String logT = getLogText(LogEnum.INFO, msg);
		try {
			this.logRecord(logT, LOG_FILE_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(logT);
	}

	@Override
	public void info(String msg, Throwable t) {
		String logT = getLogText(LogEnum.INFO, msg);
		try {
			this.logRecord(logT, LOG_FILE_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(logT);
		t.printStackTrace(System.err);
	}

	@Override
	public void info(String msg, Object... args) {
		String logT = getLogText(LogEnum.INFO, getMsg(msg, args));
		try {
			this.logRecord(logT, LOG_FILE_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(logT);
	}

	@Override
	public void warn(String msg) {
		String logT = getLogText(LogEnum.WARN, msg);
		try {
			this.logRecord(logT, LOG_FILE_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(logT);
	}

	@Override
	public void warn(String msg, Throwable t) {
		String logT = getLogText(LogEnum.WARN, msg);
		try {
			this.logRecord(logT, LOG_FILE_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(logT);
		t.printStackTrace(System.err);
	}

	@Override
	public void warn(String msg, Object... args) {
		String logT = getLogText(LogEnum.WARN, getMsg(msg, args));
		try {
			this.logRecord(logT, LOG_FILE_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(logT);
	}

	@Override
	public void error(String msg) {
		String logT = getLogText(LogEnum.ERROR, msg);
		try {
			this.logRecord(logT, LOG_FILE_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(logT);
	}

	@Override
	public void error(String msg, Throwable t) {
		String logT = getLogText(LogEnum.ERROR, msg);
		try {
			this.logRecord(logT, LOG_FILE_PATH);
			this.logRecord(SimpleLogger.getStackTrace.getStackTrace(t), LOG_FILE_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(logT);
		t.printStackTrace(System.err);
	}

	@Override
	public void error(String msg, Object... args) {
		String logT = getLogText(LogEnum.ERROR, getMsg(msg, args));
		try {
			this.logRecord(logT, LOG_FILE_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(logT);
	}

	@Override
	public void debug(String msg) {
		String logT = getLogText(LogEnum.DEBUG, msg);
		try {
			this.logRecord(logT, LOG_FILE_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(logT);
	}

	@Override
	public void debug(String msg, Throwable t) {
		String logT = getLogText(LogEnum.DEBUG, msg);
		try {
			this.logRecord(logT, LOG_FILE_PATH);
			this.logRecord(SimpleLogger.getStackTrace.getStackTrace(t), LOG_FILE_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(logT);
		t.printStackTrace(System.out);
	}

	@Override
	public void debug(String msg, Object... args) {
		String logT = getLogText(LogEnum.DEBUG, getMsg(msg, args));
		try {
			this.logRecord(logT, LOG_FILE_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(logT);
	}
	
	@Override
	public void logRecord(String msg, String filePath)  {
		// TODO Auto-generated method stub
		BufferedWriter bufferedWriter = null;
		 try {
	            File f = new File(filePath);
	            if (!f.exists()) {
	                f.createNewFile();
	            }
	            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(f, true));
	            bufferedWriter = new BufferedWriter(write);
	            bufferedWriter.write(msg + "\r\n");
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
                try {
                	bufferedWriter.flush();
					bufferedWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

}