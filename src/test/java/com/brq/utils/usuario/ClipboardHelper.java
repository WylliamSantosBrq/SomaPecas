package com.brq.utils.usuario;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import com.brq.interfaces.log.BRQLogger;

public class ClipboardHelper {

	public static String getText() throws IOException {
		BRQLogger.logMethod();
		
		Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
		try {
			return (String) c.getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
