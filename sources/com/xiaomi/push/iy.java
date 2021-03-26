package com.xiaomi.push;

import android.content.SharedPreferences;

class iy implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ ix d;

    iy(ix ixVar, String str, String str2, String str3) {
        this.d = ixVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        SharedPreferences.Editor edit = ix.a(this.d).getSharedPreferences(this.a, 4).edit();
        edit.putString(this.b, this.c);
        edit.commit();
    }
}
