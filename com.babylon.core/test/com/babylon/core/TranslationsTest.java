package com.babylon.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by max on 19/04/14.
 */
public class TranslationsTest {
    @Test
    public void test() {
        String[] o = { "Я из Москвы", "Он прилетел в Берлин", "Я приехал из Москвы" };
        String[] t = { "Ich bin aus Moskau", "Er ist nach Berlinn gefrogen", "Ich bin aus Moskau gefarhen" };
        Translations translations = new Translations(Lang.RU, Lang.DE);
        Assert.assertEquals(null, translations.getOriginal());
        Assert.assertEquals(null, translations.getTranslation());

        // one element loop
        translations.add(o[0], t[0]);
        Assert.assertEquals(o[0], translations.getOriginal());
        Assert.assertEquals(t[0], translations.getTranslation());
        translations.next();
        Assert.assertEquals(o[0], translations.getOriginal());
        Assert.assertEquals(t[0], translations.getTranslation());

        // two elements loop
        translations.add(o[1], t[1]);
        Assert.assertEquals(o[0], translations.getOriginal());
        Assert.assertEquals(t[0], translations.getTranslation());
        translations.next();
        Assert.assertEquals(o[1], translations.getOriginal());
        Assert.assertEquals(t[1], translations.getTranslation());
        translations.next();
        Assert.assertEquals(o[0], translations.getOriginal());
        Assert.assertEquals(t[0], translations.getTranslation());

        // three elements loop
        translations.add(o[2], t[2]);
        Assert.assertEquals(o[0], translations.getOriginal());
        Assert.assertEquals(t[0], translations.getTranslation());
        translations.next();
        Assert.assertEquals(o[1], translations.getOriginal());
        Assert.assertEquals(t[1], translations.getTranslation());
        translations.next();
        Assert.assertEquals(o[2], translations.getOriginal());
        Assert.assertEquals(t[2], translations.getTranslation());
        translations.next();
        Assert.assertEquals(o[0], translations.getOriginal());
        Assert.assertEquals(t[0], translations.getTranslation());
    }
}
