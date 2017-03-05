package com.rusticflare.godz;

public enum Responce {
	ULU, OZO;

	public Responce not() {
		if (this.equals(OZO)) {
			return ULU;
		}
		return OZO;
	}
}
