package com.rusticflare.godz;

public abstract class God {

	public final GodName myName;
	protected final GodFacts facts;

	public God(GodName name, GodFacts facts) {
		this.myName = name;
		this.facts = facts;
	}

	/**
	 * If I were to ask you if the god with {@code name} is in {@code position},
	 * would you answer {@code responce}
	 * 
	 * @param position
	 * @param name
	 * @param responce
	 * @return
	 */
	public abstract Responce ask(Position position,
			GodName name, Responce responce);

	private Position myPosition() {
		return facts.getPositionOfGod(myName);
	}

	protected void logAsk(Position position, GodName name,
			Responce responce) {
		System.out.println("ME:\t" + myPosition()
				+ ", if I asked you \"Is " + position + " "
				+ name + "?\", would you say \"" + responce
				+ "\"?");
	}

	protected void logResponce(Responce responce) {
		System.out.println(myPosition() + ":\t" + responce);
	}

	protected Responce trueAnswer(Position position,
			GodName name) {
		return facts.getResponce(facts
				.getGodInPosition(position).equals(name));
	}

	@Override
	public String toString() {
		return myName.toString();
	}

}
