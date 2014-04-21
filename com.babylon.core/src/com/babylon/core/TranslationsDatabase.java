package com.babylon.core;

/**
 * Created by max on 19/04/14.
 */
public interface TranslationsDatabase {
    Translations getTranslations(int level, Lang originLang, Lang translationLang);
    void addTranslations(int level, Translations translations);
}
