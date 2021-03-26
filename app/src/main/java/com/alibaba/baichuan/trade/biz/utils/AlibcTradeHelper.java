package com.alibaba.baichuan.trade.biz.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.biz.AlibcTradeBiz;
import com.alibaba.baichuan.trade.biz.applink.adapter.AlibcFailModeType;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeParams;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcCodeUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONArray;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlibcTradeHelper {
    public static List<String> firstLevelKeys = Arrays.asList("isv_code", "scm", "pvid");

    private static String a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        map.put("ttid", AlibcTradeBiz.getTTID());
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (i != 0) {
                sb.append("&");
            }
            try {
                sb.append(str);
                sb.append("=");
                sb.append(URLEncoder.encode(str2, "utf-8"));
                i++;
            } catch (Exception e) {
                AlibcLogger.e("AlibcTradeHelper", "构建Ybhpss参数错误：" + e.getMessage());
                return null;
            }
        }
        return !TextUtils.isEmpty(sb) ? AlibcCodeUtils.getBase64(new String(sb), 2) : sb.toString();
    }

    public static Map<String, String> createUrlParams(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", AlibcTradeBiz.getTTID());
        hashMap.put("umpChannel", "1-" + AlibcTradeCommon.getAppKey());
        hashMap.put("u_channel", "1-" + AlibcTradeCommon.getAppKey());
        if (!(map == null || map.size() == 0)) {
            String str = map.get("isv_code");
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("isv_code", str);
            }
            HashMap hashMap2 = new HashMap();
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null && !TextUtils.isEmpty(str3)) {
                    if (firstLevelKeys.contains(str2)) {
                        hashMap.put(str2, str3);
                    } else {
                        hashMap2.put(str2, str3);
                    }
                }
            }
            hashMap2.put("ttid", AlibcTradeBiz.getTTID());
            String a = a(hashMap2);
            if (a != null && !TextUtils.isEmpty(a)) {
                hashMap.put("ybhpss", a);
            }
        }
        return hashMap;
    }

    public static void putTaokeParam2Map(Map<String, String> map, AlibcTaokeParams alibcTaokeParams) {
        if (alibcTaokeParams != null) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (alibcTaokeParams.pid != null) {
                map.put("pid", alibcTaokeParams.pid);
            }
            if (alibcTaokeParams.subPid != null) {
                map.put("subpid", alibcTaokeParams.subPid);
            }
            if (alibcTaokeParams.unionId != null) {
                map.put("unionId", alibcTaokeParams.unionId);
            }
        }
    }

    public static String setUrlByFailMode(AlibcFailModeType alibcFailModeType, String str, String str2) {
        return (TextUtils.isEmpty(str) || !alibcFailModeType.equals(AlibcFailModeType.AlibcNativeFailModeJumpH5)) ? str2 : str;
    }

    public static boolean verifyUrl(JSONArray jSONArray, String str) {
        try {
            Uri parse = Uri.parse(str);
            String authority = parse.getAuthority();
            String path = parse.getPath();
            if (jSONArray != null && jSONArray.size() > 0) {
                for (int i = 0; i < jSONArray.size(); i++) {
                    Uri parse2 = Uri.parse(String.valueOf(jSONArray.get(i)));
                    String authority2 = parse2.getAuthority();
                    String path2 = parse2.getPath();
                    if (!TextUtils.isEmpty(authority) && authority.equals(authority2) && path != null) {
                        if (path.length() == 0 || "/".equals(path)) {
                            if (path2 != null && (path2.length() == 0 || "/".equals(path2))) {
                                return true;
                            }
                        } else if (path.equals(path2)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            AlibcLogger.e("AlibcTradeHelper", "url parse fail: msg = " + e.getMessage());
        }
        return false;
    }
}
