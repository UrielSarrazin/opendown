package com.urielsarrazin.opendown;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SimpleConverterTest {

    @Test
    public void correctHeaderOneMarkdownSyntaxUnitTest() {
        assertEquals(new SimpleConverter("# Some text # Test").convert(), "<h1>Some text # Test</h1>");
        assertEquals(new SimpleConverter("## Some text").convert(), "<h2>Some text</h2>");
        assertEquals(new SimpleConverter("### Some text").convert(), "<h3>Some text</h3>");
        assertEquals(new SimpleConverter("#### Some text").convert(), "<h4>Some text</h4>");
        assertEquals(new SimpleConverter("##### Some text").convert(), "<h5>Some text</h5>");
        assertEquals(new SimpleConverter("###### Some text").convert(), "<h6>Some text</h6>");
    }

    @Test
    public void emphasisConvertionUnitTest() {
        assertEquals(new SimpleConverter("*Some text*").convert(), "<em>Some text</em>");
        assertEquals(new SimpleConverter("*Some text *").convert(), "<em>Some text </em>");
        assertEquals(new SimpleConverter("Test of *Emphasis *, it works ").convert(), "Test of <em>Emphasis </em>, it works ");
        assertEquals(new SimpleConverter("** Some text *").convert(), "*<em> Some text </em>");
    }

    @Test
    public void strongEmphasisConvertionUnitTest() {
        assertEquals(new SimpleConverter("**Some text**").convert(), "<strong>Some text</strong>");
        assertEquals(new SimpleConverter("Test **Some text **").convert(), "Test <strong>Some text </strong>");
        assertEquals(new SimpleConverter("**Some text **test").convert(), "<strong>Some text </strong>test");
    }
}
