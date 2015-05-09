package glorywold.autorun;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION, name = Main.NAME,clientSideOnly=true)
public class Main {
	public static final String MODID = "autorunmod";
	public static final String VERSION = "1.0";
	public static final String NAME = "AutoRun Mod";

	@Instance(value = Main.MODID)
	// Tell Forge what instance to use.
	public static Main instance;
	
	@SidedProxy(clientSide="net.teammeyer.mymod.ClientProxy",serverSide="net.teammeyer.mymod.CommonProxy",modId=Main.MODID)
	public static CommonProxy proxy;

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.registerThings();
	}
}
