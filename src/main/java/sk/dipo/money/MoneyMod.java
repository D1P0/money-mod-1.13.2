package sk.dipo.money;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import sk.dipo.money.utils.Reference;

@Mod("dipomoneymod")
public class MoneyMod {

	public static MoneyMod instance;
	private static final Logger logger = LogManager.getLogger(Reference.MODID);
	
	public MoneyMod() {
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}

	// Pre-Init
	private void setup(final FMLCommonSetupEvent event) {
		logger.info("Setup method registered.");
	}

	// Pre-Init
	private void clientRegistries(final FMLClientSetupEvent event) {
		logger.info("ClientRegistries method registered.");
	}
}
