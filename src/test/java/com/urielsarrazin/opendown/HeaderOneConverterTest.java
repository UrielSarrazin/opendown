package com.urielsarrazin.opendown;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HeaderOneConverterTest {

    private static final String TEXT = "Header content";

    private static final String EXPECTED = "<h1>Header content</h1>";

    @Test
    public void test1() {
        assertEquals(new Converter("# " + TEXT).convert(), EXPECTED);
    }

    @Test
    public void test2() {
        assertEquals(new Converter("# " + TEXT + " ").convert(), EXPECTED);
    }

    @Test
    public void test3() {
        assertEquals(new Converter("# " + TEXT + " " + "#").convert(), "<h1>Header content #</h1>");
    }
}
