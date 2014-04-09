package com.babylon.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 08/04/14.
 */
public class PhraseParserTransaction implements Transaction {
    Database database = new InMemoryDatabase();

    private final String sourseText;

    public PhraseParserTransaction(String sourseText) {
        this.sourseText = sourseText;
    }

    @Override
    public void execute() throws Throwable {
        String[] parts = sourseText.split(";");
        String original = parts[0].trim();
        String translation = parts[1].trim();
        String variantsStr = parts[2].trim();
        String[] variantGroups = variantsStr.split("\\+");
        List<List<String>> variants = new ArrayList<List<String>>();


        for (int i = 0; i < variantGroups.length; i++) {
            String[] variantsArr = variantGroups[i].trim().split("\\|");
            ArrayList<String> variantsList = new ArrayList<String>();

            for (int j = 0; j < variantsArr.length; j++) {
                if (variantsArr[j] != null && !variantsArr[j].isEmpty())
                    variantsList.add(variantsArr[j].trim());
            }

            if (!variantsList.isEmpty())
                variants.add(variantsList);
        }

        PhraseWithVariants pwv = new PhraseWithVariants(original, translation, variants);
        database.addPhraseWithVariants(original, pwv);

    }
}
