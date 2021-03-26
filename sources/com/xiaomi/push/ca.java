package com.xiaomi.push;

import com.xiaomi.push.ce;

public class ca extends ce.d {
    protected String a = "MessageDeleteJob";

    public ca(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.a = str3;
    }

    public static ca a(String str) {
        return new ca(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }
}
