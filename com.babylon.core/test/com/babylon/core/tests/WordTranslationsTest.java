package com.babylon.core.tests;

import com.babylon.core.WordTranslations;
import com.babylon.core.Words;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by max on 04/04/14.
 */
public class WordTranslationsTest {
    @Test
    public void test() {
        WordTranslations wt = new WordTranslations();
        wt.add("делать", "machen");
        wt.add("любить", "lieben");
        Assert.assertTrue(wt.isMatch("делать", "machen"));
        Assert.assertFalse(wt.isMatch("делать", "lieben"));
        Assert.assertTrue(wt.isMatch("любить", "lieben"));
        ArrayList<String> words = wt.getWords();
        Assert.assertArrayEquals(words.toArray(), new String[] { "делать", "любить" });
    }

    @Test
    public void test2() {
        Words words = new Words();
        words.add("делать");
        words.add("любить");
        Assert.assertEquals("делать", words.next());
        Assert.assertEquals("любить", words.next());
        Assert.assertEquals("делать", words.next());
    }


//}  @Test
//   public void test3() {
//    PhraseWithVariants words = new PhraseWithVariants();
//    words.add("делать", new String[] { "machen", "" });
//    words.add("любить");
//    words.add("спрашивать");
//    words.add("любить");
//    words.add("любить");
//    Assert.assertEquals("делать", words.next());
//    Assert.assertEquals("любить", words.next());
//    Assert.assertEquals("делать", words.next());
}
