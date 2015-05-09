package glorywold.autorun;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

import org.lwjgl.input.Keyboard;

public class MyEventHandler {

	/* autorun vars */
	private static final double WALKING_SPEED = 0.25;
	boolean autorun=false;
	private KeyBinding TOGGLE_AUTORUN;
	
	/* Bindings collection to register at runtime */
	public MyEventHandler() {
		TOGGLE_AUTORUN = new KeyBinding("Toggle Autorun", Keyboard.KEY_GRAVE, Main.NAME);
		ClientRegistry.registerKeyBinding(TOGGLE_AUTORUN);
	}
	
	/* the actual running code */
	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent e) {
		if (autorun&&e.entityLiving instanceof EntityPlayer
				&& e.entityLiving.worldObj.isRemote) {
			EntityPlayer player = (EntityPlayer) e.entityLiving;
			/* bit of trig to run forward */
			// player.motionX*=1-mAlpha;
			player.motionX = -Math.sin(player.rotationYaw*Math.PI/180)*WALKING_SPEED;
			// player.motionY*=1-mAlpha;
			player.motionZ = Math.cos(player.rotationYaw*Math.PI/180)*WALKING_SPEED;
			
		}
	}
	
	/* toggle */
	@SubscribeEvent
	public void onKeyInputEvent(KeyInputEvent e) {
		if(TOGGLE_AUTORUN.isPressed()) autorun=!autorun;
	}

	

}
