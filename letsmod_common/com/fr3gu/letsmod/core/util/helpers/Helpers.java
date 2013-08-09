package com.fr3gu.letsmod.core.util.helpers;

/**
 * Lets Mod-Mod
 * 
 * Helpers
 * 
 * @author fr3gu
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class Helpers {
	public static String getUnwrappedUnlocalizedName(String unlocalizedName) {
    	return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
