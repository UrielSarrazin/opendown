package com.urielsarrazin.opendown;

import java.util.regex.Pattern;

public enum Mapper {

    HEADER_ONE(
            Pattern.compile("(^#\\s)(\\S.*\\S)(\\s?)"),
            Pattern.compile("<h1>$2</h1>")
    ),
    HEADER_TWO(
            Pattern.compile("(^#{2}\\s)(\\S.*\\S)(\\s?)"),
            Pattern.compile("<h2>$2</h2>")
    ),
    HEADER_THREE(
            Pattern.compile("(\\s{0,3}#{3}\\s?)(\\S.*\\S)(\\s?)"),
            Pattern.compile("<h3>$1</h3>")
    ),
    HEADER_FOUR(
            Pattern.compile("(\\s{0,3}#{4}\\s?)(\\S.*\\S)(\\s?)"),
            Pattern.compile("<h4>$1</h4>")
    ),
    HEADER_FIVE(
            Pattern.compile("(\\s{0,3}#{5}\\s?)(\\S.*\\S)(\\s?)"),
            Pattern.compile("<h5>$1</h5>")
    ),
    HEADER_SIX(
            Pattern.compile("(\\s{0,3}#{6}\\s?)(\\S.*\\S)(\\s?)"),
            Pattern.compile("<h6>$1</h6>")
    ),
    EMPHASIS(
            Pattern.compile("(^|[^*])\\*([^*]+)\\*($|.*?)"),
            Pattern.compile("$1<em>$2</em>$3")
    ),
    STRONG(
            Pattern.compile("(^|.*?)\\*{2}([^*]+)\\*{2}($|.*?)"),
            Pattern.compile("$1<strong>$2</strong>$3")
    ),
    THEMATIC_BREAK(
            Pattern.compile("\\*{3}"),
            Pattern.compile("<hr/>")
    );

    private Pattern replacement;

    private Pattern regex;

    Mapper(Pattern regex, Pattern replacement) {
        this.regex = regex;
        this.replacement = replacement;
    }

    public Pattern getReplacement() {
        return replacement;
    }

    public Pattern getRegex() {
        return regex;
    }
}
