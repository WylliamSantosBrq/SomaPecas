package com.brq.drivers.desktop;

import org.sikuli.script.Screen;

import lombok.Getter;

public class Sikuli {
	private static final @Getter(lazy=true) Screen screen = new Screen();
}
