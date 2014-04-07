package com.babylon.core;

import com.babylon.core.Transaction;

/**
 * Created by max on 08/04/14.
 */
public class PhraseParserTransaction implements Transaction {

    private final String sourseText;
    private String original;
    private String translation;
    private String[][] variants;

    public PhraseParserTransaction(String sourseText) {
        this.sourseText = sourseText;
    }

    @Override
    public void execute() throws Throwable {


//        PhraseWithVariants pwv = new PhraseWithVariants(original, translation, variants);
//        TranslationDatabase.addPhraseWithVariants(original, pwv);

    }
}
