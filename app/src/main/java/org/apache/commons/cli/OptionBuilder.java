package org.apache.commons.cli;

public final class OptionBuilder {
    private static String argName = null;
    private static String description = null;
    private static OptionBuilder instance = new OptionBuilder();
    private static String longopt = null;
    private static int numberOfArgs = -1;
    private static boolean optionalArg;
    private static boolean required;
    private static Object type;
    private static char valuesep;

    private OptionBuilder() {
    }

    private static void reset() {
        description = null;
        argName = "arg";
        longopt = null;
        type = null;
        required = false;
        numberOfArgs = -1;
        optionalArg = false;
        valuesep = 0;
    }

    public static OptionBuilder withLongOpt(String str) {
        longopt = str;
        return instance;
    }

    public static OptionBuilder hasArg() {
        numberOfArgs = 1;
        return instance;
    }

    public static OptionBuilder hasArg(boolean z) {
        numberOfArgs = z ? 1 : -1;
        return instance;
    }

    public static OptionBuilder withArgName(String str) {
        argName = str;
        return instance;
    }

    public static OptionBuilder isRequired() {
        required = true;
        return instance;
    }

    public static OptionBuilder withValueSeparator(char c) {
        valuesep = c;
        return instance;
    }

    public static OptionBuilder withValueSeparator() {
        valuesep = '=';
        return instance;
    }

    public static OptionBuilder isRequired(boolean z) {
        required = z;
        return instance;
    }

    public static OptionBuilder hasArgs() {
        numberOfArgs = -2;
        return instance;
    }

    public static OptionBuilder hasArgs(int i) {
        numberOfArgs = i;
        return instance;
    }

    public static OptionBuilder hasOptionalArg() {
        numberOfArgs = 1;
        optionalArg = true;
        return instance;
    }

    public static OptionBuilder hasOptionalArgs() {
        numberOfArgs = -2;
        optionalArg = true;
        return instance;
    }

    public static OptionBuilder hasOptionalArgs(int i) {
        numberOfArgs = i;
        optionalArg = true;
        return instance;
    }

    public static OptionBuilder withType(Object obj) {
        type = obj;
        return instance;
    }

    public static OptionBuilder withDescription(String str) {
        description = str;
        return instance;
    }

    public static Option create(char c) throws IllegalArgumentException {
        return create(String.valueOf(c));
    }

    public static Option create() throws IllegalArgumentException {
        if (longopt != null) {
            return create((String) null);
        }
        reset();
        throw new IllegalArgumentException("must specify longopt");
    }

    public static Option create(String str) throws IllegalArgumentException {
        try {
            Option option = new Option(str, description);
            option.setLongOpt(longopt);
            option.setRequired(required);
            option.setOptionalArg(optionalArg);
            option.setArgs(numberOfArgs);
            option.setType(type);
            option.setValueSeparator(valuesep);
            option.setArgName(argName);
            return option;
        } finally {
            reset();
        }
    }
}
