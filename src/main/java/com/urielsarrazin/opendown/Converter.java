package com.urielsarrazin.opendown;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {

    private String input;

    public Converter(String input) {
        this.input = input;
    }

    public String convert() {

        for (Mapper mapper : Mapper.values()) {

            final Pattern regex = mapper.getRegex();
            final Pattern replacement = mapper.getReplacement();
            final Matcher matcher = regex.matcher(input);

            if(matcher.find()) {
                return input.replaceAll(regex.pattern(), replacement.pattern());
            }
        }

        return input;
    }
}
