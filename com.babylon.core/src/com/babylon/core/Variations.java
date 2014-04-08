package com.babylon.core;

import java.util.*;

/**
 * Created by max on 09/04/14.
 */
public class Variations implements Iterable<String> {

    Collection c;
    private List<String> words;

    public Variations(List<String> words) {
        this.words = words;
    }

    public Iterator<String> iterator() {
        return words.iterator();
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(words, new Random(seed));
    }
/*

    private class DequeIterator implements Iterator<String> {

        private Node currentNode = head;


        @Override
        public boolean hasNext() {
            return currentNode!=null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            Item item = currentNode.value;
            currentNode = currentNode.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
*/


}
