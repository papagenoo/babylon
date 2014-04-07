package com.babylon.core;

import java.util.Hashtable;

/**
 * Created by max on 08/04/14.
 */
public class TranslationDatabase {

    private static Hashtable<String, PhraseWithVariants> phrases = new Hashtable<String, PhraseWithVariants>();

    public static PhraseWithVariants getPhraseWithVariants(String phrase) {
        return phrases.get(phrase);
    }

    public static void addPhraseWithVariants(String original, PhraseWithVariants phraseWithVariants) {
        phrases.put(original, phraseWithVariants);
    }
}
