package com.alibaba.alibclinkpartner.smartlink;

import com.alibaba.alibclinkpartner.smartlink.a.a;
import com.alibaba.alibclinkpartner.smartlink.a.b;
import com.alibaba.alibclinkpartner.smartlink.data.SmartLinkSwitch;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.f;
import java.util.Map;
import org.json.JSONObject;

final class c implements Runnable {
    c() {
    }

    @Override // java.lang.Runnable
    public void run() {
        f.a("smart_link_switch_time", Long.valueOf(System.currentTimeMillis()));
        b a = a.a("https://userlink.alicdn.com/smart_link/android/alsl_switch_config.json", (Map<String, String>) null);
        if (a.a == 200) {
            try {
                JSONObject jSONObject = new JSONObject(a.b);
                SmartLinkSwitch smartLinkSwitch = new SmartLinkSwitch();
                smartLinkSwitch.smartLinkSwitch = jSONObject.getBoolean("smartLinkSwitch");
                smartLinkSwitch.smartLinkGray = jSONObject.getInt("smartLinkGray");
                f.c("smart_link_switch", smartLinkSwitch);
                ALSLLogUtil.d("ALSLSmartLinkSDK", "getSmartLinkSwitch", "拉到的开关数据：" + smartLinkSwitch);
            } catch (Exception unused) {
            }
        }
    }
}
