package com.bytedance.sdk.a.b;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: MediaType */
public final class u {
    private static final Pattern a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    private u(String str, String str2, String str3, String str4) {
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public static u a(String str) {
        Matcher matcher = a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = b.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group2 = matcher2.group(1);
            if (group2 != null && group2.equalsIgnoreCase("charset")) {
                String group3 = matcher2.group(2);
                if (group3 == null) {
                    group3 = matcher2.group(3);
                } else if (group3.startsWith("'") && group3.endsWith("'") && group3.length() > 2) {
                    group3 = group3.substring(1, group3.length() - 1);
                }
                if (!(str2 == null || group3.equalsIgnoreCase(str2))) {
                    return null;
                }
                str2 = group3;
            }
        }
        return new u(str, lowerCase, lowerCase2, str2);
    }

    public Charset a() {
        return a((Charset) null);
    }

    public Charset a(Charset charset) {
        try {
            String str = this.f;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public String toString() {
        return this.c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && ((u) obj).c.equals(this.c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }
}
