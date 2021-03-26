package com.ut.mini.internal;

import android.text.TextUtils;
import com.ut.mini.UTHitBuilders;
import java.util.Map;

public class UTOriginalCustomHitBuilder extends UTHitBuilders.UTHitBuilder {
    public UTOriginalCustomHitBuilder(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            super.setProperty("_field_page", str);
        }
        super.setProperty("_field_event_id", "" + i);
        if (!TextUtils.isEmpty(str2)) {
            super.setProperty("_field_arg1", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            super.setProperty("_field_arg2", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            super.setProperty("_field_arg3", str4);
        }
        super.setProperties(map);
    }
}
