package com.babylon.core;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 09.04.14
 * Time: 19:17
 * To change this template use File | Settings | File Templates.
 */
public class ClockDriver {
    private TimeSink sink;

    public ClockDriver(TimeSource source, TimeSink sink)
    {
        source.setDriver(this);
        this.sink = sink;
    }

    public void update(int hours, int minutes, int seconds)
    {
        sink.setTime(hours, minutes, seconds);
    }
}
