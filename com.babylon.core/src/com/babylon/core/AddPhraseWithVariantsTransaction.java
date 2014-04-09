package com.babylon.core;

import java.util.List;

/**
 * Created by max on 08/04/14.
 */
public class AddPhraseWithVariantsTransaction implements Transaction {
    Database database = new InMemoryDatabase();

    private final String original;
    private final String translation;
    private final List<List<String>> variants;

    public AddPhraseWithVariantsTransaction(String original, String translate, List<List<String>> variants) {
        this.original = original;
        this.translation = translate;
        this.variants = variants;
    }

    @Override
    public void execute() throws Throwable {
        PhraseWithVariants pwv = new PhraseWithVariants(original, translation, variants);
        database.addPhraseWithVariants(original, pwv);
    }
}
