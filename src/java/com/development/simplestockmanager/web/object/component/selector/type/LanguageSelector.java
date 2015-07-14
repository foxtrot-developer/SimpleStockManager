package com.development.simplestockmanager.web.object.component.selector.type;

import com.development.simplestockmanager.business.object.controller.specific.LanguageSpecificController;
import com.development.simplestockmanager.business.object.nullpackage.LanguageNull;
import com.development.simplestockmanager.business.persistence.Language;
import com.development.simplestockmanager.web.common.WebConstant;
import com.development.simplestockmanager.web.object.component.selector.BaseSelector;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Selector class for Language object
 *
 * @author foxtrot
 */
public class LanguageSelector extends CommonTypeSelector implements BaseSelector {

    private final LanguageSpecificController specificController;
    private HashMap<String, Language> hashMap;

    public LanguageSelector(String language) {
        super(WebConstant.SELECTOR.MODE.NONE, language);
        specificController = new LanguageSpecificController(language);
        search();
    }

    @Override
    public void search() {
        clear();
        
        for (Language language : specificController.getFindAllForSelector()) {
            String key = getDisplayName(language);
            hashMap.put(key, language);
            list.add(key);
        }
    }

    @Override
    public void clear() {
        hashMap = new HashMap<>();
        list = new ArrayList<>();
    }

    public Language getSelectedValue() {
        Language language = new LanguageNull();

        if (!selection.isEmpty()) {
            language = hashMap.get(selection);
        }

        return language;
    }

    private String getDisplayName(Language language) {
        return language.getLanguage();
    }
    
    public String getDisplayName(Language language, String code) {
        String translation = WebConstant.UNDEFINED;
        
        for (Language languageTranslation : language.getLanguageList()) {
            if (languageTranslation.getCode().equals(code)) {
                translation = getDisplayName(languageTranslation);
            }
        }
        
        return translation;
    }
}