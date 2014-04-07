package com.babylon.core.tests;

import com.babylon.core.AddPhraseWithVariantsTransaction;
import com.babylon.core.PhraseWithVariants;
import com.babylon.core.Transaction;
import com.babylon.core.TranslationDatabase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by max on 08/04/14.
 */
public class PhraseWithVariantsTest {

    @Test
    public void variantsTest() {
        String original = "Я тебя люблю";
        String translation = "Ich liebe dich";
        String[][] variants = new String[][] {
                new String[] { "Ich", "Du", "Ihr" },
                new String[] { "lieben", "liebst", "liebt" },
                new String[] { "mich", "dich", "du" },
        };
        Transaction awvt = new AddPhraseWithVariantsTransaction(original, translation, variants);
        try {
            awvt.execute();
            PhraseWithVariants pwv = TranslationDatabase.getPhraseWithVariants(original);
            Assert.assertNotNull(pwv);
            Assert.assertEquals(original, pwv.getOriginal());
            Assert.assertEquals(translation, pwv.getTranslation());
            Assert.assertArrayEquals(variants, pwv.getVariants());

            pwv = TranslationDatabase.getPhraseWithVariants("not present phrase");
            Assert.assertNull(pwv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
