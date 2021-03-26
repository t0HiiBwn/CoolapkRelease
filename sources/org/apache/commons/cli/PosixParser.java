package org.apache.commons.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PosixParser extends Parser {
    private Option currentOption;
    private boolean eatTheRest;
    private Options options;
    private List tokens = new ArrayList();

    private void init() {
        this.eatTheRest = false;
        this.tokens.clear();
    }

    @Override // org.apache.commons.cli.Parser
    protected String[] flatten(Options options2, String[] strArr, boolean z) {
        String str;
        init();
        this.options = options2;
        Iterator it2 = Arrays.asList(strArr).iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (str2.startsWith("--")) {
                int indexOf = str2.indexOf(61);
                if (indexOf == -1) {
                    str = str2;
                } else {
                    str = str2.substring(0, indexOf);
                }
                if (!options2.hasOption(str)) {
                    processNonOptionToken(str2, z);
                } else {
                    this.currentOption = options2.getOption(str);
                    this.tokens.add(str);
                    if (indexOf != -1) {
                        this.tokens.add(str2.substring(indexOf + 1));
                    }
                }
            } else if ("-".equals(str2)) {
                this.tokens.add(str2);
            } else if (!str2.startsWith("-")) {
                processNonOptionToken(str2, z);
            } else if (str2.length() == 2 || options2.hasOption(str2)) {
                processOptionToken(str2, z);
            } else {
                burstToken(str2, z);
            }
            gobble(it2);
        }
        List list = this.tokens;
        return (String[]) list.toArray(new String[list.size()]);
    }

    private void gobble(Iterator it2) {
        if (this.eatTheRest) {
            while (it2.hasNext()) {
                this.tokens.add(it2.next());
            }
        }
    }

    private void processNonOptionToken(String str, boolean z) {
        Option option;
        if (z && ((option = this.currentOption) == null || !option.hasArg())) {
            this.eatTheRest = true;
            this.tokens.add("--");
        }
        this.tokens.add(str);
    }

    private void processOptionToken(String str, boolean z) {
        if (z && !this.options.hasOption(str)) {
            this.eatTheRest = true;
        }
        if (this.options.hasOption(str)) {
            this.currentOption = this.options.getOption(str);
        }
        this.tokens.add(str);
    }

    protected void burstToken(String str, boolean z) {
        int i;
        for (int i2 = 1; i2 < str.length(); i2++) {
            String valueOf = String.valueOf(str.charAt(i2));
            if (this.options.hasOption(valueOf)) {
                List list = this.tokens;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("-");
                stringBuffer.append(valueOf);
                list.add(stringBuffer.toString());
                Option option = this.options.getOption(valueOf);
                this.currentOption = option;
                if (option.hasArg() && str.length() != (i = i2 + 1)) {
                    this.tokens.add(str.substring(i));
                    return;
                }
            } else if (z) {
                processNonOptionToken(str.substring(i2), true);
                return;
            } else {
                this.tokens.add(str);
                return;
            }
        }
    }
}
