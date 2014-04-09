package com.babylon.core;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 09.04.14
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */
public class MockTimeSource implements TimeSource {

    private ClockDriver itsDriver;

    public void setTime(int hours, int minutes, int seconds) {
        itsDriver.update(hours, minutes, seconds);
    }

    @Override
    public void setDriver(ClockDriver driver) {
        itsDriver = driver;
    }
}
