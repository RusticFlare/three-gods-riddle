package com.rusticflare.godz;

import static com.rusticflare.godz.GodName.TEE;

public final class Tee extends God {

	public Tee(GodFacts facts) {
		super(TEE, facts);
	}

	@Override
	public Responce ask(Position position, GodName name,
			Responce responce) {
		logAsk(position, name, responce);
		Responce says = facts
				.getResponce(trueAnswer(position, name)
						.equals(responce));
		logResponce(says);
		return says;
	}

}
