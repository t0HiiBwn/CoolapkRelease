package com.umeng.tunnel;

import android.content.Context;
import android.util.Log;
import java.util.Map;

public class UMChannelAgent {
    private static final String TAG = "UMChannelAgent";
    private static final String UMENG_VCHANNEL = "com.umeng.commonsdk.vchannel.Sender";
    private static boolean vChannelReady = true;

    static {
        try {
            if (Class.forName("com.umeng.commonsdk.vchannel.Sender") != null) {
            }
        } catch (Throwable unused) {
        }
    }

    private static void reflectOnEvent(Context context, String str, Map<String, Object> map) {
        try {
            Class.forName("com.umeng.commonsdk.vchannel.Sender").getMethod("onEvent", Context.class, String.class, Map.class).invoke(null, context, str, map);
        } catch (ClassNotFoundException unused) {
            Log.e("UMChannelAgent", "--->>> Can not find class com.umeng.commonsdk.vchannel.sender .");
        } catch (NoSuchMethodException unused2) {
            Log.e("UMChannelAgent", "--->>> Can not find method onEvent .");
        } catch (SecurityException unused3) {
            Log.e("UMChannelAgent", "--->>> Security exception is thrown when we find onEvent method !");
        } catch (Exception unused4) {
            Log.e("UMChannelAgent", "--->>> Exception is thrown when onEvent method is called !");
        }
    }

    private static void reflectSetCustomHeader(Map<String, String> map) {
        try {
            Class.forName("com.umeng.commonsdk.vchannel.Sender").getMethod("setCustomHeader", Map.class).invoke(null, map);
        } catch (ClassNotFoundException unused) {
            Log.e("UMChannelAgent", "--->>> Can not find class com.umeng.commonsdk.vchannel.sender .");
        } catch (NoSuchMethodException unused2) {
            Log.e("UMChannelAgent", "--->>> Can not find method setCustomHeader .");
        } catch (SecurityException unused3) {
            Log.e("UMChannelAgent", "--->>> Security exception is thrown when we find setCustomHeader method !");
        } catch (Exception unused4) {
            Log.e("UMChannelAgent", "--->>> Exception is thrown when setCustomHeader method is called !");
        }
    }

    public static boolean init() {
        if (!vChannelReady) {
            Log.e("UMChannelAgent", "--->>> Umeng tunnel module depends on common library, please integrate common first.");
        }
        return vChannelReady;
    }

    public static void setCustomHeader(Map<String, String> map) {
        reflectSetCustomHeader(map);
    }

    public static void onDebugEvent(Context context, String str, Map<String, Object> map) {
        reflectOnEvent(context, str, map);
    }
}
