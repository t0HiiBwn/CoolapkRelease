package com.kepler.sdk;

import java.io.File;

public class m {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g = "utf-8";
    public File h;

    public m() {
    }

    public m(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof m)) {
            return super.equals(obj);
        }
        m mVar = (m) obj;
        return af.b(mVar.c, this.c) && af.b(mVar.d, this.d) && af.b(mVar.e, this.e);
    }

    public void a() {
        File file = this.h;
        if (file != null) {
            y.b(file);
        }
    }

    public String b() {
        return this.c;
    }

    public boolean a(File file) {
        String str;
        boolean z = true;
        if (this.h == null) {
            File file2 = new File(file, b());
            str = y.a(file2);
            if (str.equalsIgnoreCase(this.c)) {
                this.h = file2;
            } else {
                y.b(file2);
                z = false;
            }
        } else {
            str = null;
        }
        j.b("suwg", "check fname:  " + b() + " " + str + " " + z);
        return z;
    }

    public boolean b(File file) {
        String str;
        boolean z = false;
        if (file == null) {
            str = null;
        } else {
            String a2 = y.a(file);
            if (a2.equalsIgnoreCase(this.c)) {
                this.h = file;
                z = true;
            } else {
                y.b(file);
            }
            str = a2;
        }
        j.b("suwg", "checkLoadFile  fname:  " + b() + " " + str + " " + z);
        return z;
    }
}
