package com.rusticflare.godz;

import static com.rusticflare.godz.GodName.ARR;
import static com.rusticflare.godz.Responce.OZO;
import static com.rusticflare.godz.Responce.ULU;

import java.util.Random;

public final class Arr extends God {

	public Arr(GodFacts facts) {
		super(ARR, facts);
	}

	@Override
	public Responce ask(Position position, GodName name,
			Responce responce) {
		logAsk(position, name, responce);
		Responce says = null;
		if ((new Random()).nextBoolean()) {
			says = OZO;
		} else {
			says = ULU;
		}
		logResponce(says);
		return says;
	}

}
