package com.brq.enums;

public enum Browser {
	CHROME("CHROME"), FIREFOX("FIREFOX"), EXPLORER("EXPLORER"), SAFARI("SAFARI"), OPERA("OPERA");

	private final String string;

	private Browser(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}
}