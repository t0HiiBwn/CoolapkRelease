package com.alibaba.baichuan.trade.biz.utils;

import android.content.SharedPreferences;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class AlibcSPUtil {
    private static final String a = "AlibcSPUtil";

    public static AlibcSPData getJSONConfigDo(String str) {
        JSONException e;
        AlibcSPData alibcSPData = null;
        String string = AlibcTradeCommon.context.getSharedPreferences(str, 0).getString(str, null);
        String str2 = a;
        AlibcLogger.d(str2, "SP里面的值为:" + string);
        if (string == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            AlibcSPData alibcSPData2 = new AlibcSPData();
            try {
                alibcSPData2.formatFromJSON(jSONObject);
                return alibcSPData2;
            } catch (JSONException e2) {
                e = e2;
                alibcSPData = alibcSPData2;
                String str3 = a;
                AlibcLogger.e(str3, "拼接json出错" + e.getMessage());
                return alibcSPData;
            }
        } catch (JSONException e3) {
            e = e3;
            String str3 = a;
            AlibcLogger.e(str3, "拼接json出错" + e.getMessage());
            return alibcSPData;
        }
    }

    public static void setConfigSPData(String str, AlibcSPData alibcSPData) {
        SharedPreferences.Editor edit = AlibcTradeCommon.context.getSharedPreferences(str, 0).edit();
        JSONObject jSONObject = new JSONObject();
        for (String str2 : alibcSPData.getConfigData().keySet()) {
            try {
                jSONObject.put(str2, new JSONObject(alibcSPData.getConfigData().get(str2)));
            } catch (JSONException e) {
                String str3 = a;
                AlibcLogger.e(str3, "拼接json出错" + e.getMessage());
            }
        }
        edit.putString(str, jSONObject.toString());
        edit.apply();
    }

    public static void setConfigSPData(String str, JSONObject jSONObject) {
        SharedPreferences.Editor edit = AlibcTradeCommon.context.getSharedPreferences(str, 0).edit();
        edit.putString(str, jSONObject.toString());
        edit.apply();
    }
}
