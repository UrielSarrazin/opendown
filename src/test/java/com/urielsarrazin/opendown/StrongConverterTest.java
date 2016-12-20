package com.urielsarrazin.opendown;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StrongConverterTest {

    @Test
    public void test1() {
        assertEquals(new Converter("**This is a strong emphasis**").convert(), "<strong>This is a strong emphasis</strong>");
    }

    @Test
    public void test2() {
        assertEquals(new Converter("** This is a strong emphasis**").convert(), "<strong> This is a strong emphasis</strong>");
    }

    @Test
    public void test3() {
        assertEquals(new Converter("**This is a strong emphasis **").convert(), "<strong>This is a strong emphasis </strong>");
    }

    @Test
    public void test4() {
        assertEquals(new Converter("** This is a strong emphasis **").convert(), "<strong> This is a strong emphasis </strong>");
    }

    @Test
    public void test5() {
        assertEquals(new Converter("This is a **strong emphasis**").convert(), "This is a <strong>strong emphasis</strong>");
    }

    @Test
    public void test6() {
        assertEquals(new Converter("This is a **strong** emphasis").convert(), "This is a <strong>strong</strong> emphasis");
    }
}
