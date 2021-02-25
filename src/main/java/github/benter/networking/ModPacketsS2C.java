package github.benter.networking;

import lombok.extern.log4j.Log4j2;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;

@Log4j2
public class ModPacketsS2C {

  @Environment(EnvType.CLIENT)
  public static void register(){
    log.info("Client Registry");
    ClientSidePacketRegistry.INSTANCE.register(ModPackets.HANDSHAKE, (packetContext, packetByteBuf) -> {});
  }
}
