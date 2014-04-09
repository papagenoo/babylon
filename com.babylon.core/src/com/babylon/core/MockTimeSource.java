package com.babylon.core;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 09.04.14
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */
public class MockTimeSource extends TimeSource {
    TimeSourceImplementation timeSourceImpl =
            new TimeSourceImplementation();

    public void setTime(int hours, int mins, int secs) {
        timeSourceImpl.notify(hours, mins, secs);
    }

    public void registerObserver(ClockObserver observer)
    {
        timeSourceImpl.registerObserver(observer);
    }

}
