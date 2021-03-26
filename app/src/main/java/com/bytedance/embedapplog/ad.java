package com.bytedance.embedapplog;

import android.content.Context;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

class ad extends u {
    private final Context e;

    ad(Context context) {
        super(true, true);
        this.e = context;
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        aa.a(jSONObject, "language", this.e.getResources().getConfiguration().locale.getLanguage());
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            rawOffset = 12;
        }
        jSONObject.put("timezone", rawOffset);
        aa.a(jSONObject, "region", Locale.getDefault().getCountry());
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        aa.a(jSONObject, "tz_name", timeZone.getID());
        jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis() / 1000));
        return true;
    }
}
