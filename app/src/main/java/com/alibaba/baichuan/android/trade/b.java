package com.alibaba.baichuan.android.trade;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcPidTaokeComponent;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeTraceCallback;
import com.alibaba.baichuan.trade.biz.core.usertracker.UserTrackerConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b {
    public Map<String, String> a;
    private String b;

    public b(String str) {
        this.b = str;
    }

    public void a(AlibcTradeTaokeParam alibcTradeTaokeParam, AlibcTradeContext alibcTradeContext, AlibcTaokeTraceCallback alibcTaokeTraceCallback) {
        if (!TextUtils.isEmpty(this.b)) {
            boolean z = false;
            for (String str : AlibcContext.detailPatterns) {
                if (this.b.matches(str)) {
                    z = true;
                }
            }
            if (z) {
                Matcher matcher = Pattern.compile("(\\?|&)id=([^&?]*)").matcher(this.b);
                String str2 = null;
                if (matcher.find()) {
                    String group2 = matcher.group();
                    str2 = group2.substring(group2.indexOf(61) + 1);
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("itemId", str2);
                AlibcPidTaokeComponent.INSTANCE.genUrlAndTaokeTrace(hashMap, b(), true, alibcTradeTaokeParam, d(), alibcTaokeTraceCallback);
            }
        }
    }

    public boolean a() {
        return (getClass().getSuperclass() != null && getClass().getSuperclass().getName().equals(b.class.getName())) || this.b != null;
    }

    public String b() {
        if (URLUtil.isNetworkUrl(this.b)) {
            return this.b.trim();
        }
        return null;
    }

    public boolean c() {
        return true;
    }

    public String d() {
        return UserTrackerConstants.E_SHOWPAGE;
    }

    public Map<String, String> e() {
        return this.a;
    }

    public String f() {
        return "url";
    }
}
