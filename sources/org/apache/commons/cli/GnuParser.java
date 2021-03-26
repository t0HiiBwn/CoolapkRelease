package org.apache.commons.cli;

import java.util.ArrayList;

public class GnuParser extends Parser {
    @Override // org.apache.commons.cli.Parser
    protected String[] flatten(Options options, String[] strArr, boolean z) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z2 = false;
        while (i < strArr.length) {
            String str = strArr[i];
            if ("--".equals(str)) {
                arrayList.add("--");
                z2 = true;
            } else if ("-".equals(str)) {
                arrayList.add("-");
            } else if (str.startsWith("-")) {
                String stripLeadingHyphens = Util.stripLeadingHyphens(str);
                if (options.hasOption(stripLeadingHyphens)) {
                    arrayList.add(str);
                } else if (stripLeadingHyphens.indexOf(61) != -1 && options.hasOption(stripLeadingHyphens.substring(0, stripLeadingHyphens.indexOf(61)))) {
                    arrayList.add(str.substring(0, str.indexOf(61)));
                    arrayList.add(str.substring(str.indexOf(61) + 1));
                } else if (options.hasOption(str.substring(0, 2))) {
                    arrayList.add(str.substring(0, 2));
                    arrayList.add(str.substring(2));
                } else {
                    arrayList.add(str);
                    z2 = z;
                }
            } else {
                arrayList.add(str);
            }
            if (z2) {
                while (true) {
                    i++;
                    if (i >= strArr.length) {
                        break;
                    }
                    arrayList.add(strArr[i]);
                }
            }
            i++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
