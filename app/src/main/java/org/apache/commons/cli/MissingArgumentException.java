package org.apache.commons.cli;

public class MissingArgumentException extends ParseException {
    private Option option;

    public MissingArgumentException(String str) {
        super(str);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public MissingArgumentException(Option option2) {
        this(r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Missing argument for option: ");
        stringBuffer.append(option2.getKey());
        this.option = option2;
    }

    public Option getOption() {
        return this.option;
    }
}
