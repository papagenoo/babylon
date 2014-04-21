package com.babylon.core;

import org.junit.Test;

/**
 * Created by max on 19/04/14.
 */
public class InMemoryTranslationsDatabaseTest {
    @Test
    public void test() {
        TranslationsDatabase db = new InMemoryTranslationsDatabase();
        Translations t = new Translations(Lang.RU, Lang.DE);
        t.add("Я из Москвы", "Ich bin aus Moskau");
        t.add("Он прилетел в Берлин", "Er ist nach Berlinn gefrogen");
        t.add("Я приехал из Москвы", "Ich bin aus Moskau gefarhen");
        db.addTranslations(1, t);

        t = db.getTranslations(1, Lang.RU, Lang.DE);

    }
}
