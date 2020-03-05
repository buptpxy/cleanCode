package com.pxy;

import org.junit.Assert;
import org.junit.Test;

public class StringBufferTests {
    @Test
    public void testSubString() {
        StringBuffer stringBuffer = new StringBuffer("abc");
        String str = stringBuffer.substring(1,stringBuffer.length()-1);
        Assert.assertEquals("b",str);
    }
}
