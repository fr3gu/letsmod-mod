package com.fr3gu.letsmod.configuration;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigurationHandler {
	
	private static final String CATEGORY_USELESS = "useless stuff";
	
	public static int ExampleValue;
	private static final String EXAMPLE_NAME = "example";
	private static final int EXAMPLE_DEFAULT = 5;

	public static String SomeTextValue;
	private static final String SOME_TEXT_NAME = "Some text";
	private static final String SOME_TEXT_DEFAULT = "Default text";
	
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		ExampleValue = config.get(CATEGORY_USELESS, EXAMPLE_NAME, EXAMPLE_DEFAULT).getInt();
		SomeTextValue = config.get(CATEGORY_USELESS, SOME_TEXT_NAME, SOME_TEXT_DEFAULT).getString();
		
		config.save();
	}
}
