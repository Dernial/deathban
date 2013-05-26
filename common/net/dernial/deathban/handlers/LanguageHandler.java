package net.dernial.deathban.handlers;

import net.dernial.deathban.lib.Languages;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Deathban
 * 
 * LanguageHandler
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class LanguageHandler {

    public static void loadLanguages() {

        // For every file specified in the Localization library class, load them into the Language Registry
        for (String localizationFile : Languages.languageFiles) {
            LanguageRegistry.instance().loadLocalization(localizationFile, getLanguageFromFileName(localizationFile), isXMLLanguageFile(localizationFile));
        }
    }
    
    public static boolean isXMLLanguageFile(String fileName) {

        return fileName.endsWith(".xml");
    }
    
    public static String getLanguageFromFileName(String fileName) {

        return fileName.substring(fileName.lastIndexOf('/') + 1, fileName.lastIndexOf('.'));
    }
    
    public static String getLocalizedString(String key) {

        return LanguageRegistry.instance().getStringLocalization(key);
    }

}
