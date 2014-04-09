package com.babylon.core;

import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 09.04.14
 * Time: 16:45
 * To change this template use File | Settings | File Templates.
 */
public class InMemoryDatabase implements Database {
    private static Hashtable<String, PhraseWithVariants> phrases = new Hashtable<String, PhraseWithVariants>();

    @Override
    public PhraseWithVariants getPhraseWithVariants(String phrase) {
        return phrases.get(phrase);
    }

    @Override
    public void addPhraseWithVariants(String original, PhraseWithVariants phraseWithVariants) {
        phrases.put(original, phraseWithVariants);
    }

}
