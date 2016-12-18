package com.urielsarrazin.opendown;

import java.util.Arrays;
import java.util.List;

public enum MarkdownHtmlMapper {

    H1(
            "<h1>",
            "</h1>",
            "# ",
            "# .*"
    ),
    H2(
            "<h2>",
            "</h2>",
            "## ",
            "## .*"
    ),
    H3(
            "<h3>",
            "</h3>",
            "### ",
            "### .*"
    ),
    H4(
            "<h4>",
            "</h4>",
            "#### ",
            "#### .*"
    ),H5(
            "<h5>",
            "</h5>",
            "##### ",
            "##### .*"
    ),
    H6(
            "<h6>",
            "</h6>",
            "####### ",
            "####### .*"
    );

    private String htmlOpenningTagEquivalent;

    private String htmlClosingTagEquivalent;

    private String charactersToRemove;

    private List<String> regex;

    MarkdownHtmlMapper(String htmlOpenningTagEquivalent, String htmlClosingTagEquivalent, String charactersToRemove, String ... regex) {
        this.htmlOpenningTagEquivalent = htmlOpenningTagEquivalent;
        this.htmlClosingTagEquivalent = htmlClosingTagEquivalent;
        this.charactersToRemove = charactersToRemove;
        this.regex = Arrays.asList(regex);
    }

    public String getHtmlOpenningTagEquivalent() {
        return htmlOpenningTagEquivalent;
    }

    public String getHtmlClosingTagEquivalent() {
        return htmlClosingTagEquivalent;
    }

    public String getCharactersToRemove() {
        return charactersToRemove;
    }

    public List<String> getRegex() {
        return regex;
    }
}
