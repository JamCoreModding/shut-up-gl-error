package io.github.jamalam360.shut_up_gl_error;

import io.github.jamalam360.jamlib.config.ConfigExtensions;
import net.minecraft.network.chat.Component;

import java.util.List;

public class Config implements ConfigExtensions<Config> {
	public Mode mode = Mode.SILENT;

	@Override
	public List<Link> getLinks() {
		return List.of(
				new Link(Link.DISCORD, "https://jamalam.tech/discord", Component.translatable("config.shut_up_gl_error.discord")),
				new Link(Link.GITHUB, "https://github.com/JamCoreModding/shut-up-gl-error", Component.translatable("config.shut_up_gl_error.github"))
		);
	}

	public enum Mode {
		SILENT,
		LOG_ONCE,
		LOG_ALWAYS;
	}
}
