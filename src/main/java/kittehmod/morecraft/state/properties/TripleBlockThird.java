package kittehmod.morecraft.state.properties;

import net.minecraft.util.StringRepresentable;

public enum TripleBlockThird implements StringRepresentable
{
	UPPER, MIDDLE, LOWER;

	public String toString() {
		return this.getSerializedName();
	}

	public String getSerializedName() {
		if (this == UPPER) {
			return "upper";
		} else if (this == MIDDLE) {
			return "middle";
		} else {
			return "lower";
		}
	}
}
