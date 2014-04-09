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

    public void setTime(int hours, int minutes, int seconds) {
        notify(hours, minutes, seconds);
    }

}
