package com.urielsarrazin.opendown;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HeaderTwoConverterTest {

    private static final String TEXT = "Header content";

    private static final String EXPECTED = "<h2>Header content</h2>";

    @Test
    public void test1() {
        assertEquals(new Converter("## " + TEXT).convert(), EXPECTED);
    }

    @Test
    public void test2() {
        assertEquals(new Converter("## " + TEXT + " ").convert(), EXPECTED);
    }

    @Test
    public void test3() {
        assertEquals(new Converter("## Header content with #").convert(), "<h2>Header content with #</h2>");
    }
}
