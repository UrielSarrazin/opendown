package com.urielsarrazin.opendown;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ThematicBreakConverterTest {

    @Test
    public void test1() {
        assertEquals(new Converter("***").convert(), "<hr/>");
    }
}
