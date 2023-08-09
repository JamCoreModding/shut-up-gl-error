package {{group}}.{{mod_id}};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {
	public static final String MOD_ID = "{{ mod_id }}";
	public static final String MOD_NAME = "{{ name }}";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
}
