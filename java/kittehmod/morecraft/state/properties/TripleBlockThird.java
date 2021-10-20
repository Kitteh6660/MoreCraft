package kittehmod.morecraft.state.properties;

import net.minecraft.util.IStringSerializable;

public enum TripleBlockThird implements IStringSerializable
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
