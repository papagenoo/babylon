package com.babylon.core;

/**
 * Created by max on 08/04/14.
 */
public class AddPhraseWithVariantsTransaction implements Transaction {


    private final String original;
    private final String translation;
    private final String[][] variants;

    public AddPhraseWithVariantsTransaction(String original, String translate, String[][] variants) {
        this.original = original;
        this.translation = translate;
        this.variants = variants;
    }

    @Override
    public void execute() throws Throwable {
        PhraseWithVariants pwv = new PhraseWithVariants(original, translation, variants);
        TranslationDatabase.addPhraseWithVariants(original, pwv);
    }
}
