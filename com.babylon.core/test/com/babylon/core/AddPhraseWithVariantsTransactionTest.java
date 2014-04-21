package com.babylon.core;

import com.babylon.core.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by max on 08/04/14.
 */
public class AddPhraseWithVariantsTransactionTest {
    Database database;

    @Before
    public void setUp() {
        database = new InMemoryDatabase();
    }

    @Test
    public void variantsTest() {
        String original = "Я тебя люблю";
        String translation = "Ich liebe dich";

        List<List<String>> variants = Arrays.asList(
                Arrays.asList("Ich", "Du", "Ihr"),
                Arrays.asList("lieben", "liebst", "liebt"),
                Arrays.asList("mich", "dich", "du")
        );
        Transaction awvt = new AddPhraseWithVariantsTransaction(original, translation, variants);
        try {
            awvt.execute();
            PhraseWithVariants pwv = database.getPhraseWithVariants(original);
            Assert.assertNotNull(pwv);
            Assert.assertEquals(original, pwv.getOriginal());
            Assert.assertEquals(translation, pwv.getTranslation());
            Assert.assertArrayEquals(variants.toArray(), pwv.getVariants().toArray());

            List<List<String>> dbVariants = pwv.getVariants();
            ListIterator<List<String>> iterator = dbVariants.listIterator();
            for (List<String> item : dbVariants) {
                System.out.println(item.get(0));
            }
//            Assert.fail();

            pwv = database.getPhraseWithVariants("not present phrase");
            Assert.assertNull(pwv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
