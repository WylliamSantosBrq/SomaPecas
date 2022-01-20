package com.brq.enums;

public enum Font {
	CALIBRI("Calibri");

	private String string;

	private Font(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}

}
