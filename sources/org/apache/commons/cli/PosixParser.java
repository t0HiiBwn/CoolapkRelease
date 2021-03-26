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

    private void gobble(Iterator it2) {
        if (this.eatTheRest) {
            while (it2.hasNext()) {
                this.tokens.add(it2.next());
            }
        }
    }

    private void init() {
        this.eatTheRest = false;
        this.tokens.clear();
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

    @Override // org.apache.commons.cli.Parser
    protected String[] flatten(Options options2, String[] strArr, boolean z) {
        init();
        this.options = options2;
        Iterator it2 = Arrays.asList(strArr).iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (str.startsWith("--")) {
                int indexOf = str.indexOf(61);
                String substring = indexOf == -1 ? str : str.substring(0, indexOf);
                if (!options2.hasOption(substring)) {
                    processNonOptionToken(str, z);
                } else {
                    this.currentOption = options2.getOption(substring);
                    this.tokens.add(substring);
                    if (indexOf != -1) {
                        this.tokens.add(str.substring(indexOf + 1));
                    }
                }
            } else if ("-".equals(str)) {
                this.tokens.add(str);
            } else if (!str.startsWith("-")) {
                processNonOptionToken(str, z);
            } else if (str.length() == 2 || options2.hasOption(str)) {
                processOptionToken(str, z);
            } else {
                burstToken(str, z);
            }
            gobble(it2);
        }
        List list = this.tokens;
        return (String[]) list.toArray(new String[list.size()]);
    }
}
