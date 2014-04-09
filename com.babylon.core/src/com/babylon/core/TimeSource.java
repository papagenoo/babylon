package com.babylon.core;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 09.04.14
 * Time: 19:25
 * To change this template use File | Settings | File Templates.
 */
public abstract class TimeSource {
    private ArrayList<ClockObserver> itsObservers = new ArrayList<ClockObserver>();

    public void registerObserver(ClockObserver observer) {
        itsObservers.add(observer);
    }

    protected void notify(int hours, int mins, int secs) {
        for (ClockObserver observer : itsObservers)
            observer.update(hours, mins, secs);
    }
}
