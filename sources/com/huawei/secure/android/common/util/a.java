package com.huawei.secure.android.common.util;

public class a {
    private int index = 0;
    private int mark = 0;
    private String q;
    private Character r;
    private Character s;

    public a(String str) {
        this.q = str;
    }

    public void a(Character ch) {
        this.r = ch;
    }

    public int a() {
        return this.index;
    }

    public boolean hasNext() {
        if (this.r != null) {
            return true;
        }
        String str = this.q;
        if (str == null || str.length() == 0 || this.index >= this.q.length()) {
            return false;
        }
        return true;
    }

    public Character b() {
        Character ch = this.r;
        if (ch != null) {
            this.r = null;
            return ch;
        }
        String str = this.q;
        if (str == null || str.length() == 0 || this.index >= this.q.length()) {
            return null;
        }
        String str2 = this.q;
        int i = this.index;
        this.index = i + 1;
        return Character.valueOf(str2.charAt(i));
    }

    public Character c() {
        Character b = b();
        if (b != null && b(b)) {
            return b;
        }
        return null;
    }

    public Character d() {
        Character b = b();
        if (b != null && c(b)) {
            return b;
        }
        return null;
    }

    public static boolean b(Character ch) {
        if (ch == null) {
            return false;
        }
        char charValue = ch.charValue();
        return (charValue >= '0' && charValue <= '9') || (charValue >= 'a' && charValue <= 'f') || (charValue >= 'A' && charValue <= 'F');
    }

    public static boolean c(Character ch) {
        char charValue;
        return ch != null && (charValue = ch.charValue()) >= '0' && charValue <= '7';
    }

    public Character e() {
        Character ch = this.r;
        if (ch != null) {
            return ch;
        }
        String str = this.q;
        if (str == null || str.length() == 0 || this.index >= this.q.length()) {
            return null;
        }
        return Character.valueOf(this.q.charAt(this.index));
    }

    public boolean c(char c) {
        Character ch = this.r;
        if (ch != null && ch.charValue() == c) {
            return true;
        }
        String str = this.q;
        if (str != null && str.length() != 0 && this.index < this.q.length() && this.q.charAt(this.index) == c) {
            return true;
        }
        return false;
    }

    public void f() {
        this.s = this.r;
        this.mark = this.index;
    }

    public void reset() {
        this.r = this.s;
        this.index = this.mark;
    }

    protected String g() {
        String substring = this.q.substring(this.index);
        if (this.r == null) {
            return substring;
        }
        return this.r + substring;
    }
}
