package com.babylon.core;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by max on 05/04/14.
 */
public class Words {

    private ArrayList<String> words;

    private int current = 0;

    public Words() {
        words = new ArrayList<String>();
    }

    public Words(String[] words) {
        this.words = new ArrayList<String>(Arrays.asList(words));
    }

    public void add(String word) {
        words.add(word);
    }

    public String next() {
        String word = words.get(current++);
        if (current == words.size())
            current = 0;
        return word;
    }
}
