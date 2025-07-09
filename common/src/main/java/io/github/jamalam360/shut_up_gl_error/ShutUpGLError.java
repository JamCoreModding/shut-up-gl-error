package io.github.jamalam360.shut_up_gl_error;

import com.mojang.blaze3d.platform.InputConstants;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.platform.Platform;
import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import io.github.jamalam360.jamlib.config.ConfigManager;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;

public class ShutUpGLError {
	public static final String MOD_ID = "shut_up_gl_error";
	public static final ConfigManager<Config> CONFIG = new ConfigManager<>(MOD_ID, Config.class);
	private static final KeyMapping TEST_KEYMAPPING = new KeyMapping("shut_up_gl_error.test", InputConstants.Type.KEYSYM, InputConstants.KEY_G, "shut_up_gl_error.category");

	public static void init() {
		if (Platform.isDevelopmentEnvironment()) {
			KeyMappingRegistry.register(TEST_KEYMAPPING);

			ClientTickEvent.CLIENT_LEVEL_PRE.register((level) -> {
				if (TEST_KEYMAPPING.consumeClick()) {
					InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), -1);
				}
			});
		}
	}
}
