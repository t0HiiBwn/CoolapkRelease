package org.apache.commons.cli;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class HelpFormatter {
    public static final String DEFAULT_ARG_NAME = "arg";
    public static final int DEFAULT_DESC_PAD = 3;
    public static final int DEFAULT_LEFT_PAD = 1;
    public static final String DEFAULT_LONG_OPT_PREFIX = "--";
    public static final String DEFAULT_OPT_PREFIX = "-";
    public static final String DEFAULT_SYNTAX_PREFIX = "usage: ";
    public static final int DEFAULT_WIDTH = 74;
    public String defaultArgName = "arg";
    public int defaultDescPad = 3;
    public int defaultLeftPad = 1;
    public String defaultLongOptPrefix = "--";
    public String defaultNewLine = System.getProperty("line.separator");
    public String defaultOptPrefix = "-";
    public String defaultSyntaxPrefix = "usage: ";
    public int defaultWidth = 74;
    protected Comparator optionComparator = new OptionComparator();

    public void setWidth(int i) {
        this.defaultWidth = i;
    }

    public int getWidth() {
        return this.defaultWidth;
    }

    public void setLeftPadding(int i) {
        this.defaultLeftPad = i;
    }

    public int getLeftPadding() {
        return this.defaultLeftPad;
    }

    public void setDescPadding(int i) {
        this.defaultDescPad = i;
    }

    public int getDescPadding() {
        return this.defaultDescPad;
    }

    public void setSyntaxPrefix(String str) {
        this.defaultSyntaxPrefix = str;
    }

    public String getSyntaxPrefix() {
        return this.defaultSyntaxPrefix;
    }

    public void setNewLine(String str) {
        this.defaultNewLine = str;
    }

    public String getNewLine() {
        return this.defaultNewLine;
    }

    public void setOptPrefix(String str) {
        this.defaultOptPrefix = str;
    }

    public String getOptPrefix() {
        return this.defaultOptPrefix;
    }

    public void setLongOptPrefix(String str) {
        this.defaultLongOptPrefix = str;
    }

    public String getLongOptPrefix() {
        return this.defaultLongOptPrefix;
    }

    public void setArgName(String str) {
        this.defaultArgName = str;
    }

    public String getArgName() {
        return this.defaultArgName;
    }

    public Comparator getOptionComparator() {
        return this.optionComparator;
    }

    public void setOptionComparator(Comparator comparator) {
        if (comparator == null) {
            this.optionComparator = new OptionComparator();
        } else {
            this.optionComparator = comparator;
        }
    }

    public void printHelp(String str, Options options) {
        printHelp(this.defaultWidth, str, null, options, null, false);
    }

    public void printHelp(String str, Options options, boolean z) {
        printHelp(this.defaultWidth, str, null, options, null, z);
    }

    public void printHelp(String str, String str2, Options options, String str3) {
        printHelp(str, str2, options, str3, false);
    }

    public void printHelp(String str, String str2, Options options, String str3, boolean z) {
        printHelp(this.defaultWidth, str, str2, options, str3, z);
    }

    public void printHelp(int i, String str, String str2, Options options, String str3) {
        printHelp(i, str, str2, options, str3, false);
    }

    public void printHelp(int i, String str, String str2, Options options, String str3, boolean z) {
        PrintWriter printWriter = new PrintWriter(System.out);
        printHelp(printWriter, i, str, str2, options, this.defaultLeftPad, this.defaultDescPad, str3, z);
        printWriter.flush();
    }

    public void printHelp(PrintWriter printWriter, int i, String str, String str2, Options options, int i2, int i3, String str3) {
        printHelp(printWriter, i, str, str2, options, i2, i3, str3, false);
    }

    public void printHelp(PrintWriter printWriter, int i, String str, String str2, Options options, int i2, int i3, String str3, boolean z) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("cmdLineSyntax not provided");
        }
        if (z) {
            printUsage(printWriter, i, str, options);
        } else {
            printUsage(printWriter, i, str);
        }
        if (str2 != null && str2.trim().length() > 0) {
            printWrapped(printWriter, i, str2);
        }
        printOptions(printWriter, i, options, i2, i3);
        if (str3 != null && str3.trim().length() > 0) {
            printWrapped(printWriter, i, str3);
        }
    }

    public void printUsage(PrintWriter printWriter, int i, String str, Options options) {
        StringBuffer stringBuffer = new StringBuffer(this.defaultSyntaxPrefix);
        stringBuffer.append(str);
        stringBuffer.append(" ");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(options.getOptions());
        Collections.sort(arrayList2, getOptionComparator());
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Option option = (Option) it2.next();
            OptionGroup optionGroup = options.getOptionGroup(option);
            if (optionGroup == null) {
                appendOption(stringBuffer, option, option.isRequired());
            } else if (!arrayList.contains(optionGroup)) {
                arrayList.add(optionGroup);
                appendOptionGroup(stringBuffer, optionGroup);
            }
            if (it2.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        printWrapped(printWriter, i, stringBuffer.toString().indexOf(32) + 1, stringBuffer.toString());
    }

    private void appendOptionGroup(StringBuffer stringBuffer, OptionGroup optionGroup) {
        if (!optionGroup.isRequired()) {
            stringBuffer.append("[");
        }
        ArrayList arrayList = new ArrayList(optionGroup.getOptions());
        Collections.sort(arrayList, getOptionComparator());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            appendOption(stringBuffer, (Option) it2.next(), true);
            if (it2.hasNext()) {
                stringBuffer.append(" | ");
            }
        }
        if (!optionGroup.isRequired()) {
            stringBuffer.append("]");
        }
    }

    private static void appendOption(StringBuffer stringBuffer, Option option, boolean z) {
        if (!z) {
            stringBuffer.append("[");
        }
        if (option.getOpt() != null) {
            stringBuffer.append("-");
            stringBuffer.append(option.getOpt());
        } else {
            stringBuffer.append("--");
            stringBuffer.append(option.getLongOpt());
        }
        if (option.hasArg() && option.hasArgName()) {
            stringBuffer.append(" <");
            stringBuffer.append(option.getArgName());
            stringBuffer.append(">");
        }
        if (!z) {
            stringBuffer.append("]");
        }
    }

    public void printUsage(PrintWriter printWriter, int i, String str) {
        int length = this.defaultSyntaxPrefix.length() + str.indexOf(32) + 1;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.defaultSyntaxPrefix);
        stringBuffer.append(str);
        printWrapped(printWriter, i, length, stringBuffer.toString());
    }

    public void printOptions(PrintWriter printWriter, int i, Options options, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        renderOptions(stringBuffer, i, options, i2, i3);
        printWriter.println(stringBuffer.toString());
    }

    public void printWrapped(PrintWriter printWriter, int i, String str) {
        printWrapped(printWriter, i, 0, str);
    }

    public void printWrapped(PrintWriter printWriter, int i, int i2, String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        renderWrappedText(stringBuffer, i, i2, str);
        printWriter.println(stringBuffer.toString());
    }

    protected StringBuffer renderOptions(StringBuffer stringBuffer, int i, Options options, int i2, int i3) {
        String createPadding = createPadding(i2);
        String createPadding2 = createPadding(i3);
        ArrayList arrayList = new ArrayList();
        List<Option> helpOptions = options.helpOptions();
        Collections.sort(helpOptions, getOptionComparator());
        int i4 = 0;
        int i5 = 0;
        for (Option option : helpOptions) {
            StringBuffer stringBuffer2 = new StringBuffer(8);
            if (option.getOpt() == null) {
                stringBuffer2.append(createPadding);
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("   ");
                stringBuffer3.append(this.defaultLongOptPrefix);
                stringBuffer2.append(stringBuffer3.toString());
                stringBuffer2.append(option.getLongOpt());
            } else {
                stringBuffer2.append(createPadding);
                stringBuffer2.append(this.defaultOptPrefix);
                stringBuffer2.append(option.getOpt());
                if (option.hasLongOpt()) {
                    stringBuffer2.append(',');
                    stringBuffer2.append(this.defaultLongOptPrefix);
                    stringBuffer2.append(option.getLongOpt());
                }
            }
            if (option.hasArg()) {
                if (option.hasArgName()) {
                    stringBuffer2.append(" <");
                    stringBuffer2.append(option.getArgName());
                    stringBuffer2.append(">");
                } else {
                    stringBuffer2.append(' ');
                }
            }
            arrayList.add(stringBuffer2);
            if (stringBuffer2.length() > i5) {
                i5 = stringBuffer2.length();
            }
        }
        Iterator it2 = helpOptions.iterator();
        while (it2.hasNext()) {
            Option option2 = (Option) it2.next();
            int i6 = i4 + 1;
            StringBuffer stringBuffer4 = new StringBuffer(arrayList.get(i4).toString());
            if (stringBuffer4.length() < i5) {
                stringBuffer4.append(createPadding(i5 - stringBuffer4.length()));
            }
            stringBuffer4.append(createPadding2);
            int i7 = i5 + i3;
            if (option2.getDescription() != null) {
                stringBuffer4.append(option2.getDescription());
            }
            renderWrappedText(stringBuffer, i, i7, stringBuffer4.toString());
            if (it2.hasNext()) {
                stringBuffer.append(this.defaultNewLine);
            }
            i4 = i6;
        }
        return stringBuffer;
    }

    protected StringBuffer renderWrappedText(StringBuffer stringBuffer, int i, int i2, String str) {
        int findWrapPos = findWrapPos(str, i, 0);
        if (findWrapPos == -1) {
            stringBuffer.append(rtrim(str));
            return stringBuffer;
        }
        stringBuffer.append(rtrim(str.substring(0, findWrapPos)));
        stringBuffer.append(this.defaultNewLine);
        if (i2 >= i) {
            i2 = 1;
        }
        String createPadding = createPadding(i2);
        while (true) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(createPadding);
            stringBuffer2.append(str.substring(findWrapPos).trim());
            str = stringBuffer2.toString();
            findWrapPos = findWrapPos(str, i, 0);
            if (findWrapPos == -1) {
                stringBuffer.append(str);
                return stringBuffer;
            }
            if (str.length() > i && findWrapPos == i2 - 1) {
                findWrapPos = i;
            }
            stringBuffer.append(rtrim(str.substring(0, findWrapPos)));
            stringBuffer.append(this.defaultNewLine);
        }
    }

    protected int findWrapPos(String str, int i, int i2) {
        int indexOf = str.indexOf(10, i2);
        if ((indexOf != -1 && indexOf <= i) || ((indexOf = str.indexOf(9, i2)) != -1 && indexOf <= i)) {
            return indexOf + 1;
        }
        int i3 = i + i2;
        if (i3 >= str.length()) {
            return -1;
        }
        int i4 = i3;
        while (i4 >= i2 && (r5 = str.charAt(i4)) != ' ' && r5 != '\n' && r5 != '\r') {
            i4--;
        }
        if (i4 > i2) {
            return i4;
        }
        while (i3 <= str.length() && (r9 = str.charAt(i3)) != ' ' && r9 != '\n' && r9 != '\r') {
            i3++;
        }
        if (i3 == str.length()) {
            return -1;
        }
        return i3;
    }

    protected String createPadding(int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    protected String rtrim(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return str.substring(0, length);
    }

    private static class OptionComparator implements Comparator {
        private OptionComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Option) obj).getKey().compareToIgnoreCase(((Option) obj2).getKey());
        }
    }
}
