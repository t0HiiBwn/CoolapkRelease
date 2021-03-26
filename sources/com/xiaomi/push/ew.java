package com.xiaomi.push;

import android.text.TextUtils;

public enum ew {
    COMMAND_REGISTER("register"),
    COMMAND_UNREGISTER("unregister"),
    COMMAND_SET_ALIAS("set-alias"),
    COMMAND_UNSET_ALIAS("unset-alias"),
    COMMAND_SET_ACCOUNT("set-account"),
    COMMAND_UNSET_ACCOUNT("unset-account"),
    COMMAND_SUBSCRIBE_TOPIC("subscribe-topic"),
    COMMAND_UNSUBSCRIBE_TOPIC("unsubscibe-topic"),
    COMMAND_SET_ACCEPT_TIME("accept-time"),
    COMMAND_CHK_VDEVID("check-vdeviceid");
    

    /* renamed from: a  reason: collision with other field name */
    public final String f419a;

    private ew(String str) {
        this.f419a = str;
    }

    public static int a(String str) {
        int i = -1;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        ew[] values = values();
        for (ew ewVar : values) {
            if (ewVar.f419a.equals(str)) {
                i = em.a(ewVar);
            }
        }
        return i;
    }
}
