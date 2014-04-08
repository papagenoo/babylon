package com.babylon.core;

import java.util.List;

/**
 * Created by max on 07/04/14.
 */
public class PhraseWithVariants {

    private final String original;
    private final String translation;
    private final List<List<String>> variants;

    public PhraseWithVariants(String original, String translation, List<List<String>> variants) {
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

    public List<List<String>> getVariants() {
        return variants;
    }

}
