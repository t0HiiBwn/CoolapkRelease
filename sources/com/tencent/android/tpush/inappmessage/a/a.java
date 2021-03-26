package com.tencent.android.tpush.inappmessage.a;

import java.util.Map;

/* compiled from: ProGuard */
public class a extends b {
    private final String d;

    public a(String str, Map<Object, Object> map, String str2) {
        this(str, map, str2, null);
    }

    public a(String str, Map<Object, Object> map, String str2, String str3) {
        super(str2, str3);
        this.d = str;
        this.c = map;
    }

    public String a(int i) {
        return (String) (this.c.get(Integer.valueOf(i)) != null ? this.c.get(Integer.valueOf(i)) : "");
    }

    public int a() {
        return ((Integer) (this.c.get("Layout.Width") != null ? this.c.get("Layout.Width") : 0)).intValue();
    }

    public int b() {
        return ((Integer) (this.c.get("Layout.Height") != null ? this.c.get("Layout.Height") : 0)).intValue();
    }

    public String c() {
        return (String) (this.c.get("Background color") != null ? this.c.get("Background color") : "");
    }

    public String d() {
        return (String) (this.c.get("Background image url") != null ? this.c.get("Background image url") : "");
    }

    public String e() {
        return (String) (this.c.get("Background action") != null ? this.c.get("Background action") : "");
    }

    public int f() {
        return ((Integer) (this.c.get("Background corner") == null ? 0 : this.c.get("Background corner"))).intValue();
    }

    public String g() {
        return (String) (this.c.get("Media url") != null ? this.c.get("Media url") : "");
    }

    public int h() {
        return ((Integer) (this.c.get("Media width") != null ? this.c.get("Media width") : 0)).intValue();
    }

    public int i() {
        return ((Integer) (this.c.get("Media heigh") != null ? this.c.get("Media heigh") : 0)).intValue();
    }

    public int j() {
        return ((Integer) (this.c.get("Close button") != null ? this.c.get("Close button") : 1)).intValue();
    }

    public int k() {
        return ((Integer) (this.c.get("Accept button.count") != null ? this.c.get("Accept button.count") : 0)).intValue();
    }

    public String l() {
        return (String) (this.c.get("Accept button.Text") != null ? this.c.get("Accept button.Text") : "");
    }

    public String m() {
        return (String) (this.c.get("Accept button.Background color") != null ? this.c.get("Accept button.Background color") : "");
    }

    public String n() {
        return (String) (this.c.get("Accept button.Text color") != null ? this.c.get("Accept button.Text color") : "");
    }

    public int o() {
        return ((Integer) (this.c.get("Accept button.corner") != null ? this.c.get("Accept button.corner") : 0)).intValue();
    }

    public String p() {
        return (String) (this.c.get("Accept button.action") != null ? this.c.get("Accept button.action") : "");
    }

    public int q() {
        return ((Integer) (this.c.get("Accept button.action.type") != null ? this.c.get("Accept button.action.type") : 0)).intValue();
    }

    public int r() {
        return ((Integer) (this.c.get("Accept button.id") != null ? this.c.get("Accept button.id") : 0)).intValue();
    }

    public int s() {
        return ((Integer) (this.c.get("Accept button.Text size") != null ? this.c.get("Accept button.Text size") : 0)).intValue();
    }

    public String t() {
        return (String) (this.c.get("Accept sec button.Text") != null ? this.c.get("Accept sec button.Text") : "");
    }

    public String u() {
        return (String) (this.c.get("Accept sec button.Background color") != null ? this.c.get("Accept sec button.Background color") : "");
    }

    public String v() {
        return (String) (this.c.get("Accept sec button.Text color") != null ? this.c.get("Accept sec button.Text color") : "");
    }

    public int w() {
        return ((Integer) (this.c.get("Accept sec button.corner") != null ? this.c.get("Accept sec button.corner") : 0)).intValue();
    }

    public String x() {
        return (String) (this.c.get("Accept sec button.action") != null ? this.c.get("Accept sec button.action") : "");
    }

    public int y() {
        return ((Integer) (this.c.get("Accept sec button.action.type") != null ? this.c.get("Accept sec button.action.type") : 0)).intValue();
    }

    public int z() {
        return ((Integer) (this.c.get("Accept sec button.id") != null ? this.c.get("Accept sec button.id") : 0)).intValue();
    }

    public int A() {
        return ((Integer) (this.c.get("Accept sec button.Text size") != null ? this.c.get("Accept sec button.Text size") : 0)).intValue();
    }

    public int B() {
        return ((Integer) (this.c.get("Title.Typeface") != null ? this.c.get("Title.Typeface") : 0)).intValue();
    }

    public int C() {
        return ((Integer) (this.c.get("Title.Size") != null ? this.c.get("Title.Size") : 0)).intValue();
    }

    public String D() {
        return (String) (this.c.get("Title.Color") != null ? this.c.get("Title.Color") : "");
    }

    public String E() {
        return (String) (this.c.get("Title.Text") != null ? this.c.get("Title.Text") : "");
    }

    public int F() {
        return ((Integer) (this.c.get("Title.Align") != null ? this.c.get("Title.Align") : 0)).intValue();
    }

    public int G() {
        return ((Integer) (this.c.get("Message.Size") != null ? this.c.get("Message.Size") : 0)).intValue();
    }

    public String H() {
        return (String) (this.c.get("Message.Color") != null ? this.c.get("Message.Color") : "");
    }

    public String I() {
        return (String) (this.c.get("Message.Text") != null ? this.c.get("Message.Text") : "");
    }

    public int J() {
        return ((Integer) (this.c.get("Message.Align") != null ? this.c.get("Message.Align") : 0)).intValue();
    }

    public int K() {
        return ((Integer) (this.c.get("Message.Typeface") != null ? this.c.get("Message.Typeface") : 0)).intValue();
    }
}
