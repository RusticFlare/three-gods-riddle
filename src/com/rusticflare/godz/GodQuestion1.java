package com.rusticflare.godz;

public class GodQuestion1 {

	private final God god;

	public GodQuestion1(God god) {
		this.god = god;
	}

	public GodQuestion2 say(Responce responce) {
		return new GodQuestion2(god, responce);
	}
}
