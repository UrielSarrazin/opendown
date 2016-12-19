package com.urielsarrazin.opendown;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public enum Mapper {

    H1(
            2,
            Pattern.compile("^#{1} (.*)"),
            Pattern.compile("<h1>$1</h1>")),
    H2(
            2,
            Pattern.compile("^#{2} (.*)"),
            Pattern.compile("<h2>$1</h2>")),
    H3(
            2,
            Pattern.compile("^#{3} (.*)"),
            Pattern.compile("<h3>$1</h3>")),
    H4(
            2,
            Pattern.compile("^#{4} (.*)"),
            Pattern.compile("<h4>$1</h4>")),
    H5(
            2,
            Pattern.compile("^#{5} (.*)"),
            Pattern.compile("<h5>$1</h5>")),
    H6(
            2,
            Pattern.compile("^#{6} (.*)"),
            Pattern.compile("<h6>$1</h6>")
    ),
    EMPHASIS(
            2,
            Pattern.compile("(^|.*?)\\*{1}([^*]+)\\*{1}($|.*?)"),
            Pattern.compile("$1<em>$2</em>$3")
    ),
    STRONG_EMPHASIS(
            1,
            Pattern.compile("(^|.*?)\\*{2}([^*]+)\\*{2}($|.*?)"),
            Pattern.compile("$1<strong>$2</strong>$3")
    );

    private Integer priority;

    private Pattern replacement;

    private Pattern regex;

    Mapper(Integer priority, Pattern regex, Pattern replacement) {
        this.priority = priority;
        this.regex = regex;
        this.replacement = replacement;
    }

    public Integer getPriority() {
        return priority;
    }

    public Pattern getReplacement() {
        return replacement;
    }

    public Pattern getRegex() {
        return regex;
    }
}
