package com.rusticflare.godz;

import static com.rusticflare.godz.GodName.ARR;
import static com.rusticflare.godz.GodName.EFF;
import static com.rusticflare.godz.GodName.TEE;
import static com.rusticflare.godz.Position.ONE;
import static com.rusticflare.godz.Position.THREE;
import static com.rusticflare.godz.Position.TWO;
import static com.rusticflare.godz.Responce.OZO;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class ThreeGodProblem {

	private final God[] gods;
	private final Map<Position, GodName> posToName;

	public ThreeGodProblem() {
		GodFacts godFacts = new RandomGodFacts();
		gods = new God[3];
		setUpGods(godFacts);
		posToName = new HashMap<>();
	}

	private void setUpGods(GodFacts godFacts) {
		gods[0] = getGodInPosition(ONE, godFacts);
		gods[1] = getGodInPosition(TWO, godFacts);
		gods[2] = getGodInPosition(THREE, godFacts);

	}

	private static God getGodInPosition(Position position,
			GodFacts godFacts) {
		GodName name = godFacts.getGodInPosition(position);
		return getGodFromName(name, godFacts);
	}

	public void put(Position position, GodName name) {
		System.out.println(
				"(Then " + position + " is " + name + ")");
		posToName.put(position, name);
	}

	private static God getGodFromName(GodName name,
			GodFacts godFacts) {
		switch (name) {
		case ARR:
			return new Arr(godFacts);
		case EFF:
			return new Eff(godFacts);
		case TEE:
			return new Tee(godFacts);
		default:
			throw new InvalidParameterException();
		}
	}

	public GodQuestion1 wouldTheGodInPosition(
			Position position) {
		return new GodQuestion1(gods[position.ordinal()]);
	}

	public boolean guess() {
		return gods[0].myName.equals(posToName.get(ONE))
				&& gods[1].myName.equals(posToName.get(TWO))
				&& gods[2].myName
						.equals(posToName.get(THREE));
	}

	public static void main(String[] args) {
		ThreeGodProblem problem = new ThreeGodProblem();

		Responce isArrin1 = problem
				.wouldTheGodInPosition(TWO).say(OZO)
				.ifAskedWhether(ARR).isInPosition(ONE);
		Position notArrPos = null;
		Position maybeArrPos = null;
		if (isArrin1.equals(OZO)) {
			notArrPos = THREE;
			maybeArrPos = ONE;
		} else {
			notArrPos = ONE;
			maybeArrPos = THREE;
		}
		System.out.println(
				"(Then " + notArrPos + " is not ARR)");
		Responce isNotArrTee = problem
				.wouldTheGodInPosition(notArrPos).say(OZO)
				.ifAskedWhether(TEE)
				.isInPosition(notArrPos);
		GodName notArrName;
		GodName maybeArrName;
		if (isNotArrTee.equals(OZO)) {
			notArrName = TEE;
			maybeArrName = EFF;
		} else {
			notArrName = EFF;
			maybeArrName = TEE;
		}
		problem.put(notArrPos, notArrName);
		Responce isTwoArr = problem
				.wouldTheGodInPosition(notArrPos).say(OZO)
				.ifAskedWhether(ARR).isInPosition(TWO);
		if (isTwoArr.equals(OZO)) {
			problem.put(TWO, ARR);
			problem.put(maybeArrPos, maybeArrName);
		} else {
			problem.put(TWO, maybeArrName);
			problem.put(maybeArrPos, ARR);
		}
		System.out.println(problem.guess());
		System.out.println(Arrays.toString(problem.gods));
	}

}
