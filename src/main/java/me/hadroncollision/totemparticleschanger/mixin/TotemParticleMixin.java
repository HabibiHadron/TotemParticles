package me.hadroncollision.totemparticleschanger.mixin;

import me.hadroncollision.totemparticleschanger.config.Config;
import net.minecraft.client.particle.AnimatedParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.particle.TotemParticle;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TotemParticle.class)
public class TotemParticleMixin extends AnimatedParticle
{
	protected TotemParticleMixin(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider, float upwardsAcceleration)
	{
		super(world, x, y, z, spriteProvider, upwardsAcceleration);
	}

	@Inject(at = @At("TAIL"), method = "<init>")
	private void colorChanger(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider, CallbackInfo ci)
	{
		if (Config.doubleColor())
		{
			if (this.random.nextInt(2) == 0)
			{
				this.setColor((float) Config.getRed1Value() / 255, (float) Config.getGreen1Value() / 255, (float) Config.getBlue1Value() / 255);
			} else
			{
				this.setColor((float) Config.getRed2Value() / 255, (float) Config.getGreen2Value() / 255, (float) Config.getBlue2Value() / 255);
			}
		}
		else
		{
			this.setColor((float) Config.getRed1Value() / 255, (float) Config.getGreen1Value() / 255, (float) Config.getBlue1Value() / 255);
		}
	}
}
