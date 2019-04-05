package sk.dipo.money;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import sk.dipo.money.items.Items;
import sk.dipo.money.utils.Reference;

@Mod(Reference.MODID)
public class MoneyMod {

	public static MoneyMod instance;
	private static final Logger LOGGER = LogManager.getLogger(Reference.MODID);

	public MoneyMod() {
		instance = this;

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

		MinecraftForge.EVENT_BUS.register(this);
	}

	// Pre-Init
	private void setup(final FMLCommonSetupEvent event) {
		LOGGER.info("Setup method registered.");
	}

	// Pre-Init
	private void clientRegistries(final FMLClientSetupEvent event) {
		LOGGER.info("ClientRegistries method registered.");
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			
			event.getRegistry().registerAll(
					Items.cent1 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("cent1")),	
					Items.cent2 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("cent2")),	
					Items.cent5 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("cent5")),	
					Items.cent10 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("cent10")),	
					Items.cent20 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("cent20")),	
					Items.cent50 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("cent50")),	
					Items.euro1 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("euro1")),		
					Items.euro2 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("euro2")),		
					Items.euro5 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("euro5")),		
					Items.euro10 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("euro10")),		
					Items.euro20 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("euro20")),		
					Items.euro50 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("euro50")),		
					Items.euro100 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("euro100")),		
					Items.euro200 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("euro200")),		
					Items.euro500 = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("euro500"))
			);
			
			LOGGER.info("Items registered.");
		}
	}

	private static ResourceLocation location(String name) {
		return new ResourceLocation(Reference.MODID, name);
	}
}
