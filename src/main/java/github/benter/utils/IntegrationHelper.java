package github.benter.utils;

import github.benter.integration.Integration;
import net.fabricmc.loader.FabricLoader;

public class IntegrationHelper {

  public static boolean isModPresent(Integration integration){
    return isModPresent(integration.getMOD_ID());
  }
  public static boolean isModPresent(String modName){
    return FabricLoader.INSTANCE.isModLoaded(modName);
  }
}
