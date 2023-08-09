package io.github.jamalam360.shut_up_gl_error;

import java.util.Random;

public class ShutUpGLError {
	// hehe
	private static final String[] messages = new String[] {
			"GL errors? I only know GL suggestions",
			"Shut up those pesky GL key errors",
			"They're more guidelines than actual errors"
	};

	public static void init() {
		Constants.LOGGER.info(messages[new Random().nextInt(messages.length)]);
	}
}
