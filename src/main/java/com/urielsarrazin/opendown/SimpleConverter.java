package com.urielsarrazin.opendown;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleConverter {

    private String input;

    public SimpleConverter(String input) {
        this.input = input;
    }

    public String convert() {

        List<Mapper> mappers = Arrays.asList(Mapper.values());

        Collections.sort(mappers, new Comparator<Mapper>() {
            public int compare(Mapper o1, Mapper o2) {
                return o1.getPriority() - o2.getPriority();
            }
        });

        for (Mapper mapper : mappers) {

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
