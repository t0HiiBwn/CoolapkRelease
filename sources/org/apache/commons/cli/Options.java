package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Options implements Serializable {
    private static final long serialVersionUID = 1;
    private Map longOpts = new HashMap();
    private Map optionGroups = new HashMap();
    private List requiredOpts = new ArrayList();
    private Map shortOpts = new HashMap();

    public Options addOptionGroup(OptionGroup optionGroup) {
        if (optionGroup.isRequired()) {
            this.requiredOpts.add(optionGroup);
        }
        for (Option option : optionGroup.getOptions()) {
            option.setRequired(false);
            addOption(option);
            this.optionGroups.put(option.getKey(), optionGroup);
        }
        return this;
    }

    Collection getOptionGroups() {
        return new HashSet(this.optionGroups.values());
    }

    public Options addOption(String str, boolean z, String str2) {
        addOption(str, null, z, str2);
        return this;
    }

    public Options addOption(String str, String str2, boolean z, String str3) {
        addOption(new Option(str, str2, z, str3));
        return this;
    }

    public Options addOption(Option option) {
        String key = option.getKey();
        if (option.hasLongOpt()) {
            this.longOpts.put(option.getLongOpt(), option);
        }
        if (option.isRequired()) {
            if (this.requiredOpts.contains(key)) {
                List list = this.requiredOpts;
                list.remove(list.indexOf(key));
            }
            this.requiredOpts.add(key);
        }
        this.shortOpts.put(key, option);
        return this;
    }

    public Collection getOptions() {
        return Collections.unmodifiableCollection(helpOptions());
    }

    List helpOptions() {
        return new ArrayList(this.shortOpts.values());
    }

    public List getRequiredOptions() {
        return this.requiredOpts;
    }

    public Option getOption(String str) {
        String stripLeadingHyphens = Util.stripLeadingHyphens(str);
        if (this.shortOpts.containsKey(stripLeadingHyphens)) {
            return (Option) this.shortOpts.get(stripLeadingHyphens);
        }
        return (Option) this.longOpts.get(stripLeadingHyphens);
    }

    public boolean hasOption(String str) {
        String stripLeadingHyphens = Util.stripLeadingHyphens(str);
        return this.shortOpts.containsKey(stripLeadingHyphens) || this.longOpts.containsKey(stripLeadingHyphens);
    }

    public OptionGroup getOptionGroup(Option option) {
        return (OptionGroup) this.optionGroups.get(option.getKey());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ Options: [ short ");
        stringBuffer.append(this.shortOpts.toString());
        stringBuffer.append(" ] [ long ");
        stringBuffer.append(this.longOpts);
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }
}
