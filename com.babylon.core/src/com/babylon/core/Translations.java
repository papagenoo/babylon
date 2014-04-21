package com.babylon.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by max on 19/04/14.
 */
public class Translations {
    private Lang originalLang;
    private Lang translationLang;

    public Translations(Lang originalLang, Lang translationLang) {
        this.originalLang = originalLang;
        this.translationLang = translationLang;
        createIterator();
    }

    private final Map<String, String> map = new HashMap<String, String>();

    Iterator<Map.Entry<String, String>> it;

    private String original;
    private String translation;

    public void next() {
        if (!it.hasNext()) {
            createIterator();
        }

        Map.Entry<String, String> entry = it.next();
        original = entry.getKey();
        translation = entry.getValue();
    }

    public Lang getTranslationLang() {
        return translationLang;
    }

    public Lang getOriginalLang() {
        return originalLang;
    }

    public String getOriginal() {
        return original;
    }

    public String getTranslation() {
        return translation;
    }

    public void add(String original, String translation) {
        map.put(original, translation);
        createIterator();
        next();
    }

    private void createIterator() {
        it = map.entrySet().iterator();
    }
}
