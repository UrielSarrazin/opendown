package com.urielsarrazin.opendown;

import java.util.ArrayList;
import java.util.List;

import static com.urielsarrazin.opendown.Properties.CARRIAGE_RETURN;

public class MarkdownToHtmlConverter {

    private String markdown;

    private String[] markdownSplits;

    private List<String> convertedSplits = new ArrayList<String>();

    private StringBuilder htmlContent = new StringBuilder();

    public MarkdownToHtmlConverter(String markdown) {
        this.markdown = markdown;
    }

    public String convert() {

        splitInput();

        convertSplits();

        createHtmlContent();

        return htmlContent.toString();
    }

    private void convertSplits() {
        for (String markdownSplit : markdownSplits) {
            convertedSplits.add(new SimpleConverter(markdownSplit).convert());
        }
    }

    private void splitInput() {
        markdownSplits = markdown.split(CARRIAGE_RETURN);
    }

    private void createHtmlContent() {

        htmlContent
                .append("<html>")
                .append(CARRIAGE_RETURN);

        for (String convertedSplit : convertedSplits) {
            htmlContent
                    .append(convertedSplit)
                    .append(CARRIAGE_RETURN);
        }

        htmlContent.append("</html>");

    }


}
