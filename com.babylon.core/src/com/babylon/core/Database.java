package com.babylon.core;

/**
 * Created by max on 08/04/14.
 */
public interface Database {

    public PhraseWithVariants getPhraseWithVariants(String phrase);
    public void addPhraseWithVariants(String original, PhraseWithVariants phraseWithVariants);

}
