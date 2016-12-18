package com.urielsarrazin.opendown;

import com.urielsarrazin.opendown.MarkdownToHtmlConverter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HeaderMarkdownToHtmlConvertionTest {

    @Test
    public void correctHeaderOneMarkdownSyntaxUnitTest() {
        assertEquals(new MarkdownToHtmlConverter("# Some text").convert(), "<h1>Some text</h1>");
    }

    @Test
    public void headerOneLeadingWhiteSpaceUnitTest() {

        final String markdown = " # Some text";

        assertEquals(new MarkdownToHtmlConverter(markdown).convert(), markdown);
    }

    @Test
    public void HeaderOneNoWhiteSpaceBetweenDashAndTextUnitTest() {

        final String markdown = "#Some text";

        assertEquals(new MarkdownToHtmlConverter(markdown).convert(), markdown);
    }

    @Test
    public void headerTwoCorrectMarkdownSyntaxUnitTest() {
        assertEquals(new MarkdownToHtmlConverter("## Some text").convert(), "<h2>Some text</h2>");
    }

    @Test
    public void HeaderTwoLeadingWhiteSpaceUnitTest() {

        final String markdown = " ## Some text";

        assertEquals(new MarkdownToHtmlConverter(markdown).convert(), markdown);
    }

    @Test
    public void HeaderTwoNoWhiteSpaceBetweenDashAndTextUnitTest() {

        final String markdown = "##Some text";

        assertEquals(new MarkdownToHtmlConverter(markdown).convert(), markdown);
    }
}
