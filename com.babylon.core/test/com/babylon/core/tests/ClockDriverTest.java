package com.babylon.core.tests;

import com.babylon.core.ClockDriver;
import com.babylon.core.MockTimeSink;
import com.babylon.core.MockTimeSource;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 09.04.14
 * Time: 19:09
 * To change this template use File | Settings | File Templates.
 */
public class ClockDriverTest {
    @Test
    public void TestTimeChange() {
        MockTimeSource source = new MockTimeSource();
        MockTimeSink sink = new MockTimeSink();
        ClockDriver driver = new ClockDriver(source, sink);
        source.setTime(3, 4, 5);
        Assert.assertEquals(3, sink.getHours());
        Assert.assertEquals(4, sink.getMinutes());
        Assert.assertEquals(5, sink.getSeconds());
        source.setTime(7,8,9);
        Assert.assertEquals(7, sink.getHours());
        Assert.assertEquals(8, sink.getMinutes());
        Assert.assertEquals(9, sink.getSeconds());
    }
}
