package org.apache.commons.cli;

public class AlreadySelectedException extends ParseException {

    /* renamed from: group  reason: collision with root package name */
    private OptionGroup f1513group;
    private Option option;

    public AlreadySelectedException(String str) {
        super(str);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public AlreadySelectedException(OptionGroup optionGroup, Option option2) {
        this(r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The option '");
        stringBuffer.append(option2.getKey());
        stringBuffer.append("' was specified but an option from this group ");
        stringBuffer.append("has already been selected: '");
        stringBuffer.append(optionGroup.getSelected());
        stringBuffer.append("'");
        this.f1513group = optionGroup;
        this.option = option2;
    }

    public OptionGroup getOptionGroup() {
        return this.f1513group;
    }

    public Option getOption() {
        return this.option;
    }
}
