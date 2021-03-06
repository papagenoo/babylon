package com.babylon.core;

import com.babylon.core.InMemoryDatabase;
import com.babylon.core.PhraseParserTransaction;
import com.babylon.core.PhraseWithVariants;
import com.babylon.core.Database;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by max on 08/04/14.
 */
public class PhraseParserTransactionTest {
    Database database;

    @Before
    public void setUp() {
        database = new InMemoryDatabase();
    }

    @Test
    public void executeTest() {
        String original = "Я тебя люблю";
        String translation = "Ich liebe dich";
        List<List<String>> variants = Arrays.asList(
                Arrays.asList("Ich", "Du", "Ihr"),
                Arrays.asList("liebe", "lieben", "liebst", "liebt"),
                Arrays.asList("dich", "mich", "du")
        );

        String sourseText = "Я тебя люблю ; Ich liebe dich ; Ich|Du|Ihr + liebe|lieben|liebst|liebt + dich|mich|du";
        PhraseParserTransaction parser = new PhraseParserTransaction(sourseText);
        try {
            parser.execute();
            PhraseWithVariants pwv = database.getPhraseWithVariants(original);
            Assert.assertNotNull(pwv);
            Assert.assertEquals(original, pwv.getOriginal());
            Assert.assertEquals(translation, pwv.getTranslation());
            Assert.assertArrayEquals(variants.toArray(), pwv.getVariants().toArray());

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
