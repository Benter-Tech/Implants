package github.benter.registry;

import github.benter.integration.DependingOn;
import github.benter.integration.Integration;
import github.benter.item.curios.CuriosFile;
import github.benter.item.curios.CuriosItem;
import github.benter.utils.IntegrationHelper;
import java.io.IOException;
import github.benter.ImplantSlot;
import github.benter.Implants;
import github.benter.data.DataService;
import github.benter.item.HeadBase;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

  public static void register() {
//    registerIfDependencyIsPresent("test_head", new TestHead(new Settings().maxCount(1)));
    registerIfDependencyIsPresent("head_base", new HeadBase(new Settings().maxCount(1)));
  }

  public static void registerIfDependencyIsPresent(String itemName, Item item){
    if (item instanceof DependingOn){
      for (Integration integration:((DependingOn) item).getDependencies()){
        if (IntegrationHelper.isModPresent(integration)){
          return;
        }
      }

    }
    register(itemName,item);
  }

  public static void register(String itemName, Item item){
    if (item instanceof CuriosItem){
      System.out.println(itemName);
      String[] itemnames = {Implants.MODID + ":" +itemName};
      for (ImplantSlot slot: ((CuriosItem) item).getSlots()) {
        try {
          DataService.getInstance().write("./resources/data/curios/tags/items"+slot.getSlotKey(),
              CuriosFile.builder().replace(false).values(itemnames).build());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

    }
    Registry.register(Registry.ITEM, new Identifier(Implants.MODID, itemName),item);
  }

}
