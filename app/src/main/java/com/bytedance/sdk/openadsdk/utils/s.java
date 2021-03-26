package com.bytedance.sdk.openadsdk.utils;

import java.util.List;

/* compiled from: ListUtils */
public class s {
    public static boolean a(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static boolean b(List<?> list) {
        return !a(list);
    }
}
