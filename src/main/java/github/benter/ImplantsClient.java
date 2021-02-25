package github.benter;

import github.benter.networking.ModPacketsS2C;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.screen.PlayerScreenHandler;

public class ImplantsClient implements ClientModInitializer {

  @Override
  @Environment(EnvType.CLIENT)
  public void onInitializeClient() {
    ModPacketsS2C.register();
    ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE)
        .register(((spriteAtlasTexture, registry) -> {
          for (ImplantSlot slot : ImplantSlot.values()){
            registry.register(slot.getIdentifier());
          }
        }));
  }
}
