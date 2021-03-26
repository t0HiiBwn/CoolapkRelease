package com.huawei.updatesdk.service.a;

public class c extends com.huawei.updatesdk.a.b.d.a.c {
    private int isUpdateSdk_ = 1;
    private String locale_ = null;
    private int serviceType_ = 0;
    private String ts_ = null;

    private void d(String str) {
        this.ts_ = str;
    }

    @Override // com.huawei.updatesdk.a.b.d.a.c
    protected void c() {
        d(String.valueOf(System.currentTimeMillis()));
    }

    public void n(String str) {
        this.locale_ = str;
    }

    public String toString() {
        return getClass().getName() + " {\n\tmethod_: " + a() + "\n}";
    }
}
