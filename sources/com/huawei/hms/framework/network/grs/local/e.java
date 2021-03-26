package com.huawei.hms.framework.network.grs.local;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class e {
    public static final Set<String> a = Collections.unmodifiableSet(new HashSet<String>(16) {
        /* class com.huawei.hms.framework.network.grs.local.e.AnonymousClass1 */

        {
            add("ser_country");
            add("reg_country");
            add("issue_country");
        }
    });
    private static final String b = "e";

    public static String a(String str, GrsBaseInfo grsBaseInfo) {
        if (TextUtils.isEmpty(str)) {
            Logger.w(b, "routeBy must be not empty string or null.");
            return null;
        } else if (!"no_route".equals(str) && !"unconditional".equals(str)) {
            return b(str, grsBaseInfo);
        } else {
            Logger.v(b, "routeBy equals NO_ROUTE_POLICY");
            return "no_route_country";
        }
    }

    private static String b(String str, GrsBaseInfo grsBaseInfo) {
        String serCountry = grsBaseInfo.getSerCountry();
        String regCountry = grsBaseInfo.getRegCountry();
        String issueCountry = grsBaseInfo.getIssueCountry();
        String[] split = str.split(">");
        for (String str2 : split) {
            if (a.contains(str2.trim())) {
                if ("ser_country".equals(str2.trim()) && !TextUtils.isEmpty(serCountry)) {
                    return serCountry;
                }
                if ("reg_country".equals(str2.trim()) && !TextUtils.isEmpty(regCountry)) {
                    return regCountry;
                }
                if ("issue_country".equals(str2.trim()) && !TextUtils.isEmpty(issueCountry)) {
                    return issueCountry;
                }
            }
        }
        return "";
    }
}
