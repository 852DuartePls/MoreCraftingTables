package me.duart.mctb;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Constants {

	public static final String MOD_ID = "mctb";

	@Contract("_ -> new")
	public static @NotNull ResourceLocation id(String name) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
	}
}
