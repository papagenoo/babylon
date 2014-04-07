package com.babylon.core;

/**
 * Created by max on 07/04/14.
 */
public class PhraseWithVariants {

    private final String original;
    private final String translation;
    private final String[][] variants;

    public PhraseWithVariants(String original, String translation, String[][] variants) {
        this.original = original;
        this.translation = translation;
        this.variants = variants;
    }

    public String getOriginal() {
        return original;
    }

    public String getTranslation() {
        return translation;
    }

    public String[][] getVariants() {
        return variants;
    }

}
