package com.xiaomi.mipush.sdk;

import com.xiaomi.push.gi;

/* synthetic */ class ap {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[gi.values().length];
        a = iArr;
        try {
            iArr[gi.SendMessage.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[gi.Registration.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[gi.UnRegistration.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[gi.Subscription.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[gi.UnSubscription.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[gi.Command.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[gi.Notification.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
