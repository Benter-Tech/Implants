package github.benter;

import github.benter.integration.Integration;
import github.benter.registry.ModBlocks;
import github.benter.registry.ModItems;
import github.benter.utils.IntegrationHelper;
import lombok.extern.log4j.Log4j2;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeInfo;

@Log4j2
public class Implants implements ModInitializer {
	public static final String MODID= "implants";
	public static final ItemGroup ITEM_GROUP= FabricItemGroupBuilder.create(new Identifier(MODID)).build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		log.info(String.format("Initialization of %s started", MODID));

		checkForIntegrations();
		register();
		initializeSlots();
		log.info(String.format("Initialization of %s finished", MODID));

	}

	private void initializeSlots(){
		log.trace("Initialization of slots started");
		for (ImplantSlot slot : ImplantSlot.values()) {
			CuriosApi.enqueueSlotType(SlotTypeInfo.BuildScheme.REGISTER, new SlotTypeInfo.Builder(slot.getSlotKey()).icon(slot.getIdentifier()).priority(slot.ordinal()).build());
		}
		log.trace("Initialization of slots finished");
	}

	private void checkForIntegrations(){
		log.trace("Check if Integrated Mods are present");
		for (Integration integration : Integration.values()) {
			if (IntegrationHelper.isModPresent(integration)){
				log.info(integration.name() + " is detected");
			}
		}
	}

	private void register(){
		ModItems.register();
		ModBlocks.register();
	}
}
