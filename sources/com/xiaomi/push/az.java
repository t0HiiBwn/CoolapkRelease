package com.xiaomi.push;

import com.xiaomi.push.be;

public class az extends be.d {
    protected String a = "MessageDeleteJob";

    public az(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.a = str3;
    }

    public static az a(String str) {
        return new az(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }
}
