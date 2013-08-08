package com.fr3gu.letsmod.configuration;

import java.io.File;

import net.minecraftforge.common.Configuration;

import com.fr3gu.letsmod.lib.ItemIds;
import com.fr3gu.letsmod.lib.Strings;

public class ConfigurationHandler {
	
//	private static final String CATEGORY_USELESS = "useless stuff";
//	
//	public static int ExampleValue;
//	private static final String EXAMPLE_NAME = "example";
//	private static final int EXAMPLE_DEFAULT = 5;
//
//	public static String SomeTextValue;
//	private static final String SOME_TEXT_NAME = "Some text";
//	private static final String SOME_TEXT_DEFAULT = "Default text";
	
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		ItemIds.WAND_ID = config.getItem(Strings.WAND_KEY, ItemIds.WAND_ID_DEFAULT).getInt(ItemIds.WAND_ID_DEFAULT);
		
//		ExampleValue = config.get(CATEGORY_USELESS, EXAMPLE_NAME, EXAMPLE_DEFAULT).getInt();
//		SomeTextValue = config.get(CATEGORY_USELESS, SOME_TEXT_NAME, SOME_TEXT_DEFAULT).getString();
		
		config.save();
	}
}
