package com.rusticflare.godz;

public interface GodFacts {

	GodName getGodInPosition(Position position);

	Responce getResponce(boolean b);

	Position getPositionOfGod(GodName name);
}
