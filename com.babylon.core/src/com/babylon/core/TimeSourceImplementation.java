package com.babylon.core;

import java.util.ArrayList;

/**
 * Created by max on 10/04/14.
 */
public class TimeSourceImplementation extends TimeSource {
    private ArrayList<ClockObserver> itsObservers = new ArrayList<ClockObserver>();

    public void notify(int hours, int mins, int secs)
    {
        for (ClockObserver observer : itsObservers)
            observer.update(hours, mins, secs);
    }

    public void registerObserver(ClockObserver observer)
    {
        itsObservers.add(observer);
    }
}
