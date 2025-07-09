package io.github.jamalam360.shut_up_gl_error.mixin;

import com.mojang.blaze3d.platform.Window;
import io.github.jamalam360.shut_up_gl_error.Config;
import io.github.jamalam360.shut_up_gl_error.ShutUpGLError;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(Window.class)
public class WindowMixin {
	@Unique
	private final List<Integer> shut_up_gl_error$loggedErrorCodes = new ArrayList<>();

	@Inject(
			method = "defaultErrorCallback",
			at = @At("HEAD"),
			cancellable = true
	)
	private void shut_up_gl_error$interceptGlErrorLogging(int error, long description, CallbackInfo ci) {
		Config config = ShutUpGLError.CONFIG.get();

		if (config.mode == Config.Mode.SILENT || (config.mode == Config.Mode.LOG_ONCE && this.shut_up_gl_error$loggedErrorCodes.contains(error))) {
			ci.cancel();
		} else if (config.mode == Config.Mode.LOG_ONCE) {
			this.shut_up_gl_error$loggedErrorCodes.add(error);
		}
	}
}
