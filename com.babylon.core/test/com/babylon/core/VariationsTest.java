package com.babylon.core;

import com.babylon.core.Variations;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by max on 09/04/14.
 */
public class VariationsTest {
    @Test
    public void iteratorTest() {
        Variations variations = new Variations(Arrays.asList("Привет", "Пока"));
        Iterator<String> iterator = variations.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("Привет", iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("Пока", iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void shuffleTest() {
        Variations variations = new Variations(Arrays.asList("Привет", "Пока"));

        variations.shuffle();
        Iterator<String> iterator = variations.iterator();
        ArrayList<String> res = new ArrayList<String>();
        res.add(iterator.next());
        res.add(iterator.next());
        Assert.assertTrue(res.contains("Привет"));
        Assert.assertTrue(res.contains("Пока"));

        variations.shuffle();
        iterator = variations.iterator();
        res = new ArrayList<String>();
        res.add(iterator.next());
        res.add(iterator.next());
        Assert.assertTrue(res.contains("Привет"));
        Assert.assertTrue(res.contains("Пока"));
    }

//    @Test
//    public void topWordsTest() {
//        Assert.fail();
//        Variations variations = new Variations(Arrays.asList("Привет", "Пока", "Верно", "Неверно"));
//        variations.shuffle();
//        Iterator<String> iterator = variations.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        iterator = variations.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//    }
}
