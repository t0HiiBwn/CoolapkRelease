package org.apache.commons.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

public abstract class Parser implements CommandLineParser {
    protected CommandLine cmd;
    private Options options;
    private List requiredOptions;

    protected abstract String[] flatten(Options options2, String[] strArr, boolean z);

    protected void setOptions(Options options2) {
        this.options = options2;
        this.requiredOptions = new ArrayList(options2.getRequiredOptions());
    }

    protected Options getOptions() {
        return this.options;
    }

    protected List getRequiredOptions() {
        return this.requiredOptions;
    }

    @Override // org.apache.commons.cli.CommandLineParser
    public CommandLine parse(Options options2, String[] strArr) throws ParseException {
        return parse(options2, strArr, null, false);
    }

    public CommandLine parse(Options options2, String[] strArr, Properties properties) throws ParseException {
        return parse(options2, strArr, properties, false);
    }

    @Override // org.apache.commons.cli.CommandLineParser
    public CommandLine parse(Options options2, String[] strArr, boolean z) throws ParseException {
        return parse(options2, strArr, null, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0080, code lost:
        if (r9 != false) goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085 A[LOOP:2: B:27:0x0085->B:39:0x0085, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0037 A[SYNTHETIC] */
    public CommandLine parse(Options options2, String[] strArr, Properties properties, boolean z) throws ParseException {
        for (Option option : options2.helpOptions()) {
            option.clearValues();
        }
        setOptions(options2);
        this.cmd = new CommandLine();
        boolean z2 = false;
        if (strArr == null) {
            strArr = new String[0];
        }
        ListIterator listIterator = Arrays.asList(flatten(getOptions(), strArr, z)).listIterator();
        while (listIterator.hasNext()) {
            String str = (String) listIterator.next();
            if (!"--".equals(str)) {
                if ("-".equals(str)) {
                    if (!z) {
                        this.cmd.addArg(str);
                        if (z2) {
                            while (listIterator.hasNext()) {
                                String str2 = (String) listIterator.next();
                                if (!"--".equals(str2)) {
                                    this.cmd.addArg(str2);
                                }
                            }
                        }
                    }
                } else if (!str.startsWith("-")) {
                    this.cmd.addArg(str);
                } else if (!z || getOptions().hasOption(str)) {
                    processOption(str, listIterator);
                    if (z2) {
                    }
                } else {
                    this.cmd.addArg(str);
                }
            }
            z2 = true;
            if (z2) {
            }
        }
        processProperties(properties);
        checkRequiredOptions();
        return this.cmd;
    }

    protected void processProperties(Properties properties) {
        if (properties != null) {
            Enumeration<?> propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String obj = propertyNames.nextElement().toString();
                if (!this.cmd.hasOption(obj)) {
                    Option option = getOptions().getOption(obj);
                    String property = properties.getProperty(obj);
                    if (option.hasArg()) {
                        if (option.getValues() == null || option.getValues().length == 0) {
                            try {
                                option.addValueForProcessing(property);
                            } catch (RuntimeException unused) {
                            }
                        }
                    } else if (!"yes".equalsIgnoreCase(property) && !"true".equalsIgnoreCase(property) && !"1".equalsIgnoreCase(property)) {
                        return;
                    }
                    this.cmd.addOption(option);
                }
            }
        }
    }

    protected void checkRequiredOptions() throws MissingOptionException {
        if (!getRequiredOptions().isEmpty()) {
            throw new MissingOptionException(getRequiredOptions());
        }
    }

    public void processArgs(Option option, ListIterator listIterator) throws ParseException {
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            String str = (String) listIterator.next();
            if (getOptions().hasOption(str) && str.startsWith("-")) {
                listIterator.previous();
                break;
            } else {
                try {
                    option.addValueForProcessing(Util.stripLeadingAndTrailingQuotes(str));
                } catch (RuntimeException unused) {
                    listIterator.previous();
                }
            }
        }
        if (option.getValues() == null && !option.hasOptionalArg()) {
            throw new MissingArgumentException(option);
        }
    }

    protected void processOption(String str, ListIterator listIterator) throws ParseException {
        if (getOptions().hasOption(str)) {
            Option option = (Option) getOptions().getOption(str).clone();
            if (option.isRequired()) {
                getRequiredOptions().remove(option.getKey());
            }
            if (getOptions().getOptionGroup(option) != null) {
                OptionGroup optionGroup = getOptions().getOptionGroup(option);
                if (optionGroup.isRequired()) {
                    getRequiredOptions().remove(optionGroup);
                }
                optionGroup.setSelected(option);
            }
            if (option.hasArg()) {
                processArgs(option, listIterator);
            }
            this.cmd.addOption(option);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unrecognized option: ");
        stringBuffer.append(str);
        throw new UnrecognizedOptionException(stringBuffer.toString(), str);
    }
}
