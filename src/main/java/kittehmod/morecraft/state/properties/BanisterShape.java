package kittehmod.morecraft.state.properties;

import net.minecraft.util.StringRepresentable;

public enum BanisterShape implements StringRepresentable
{
	SHORT, TALL, CONNECTED;

	public String toString() {
		return this.getSerializedName();
	}

	public String getSerializedName() {
		if (this == SHORT) {
			return "short";
		} else if (this == TALL) {
			return "tall";
		} else {
			return "connected";
		}
	}
}
