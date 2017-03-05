package com.rusticflare.godz;

import static com.rusticflare.godz.GodName.EFF;

public final class Eff extends God {

	public Eff(GodFacts facts) {
		super(EFF, facts);
	}

	@Override
	public Responce ask(Position position, GodName name,
			Responce responce) {
		logAsk(position, name, responce);
		Responce says = facts
				.getResponce(trueAnswer(position, name)
						.not().equals(responce))
				.not();
		logResponce(says);
		return says;
	}

}
