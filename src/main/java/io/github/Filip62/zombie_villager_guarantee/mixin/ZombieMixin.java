package io.github.Filip62.zombie_villager_guarantee.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.monster.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Zombie.class)
public class ZombieMixin {
	@Redirect(method = "wasKilled", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;getDifficulty()Lnet/minecraft/world/Difficulty;"))
	private Difficulty injected(ServerLevel instance) {
		Difficulty difficulty = instance.getDifficulty();
		if (difficulty == Difficulty.NORMAL) {
			return Difficulty.HARD;
		}
		return difficulty;
	}
}
