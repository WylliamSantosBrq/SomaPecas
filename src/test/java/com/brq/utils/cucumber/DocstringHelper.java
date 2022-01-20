package com.brq.utils.cucumber;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.brq.interfaces.log.BRQLogger;

public class DocstringHelper {

	private DocstringHelper() {
	}

	public static Map<String, String> parseDocstringMap(String docstring) {
		BRQLogger.logMethod(docstring);

		Map<String, String> dict = new HashMap<>();

		for (String line : docstring.split("\\n")) {
			String[] temp = line.split(":");
			dict.put(temp[0].trim(), temp[1].trim());
		}

		return dict;
	}

	public static Set<String> parseDocstringSet(String docstring) {
		BRQLogger.logMethod(docstring);

		return parseDocstringSet(docstring, "\\n");
	}
	
	public static Set<String> parseDocstringSet(String docstring, String separatorRegex) {
		BRQLogger.logMethod(docstring, separatorRegex);

	    Set<String> set = new HashSet<>();
	    Collections.addAll(set, docstring.split("\\n"));
	    return set;		
	}
	
	public static String[] parseDocstringArray(String docstring) {
		BRQLogger.logMethod(docstring);

		return parseDocstringArray(docstring, "\\n");		
	}
	
	public static String[] parseDocstringArray(String docstring, String separatorRegex) {
		BRQLogger.logMethod(docstring, separatorRegex);

		return docstring.split(separatorRegex);
		
	}

}
