package github.benter.registry;

import github.benter.integration.DependingOn;
import github.benter.integration.Integration;
import github.benter.utils.IntegrationHelper;
import github.benter.Implants;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

  public static void register(){

  }

  public static void register(String blockName, Block block){
    registerIfDependencyIsPresent(blockName,block,true);
  }

  public static void registerIfDependencyIsPresent(String blockName, Block block, boolean withBlockItem){
    if (block instanceof DependingOn){
      for (Integration integration:((DependingOn) block).getDependencies()){
        if (IntegrationHelper.isModPresent(integration)){
          return;
        }
      }

    }
      register(blockName,block,withBlockItem);
  }

  public static void register(String blockName, Block block, boolean withBlockItem){
    Registry.register(Registry.BLOCK, new Identifier(Implants.MODID, blockName), block);
    if (withBlockItem){
      Registry.register(Registry.ITEM, new Identifier(Implants.MODID, blockName), new BlockItem(block, new Item.Settings().group(Implants.ITEM_GROUP)));
    }
  }

}
