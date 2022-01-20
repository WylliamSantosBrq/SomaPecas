package com.brq.interfaces.log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.PropertyConfigurator;

import com.brq.util.FileHelper;

public class LogWeb {
	private static final String RESOURCES = FileHelper.formatFileSeparator("src/test/resources/conflogs");

	private LogWeb() {

	}

	public static void configLogs() {
		String fName = System.getProperty("fName");
		if (fName == null || fName.isEmpty()) {
			System.setProperty("fName", getCurrentDateTime("dd_MM_yyyy[HH-mm]"));
		}
		String log4jConfigFile = RESOURCES + File.separator + "logAutomacao.properties";
		PropertyConfigurator.configure(log4jConfigFile);
	}

	private static String getCurrentDateTime(String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT-3:00"));
		Date date = new Date();
		return formatter.format(date);
	}
}
