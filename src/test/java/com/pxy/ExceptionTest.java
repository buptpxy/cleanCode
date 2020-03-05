package com.pxy;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.fail;

public class ExceptionTest {
    @Test
    public void testExceptionMessage() {
        try {
            new ArrayList<>().get(0);
//            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Index 0 out of bounds for length 0");
        }
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Test
    public void testExceptionType() {
        expectedException.expect(IndexOutOfBoundsException.class);
        expectedException.expectMessage("Index 0 out of bounds for length 0");
        new ArrayList<>().get(0);
    }

}
