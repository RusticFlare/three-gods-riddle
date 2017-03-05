package com.rusticflare.godz;

public class GodQuestion2 {

	private final God god;
	private final Responce responce;

	public GodQuestion2(God god, Responce responce) {
		this.god = god;
		this.responce = responce;
	}

	public GodQuestion3 ifAskedWhether(GodName name) {
		return new GodQuestion3(god, responce, name);
	}

}
