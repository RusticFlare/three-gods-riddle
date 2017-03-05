package com.rusticflare.godz;

public class GodQuestion3 {

	private final God god;
	private final Responce responce;
	private final GodName name;

	public GodQuestion3(God god, Responce responce,
			GodName name) {
		this.god = god;
		this.responce = responce;
		this.name = name;
	}

	public Responce isInPosition(Position position) {
		return god.ask(position, name, responce);
	}

}
