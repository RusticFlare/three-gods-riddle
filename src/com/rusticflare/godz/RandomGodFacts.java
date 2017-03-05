package com.rusticflare.godz;

import static com.rusticflare.godz.GodName.ARR;
import static com.rusticflare.godz.GodName.EFF;
import static com.rusticflare.godz.GodName.TEE;
import static com.rusticflare.godz.Position.ONE;
import static com.rusticflare.godz.Position.THREE;
import static com.rusticflare.godz.Position.TWO;
import static com.rusticflare.godz.Responce.OZO;
import static com.rusticflare.godz.Responce.ULU;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomGodFacts implements GodFacts {

	private final List<GodName> gods;
	private final boolean ozo;

	public RandomGodFacts() {
		gods = new LinkedList<>();
		gods.add(TEE);
		gods.add(EFF);
		gods.add(ARR);
		Collections.shuffle(gods);
		ozo = (new Random()).nextBoolean();
	}

	@Override
	public GodName getGodInPosition(Position position) {
		return gods.get(position.ordinal());
	}

	@Override
	public Responce getResponce(boolean b) {
		if (b == ozo)
			return OZO;
		return ULU;
	}

	@Override
	public Position getPositionOfGod(GodName name) {
		if (gods.get(0).equals(name)) {
			return ONE;
		} else if (gods.get(1).equals(name)) {
			return TWO;
		} else {
			return THREE;
		}
	}

}
