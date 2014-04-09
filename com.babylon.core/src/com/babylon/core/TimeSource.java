package com.babylon.core;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 09.04.14
 * Time: 19:25
 * To change this template use File | Settings | File Templates.
 */
public interface TimeSource {

    public void registerObserver(ClockObserver observer);

}
