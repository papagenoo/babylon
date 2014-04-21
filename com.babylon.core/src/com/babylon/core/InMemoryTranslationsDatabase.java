package com.babylon.core;

import java.util.Hashtable;

/**
 * Created by max on 19/04/14.
 */
public class InMemoryTranslationsDatabase implements TranslationsDatabase {

    Hashtable<String, Translations> ts = new Hashtable<String, Translations>();

    @Override
    public Translations getTranslations(int level, Lang originLang, Lang translationLang) {
        String key = getKey(level, originLang, translationLang);
        if (ts.containsKey(key)) {
            return ts.get(key);
        } else {
            return new Translations(originLang, translationLang);
        }
    }

    @Override
    public void addTranslations(int level, Translations translations) {
        Lang originalLang = translations.getOriginalLang();
        Lang translateLang = translations.getTranslationLang();
        String key = getKey(level, originalLang, translateLang);
        ts.put(key, translations);
    }

    private Translations getRuGeTranslationsLevel1() {
        Translations t = new Translations(Lang.RU, Lang.DE);
        t.add("Я из Москвы", "Ich bin aus Moskau");
        t.add("Он прилетел в Берлин", "Er ist nach Berlinn gefrogen");
        t.add("Я приехал из Москвы", "Ich bin aus Moskau gefarhen");
        return t;
    }

    private String getKey(int level, Lang original, Lang translation) {
        return level + "_" + langToString(original) + "_" + langToString(translation);
    }

    private String langToString(Lang l) {
        switch (l) {
            case DE: return "DE";
            case EN: return "EN";
            case RU: return "RU";
        }
        return "EN";
    }
}
