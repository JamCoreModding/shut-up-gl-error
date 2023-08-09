package io.github.jamalam360.shut_up_gl_error;

import net.fabricmc.api.ModInitializer;

public class ShutUpGLErrorFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ShutUpGLError.init();
    }
}
