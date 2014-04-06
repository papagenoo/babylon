package com.babylon.core;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by max on 04/04/14.
 */
public class WordTranslations {

    private Hashtable<String, String> translations = new Hashtable<String, String>();

    /**
     * Matches word with it translation
     * @param word
     * @param translation
     * @return true if translation corrensponds to the word
     */
    public boolean isMatch(String word, String translation) {
        return translations.get(word).equals(translation);
    }

    /**
     * Add word with it translation
     * @param word
     * @param translation
     */
    public void add(String word, String translation) {
        translations.put(word, translation);
    }

    /**
     * Rerurns all words in ArrayList<String>
     * @return
     */
    public ArrayList<String> getWords() {
        Enumeration<String> keys = translations.keys();
        ArrayList<String> words = new ArrayList<String>();
        while(keys.hasMoreElements()){
            String word = keys.nextElement();
            words.add(word);
        }
        return words;
    }
}
