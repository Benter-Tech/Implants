package github.benter.mixin;

import github.benter.networking.ModPackets;
import lombok.extern.log4j.Log4j2;
import github.benter.Implants;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Log4j2
@Mixin(PlayerManager.class)
public class LoginMixin {

	@Inject(at = @At("TAIL"), method = "Lnet/minecraft/server/PlayerManager;onPlayerConnect(Lnet/minecraft/network/ClientConnection;Lnet/minecraft/server/network/ServerPlayerEntity;)V")
	private void checkIfModIsOnClient(ClientConnection connection, ServerPlayerEntity player, CallbackInfo info) {
		if (!ServerSidePacketRegistry.INSTANCE.canPlayerReceive(player, ModPackets.HANDSHAKE)) {
			log.info(String
					.format("Player disconnected because %s is not installed on the client", Implants.MODID));
			connection.disconnect(new TranslatableText(""));
		}
	}
}
