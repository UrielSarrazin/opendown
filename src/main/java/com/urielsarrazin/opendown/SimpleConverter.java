package com.urielsarrazin.opendown;

import java.util.regex.Pattern;

public class SimpleConverter {

    private String markdown;

    public SimpleConverter(String markdown) {
        this.markdown = markdown;
    }

    public String convert() {

        for (MarkdownHtmlMapper markHtmlMapper : MarkdownHtmlMapper.values()) {
            for (String markdownRegex : markHtmlMapper.getRegex()) {
                if(Pattern.matches(markdownRegex, markdown)) {
                    return new StringBuilder()
                            .append(markHtmlMapper.getHtmlOpenningTagEquivalent())
                            .append(markdown.replace(markHtmlMapper.getCharactersToRemove(), ""))
                            .append(markHtmlMapper.getHtmlClosingTagEquivalent())
                            .toString();
                }
            }
        }

        return markdown;
    }
}
