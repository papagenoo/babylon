package com.babylon.core.tests;

import com.babylon.core.MockTimeSink;
import com.babylon.core.MockTimeSource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 09.04.14
 * Time: 19:09
 * To change this template use File | Settings | File Templates.
 */
public class ClockDriverTest {
    private MockTimeSource source;
    private MockTimeSink sink;

    @Before
    public void setUp() {
        source = new MockTimeSource();
        sink = new MockTimeSink();
        source.registerObserver(sink);
    }

    private void AssertSinkEquals(MockTimeSink sink, int hours, int mins, int secs) {
        Assert.assertEquals(hours, sink.getHours());
        Assert.assertEquals(mins, sink.getMinutes());
        Assert.assertEquals(secs, sink.getSeconds());
    }

    @Test
    public void TestTimeChange()
    {
        source.setTime(3,4,5);
        AssertSinkEquals(sink, 3,4,5);
        source.setTime(7,8,9);
        AssertSinkEquals(sink, 7,8,9);
    }

    @Test
    public void TestMultipleSinks()
    {
        MockTimeSink sink2 = new MockTimeSink();
        source.registerObserver(sink2);
        source.setTime(12,13,14);
        AssertSinkEquals(sink, 12,13,14);
        AssertSinkEquals(sink2, 12,13,14);
    }
}
