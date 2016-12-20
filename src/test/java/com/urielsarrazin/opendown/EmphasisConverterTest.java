package com.urielsarrazin.opendown;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EmphasisConverterTest {

    @Test
    public void test1() {
        assertEquals(new Converter("*Some text*").convert(), "<em>Some text</em>");
    }

    @Test
    public void test2() {
        assertEquals(new Converter("* Some text*").convert(), "<em> Some text</em>");
    }

    @Test
    public void test3() {
        assertEquals(new Converter("*Some text *").convert(), "<em>Some text </em>");
    }

    @Test
    public void test4() {
        assertEquals(new Converter("* Some text *").convert(), "<em> Some text </em>");
    }

    @Test
    public void test5() {
        assertEquals(new Converter("Test *some text*").convert(), "Test <em>some text</em>");
    }

    @Test
    public void test6() {
        assertEquals(new Converter("Some *test text*").convert(), "Some <em>test text</em>");
    }
}
