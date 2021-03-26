package org.apache.commons.cli;

public class BasicParser extends Parser {
    @Override // org.apache.commons.cli.Parser
    protected String[] flatten(Options options, String[] strArr, boolean z) {
        return strArr;
    }
}
